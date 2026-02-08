package com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.manager

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey.Grammar
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey.Overview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Generic back stack manager for the [AppNavKey]s. Can be used by any navigation key type that
 * manages its own back stack (e.g., bottom bar, side drawer, separate screen). TopLevelKey denotes
 * is capable of housing its own nested navigation.
 */
class BackStackManager<K : AppNavKey>(startKey: K) : BackStackManagement<K> {
    /**
     * A separate stack for each top-level route, for providing nested navigation. A [LinkedHashMap]
     * keeps track of the order tabs were visited for back behavior across tabs (see [removeLast].
     * Each entry stores a top-level route (Overview, Grammar, Profile) as a key, and its value is a
     * [androidx.compose.runtime.snapshots.SnapshotStateList] representing that route's own nested navigation history.
     *
     * This could be thought of as a map of tab -> stack of screens within that tab.
     *
     * For example, if the user navigates as follows:
     *
     *   1. Starts at Overview (masterStack: [Overview] to [Overview])
     *   2. Navigates to Grammar (masterStack: [Grammar] to [Grammar])
     *   3. From Grammar, goes to CaseRules (masterStack: [CaseRules] to [[Grammar], [CaseRules])
     *   4. Switches back to Overview (stack: [Overview])
     *
     * With the above use case, the `masterStack` would look like this:
     * {
     *    "Overview": ["Overview"],
     *    "Grammar": ["Grammar", "Prepositions"]
     *  }
     */
    private var masterStack: LinkedHashMap<K, SnapshotStateList<K>> = linkedMapOf(
        startKey to mutableStateListOf(startKey) // Each tab starts with its own key
    )

    private val currentTopLevelKey: K
        get() = currentTopLevelKeyFlow.value

    private var currentTopLevelKeyFlowMutable: MutableStateFlow<K> = MutableStateFlow(startKey)

    /**
     * Expose the current top level route for consumers.
     */
    override val currentTopLevelKeyFlow: StateFlow<K> = currentTopLevelKeyFlowMutable.asStateFlow()

    /**
     * The current sub-level key represents the actual screen being displayed.
     * Updated automatically in updateBackStack() whenever navigation occurs.
     */
    private var currentSubLevelKeyFlowMutable: MutableStateFlow<K> = MutableStateFlow(startKey)
    override val currentSubLevelKeyFlow: StateFlow<K> = currentSubLevelKeyFlowMutable.asStateFlow()

    /**
     * The back stack value for the associated with the [currentTopLevelKeyFlow]. See [masterStack].
     *
     * Flattened view of the current top-level bottom bar selection's stack that
     * [androidx.navigation3.ui.NavDisplay] observes.
     */
    override val subBackStack: SnapshotStateList<K> = mutableStateListOf(startKey)

    /**
     * Private helper to update all derived state whenever a navigation change occurs.
     * This is the single source of truth for state updates.
     *
     * @param newTopLevelKey Optional new top-level key to switch to. If provided, updates currentTopLevelKeyFlow.
     */
    private fun updateBackStack(newTopLevelKey: K? = null) {
        // Update the top-level key if a new one is provided
        newTopLevelKey?.let { currentTopLevelKeyFlowMutable.value = it }

        with(subBackStack) {
            clear()
            // Add all keys from the current top-level route's stack to the masterBackStack
            // Use flatMap to get all items from all stacks, but only the *last*
            // top-level stack in the LinkedHashMap is actively displayed by NavDisplay.
            // On tab switch, the 'topLevelKey' changes, which then drives 'updateBackStack'.
            addAll(masterStack[currentTopLevelKeyFlow.value] ?: mutableStateListOf())

            // Update the current sub-level key based on the last item in the stack
            lastOrNull()?.let { currentSubLevelKeyFlowMutable.value = it }
        }
    }

    /**
     * Navigates to a top-level tab
     * @param key The top-level navigation key to navigate to
     */
    override fun addTopLevel(key: K) {
        if (masterStack[key] == null) {
            // If the tab hasn't been visited before, create its stack
            masterStack[key] = mutableStateListOf(key)
        } else {
            // If already visited, ensure it's the last (most recent) in the LinkedHashMap
            // This is crucial for cross-tab back behavior
            val stack = masterStack.remove(key)
            stack?.let { masterStack[key] = it }
        }
        updateBackStack(newTopLevelKey = key) // Update all derived state in one place
    }

    // Adds a screen (e.g., a detail screen) within the current top-level tab's stack
    override fun add(key: K) {
        masterStack[currentTopLevelKey]?.add(key)
        updateBackStack() // Re-sync the NavDisplay's back stack
    }

    // Handles back events
    override fun removeLast(closeApp: () -> Unit) {
        val currentTabStack = masterStack[currentTopLevelKey]
        if (currentTabStack != null && currentTabStack.size > 1) {
            // If there's nested navigation within the current tab, pop from its stack
            currentTabStack.removeLastOrNull()
            updateBackStack() // Update derived state
        } else {
            // If at the root of the current tab, and there are other tabs visited,
            // go back to the previous top-level tab.
            if (masterStack.size > 1) {
                masterStack.remove(currentTopLevelKey) // Remove current tab from visited order
                val newTopLevelKey = masterStack.keys.last() // Get the previously active tab
                updateBackStack(newTopLevelKey = newTopLevelKey) // Update derived state
            } else {
                // close app
                closeApp()
            }
        }
    }
}