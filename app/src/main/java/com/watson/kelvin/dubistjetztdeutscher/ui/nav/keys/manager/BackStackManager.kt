package com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.manager

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey

/**
 * Generic back stack manager for the [com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey]s. Can be used by any navigation key type that
 * manages its own back stack (e.g., bottom bar, side drawer, separate screen). TopLevelKey denotes
 * is capable of housing its own nested navigation.
 */
class BackStackManager<K : AppNavKey>(startKey: K): BackStackManagement<K> {
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
     *   1. Starts at Overview (masterStack: [com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey.Overview] to [com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey.Overview])
     *   2. Navigates to Grammar (masterStack: [com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey.Grammar] to [com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey.Grammar])
     *   3. From Grammar, goes to Prepositions (masterStack: [com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey.Grammar] to [[com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey.Grammar], [com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Grammar.Prepositions])
     *   4. Switches back to Overview (stack: [com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey.Overview])
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

    /**
     * Expose the current top level route for consumers.
     */
    private val _currentKey = mutableStateOf(startKey)
    override var currentKey: K
        get() = _currentKey.value
        private set(value) {
            _currentKey.value = value
        }

    /**
     * The back stack value for the associated with the [currentKey]. See [masterStack].
     *
     * Flattened view of the current top-level bottom bar selection's stack that
     * [androidx.navigation3.ui.NavDisplay] observes.
     */
    override val subBackStack: SnapshotStateList<K> = mutableStateListOf(startKey)

    /**
     * Private helper to update the [masterStack] whenever a change occurs.
     */
    private fun updateBackStack() {
        with(subBackStack) {
            clear()
            // Add all keys from the current top-level route's stack to the masterBackStack
            // Use flatMap to get all items from all stacks, but only the *last*
            // top-level stack in the LinkedHashMap is actively displayed by NavDisplay.
            // The magic happens when we switch tabs, and 'topLevelKey' changes,
            // which then drives 'updateBackStack'.
            addAll(masterStack[currentKey] ?: mutableStateListOf())
        }
    }

    // Navigates to a top-level tab
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
        currentKey = key // Update the currently active top-level tab
        updateBackStack() // Re-sync the NavDisplay's back stack
    }

    // Adds a screen (e.g., a detail screen) within the current top-level tab's stack
    override fun add(key: K) {
        masterStack[currentKey]?.add(key)
        updateBackStack() // Re-sync the NavDisplay's back stack
    }

    // Handles back events
    override fun removeLast(closeApp: () -> Unit) {
        val currentTabStack = masterStack[currentKey]
        if (currentTabStack?.size!! > 1) {
            // If there's nested navigation within the current tab, pop from its stack
            currentTabStack.removeLastOrNull()
        } else {
            // If at the root of the current tab, and there are other tabs visited,
            // go back to the previous top-level tab.
            if (masterStack.size > 1) {
                masterStack.remove(currentKey) // Remove current tab from visited order
                currentKey = masterStack.keys.last() // Switch to the previously active tab
            } else {
                // close app
                closeApp()
            }
        }
        updateBackStack() // Re-sync the NavDisplay's back stack
    }
}