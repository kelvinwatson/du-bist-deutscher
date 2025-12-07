package com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.manager

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import kotlinx.coroutines.flow.StateFlow

/**
 * Interface for managing navigation back stacks.
 * Provides functionality for navigating between top-level routes and nested screens,
 * maintaining separate navigation history for each top-level route.
 */
interface BackStackManagement<K : AppNavKey> {

    /**
     * The current active top-level navigation key.
     */
    val currentTopLevelKeyFlow: StateFlow<K>

    /**
     * The current sub/nested level navigation key.
     */
    val currentSubLevelKeyFlow: StateFlow<K>

    /**
     * The flattened back stack for the current top-level route.
     * This is observed by NavDisplay to render the current navigation state.
     */
    val subBackStack: SnapshotStateList<K>

    /**
     * Navigates to a top-level route (e.g., switching tabs in bottom navigation).
     * If the route has been visited before, its previous stack state is restored.
     *
     * @param key The top-level navigation key to navigate to
     */
    fun addTopLevel(key: K)

    /**
     * Adds a nested screen to the current top-level route's navigation stack.
     *
     * @param key The navigation key to add to the stack
     */
    fun add(key: K)

    /**
     * Handles back navigation by removing the last entry from the navigation stack.
     * If at the root of a top-level route and multiple routes have been visited,
     * navigates back to the previous top-level route.
     * If at the root of the only visited route, invokes the closeApp callback.
     *
     * @param closeApp Callback to invoke when there are no more screens to navigate back to
     */
    fun removeLast(closeApp: () -> Unit = {})
}