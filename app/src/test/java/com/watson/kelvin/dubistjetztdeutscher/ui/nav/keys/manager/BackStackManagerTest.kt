package com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.manager

import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Grammar
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Comprehensive unit tests for [BackStackManager].
 *
 * Tests cover:
 * - Initialization state
 * - Top-level navigation (tab switching)
 * - Nested navigation (adding screens within tabs)
 * - Back navigation (both nested and cross-tab)
 * - State consistency across all flows and stacks
 */
class BackStackManagerTest {

    private lateinit var backStackManager: BackStackManager<AppNavKey>

    @Before
    fun setup() {
        // Initialize with Overview as the starting key
        backStackManager = BackStackManager(BottomBarKey.Overview)
    }

    // ========== Initialization Tests ==========

    @Test
    fun `initial state should be set correctly`() = runTest {
        // Assert initial state
        assertEquals(BottomBarKey.Overview, backStackManager.currentTopLevelKeyFlow.value)
        assertEquals(BottomBarKey.Overview, backStackManager.currentSubLevelKeyFlow.value)
        assertEquals(listOf(BottomBarKey.Overview), backStackManager.subBackStack)
    }

    // ========== Top-Level Navigation Tests ==========

    @Test
    fun `addTopLevel should navigate to new tab and create its stack`() = runTest {
        // Navigate to Grammar tab
        backStackManager.addTopLevel(BottomBarKey.Grammar)

        // Assert state after navigation
        assertEquals(BottomBarKey.Grammar, backStackManager.currentTopLevelKeyFlow.value)
        assertEquals(BottomBarKey.Grammar, backStackManager.currentSubLevelKeyFlow.value)
        assertEquals(listOf(BottomBarKey.Grammar), backStackManager.subBackStack)
    }

    @Test
    fun `addTopLevel should restore previous stack when returning to visited tab`() = runTest {
        // Navigate to Grammar and add nested screen
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        backStackManager.add(Grammar.Prepositions)

        // Navigate to Account
        backStackManager.addTopLevel(BottomBarKey.Account)

        // Navigate back to Grammar
        backStackManager.addTopLevel(BottomBarKey.Grammar)

        // Assert Grammar's stack is restored with nested screen
        assertEquals(BottomBarKey.Grammar, backStackManager.currentTopLevelKeyFlow.value)
        assertEquals(Grammar.Prepositions, backStackManager.currentSubLevelKeyFlow.value)
        assertEquals(listOf(BottomBarKey.Grammar, Grammar.Prepositions), backStackManager.subBackStack)
    }

    @Test
    fun `addTopLevel should update tab visit order for back navigation`() = runTest {
        // Visit tabs in order: Overview -> Grammar -> Account
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        backStackManager.addTopLevel(BottomBarKey.Account)

        // Go back to Grammar (should move it to end of visit order)
        backStackManager.addTopLevel(BottomBarKey.Grammar)

        // Now removeLast from Grammar should go to Account (previous in visit order)
        backStackManager.removeLast {}

        assertEquals(BottomBarKey.Account, backStackManager.currentTopLevelKeyFlow.value)
    }

    // ========== Nested Navigation Tests ==========

    @Test
    fun `add should add nested screen to current tab's stack`() = runTest {
        // Navigate to Grammar tab
        backStackManager.addTopLevel(BottomBarKey.Grammar)

        // Add nested screen
        backStackManager.add(Grammar.Prepositions)

        // Assert nested screen is added
        assertEquals(BottomBarKey.Grammar, backStackManager.currentTopLevelKeyFlow.value)
        assertEquals(Grammar.Prepositions, backStackManager.currentSubLevelKeyFlow.value)
        assertEquals(listOf(BottomBarKey.Grammar, Grammar.Prepositions), backStackManager.subBackStack)
    }

    @Test
    fun `add should support multiple nested screens`() = runTest {
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        backStackManager.add(Grammar.Prepositions)
        backStackManager.add(Grammar.Prepositions) // Add again for testing

        // Assert stack contains all nested screens
        assertEquals(3, backStackManager.subBackStack.size)
        assertEquals(Grammar.Prepositions, backStackManager.currentSubLevelKeyFlow.value)
    }

    // ========== Back Navigation Tests (Nested) ==========

    @Test
    fun `removeLast should pop nested screen when stack size greater than 1`() = runTest {
        // Setup: Grammar with nested Prepositions
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        backStackManager.add(Grammar.Prepositions)

        // Go back
        backStackManager.removeLast {}

        // Assert back to Grammar root
        assertEquals(BottomBarKey.Grammar, backStackManager.currentTopLevelKeyFlow.value)
        assertEquals(BottomBarKey.Grammar, backStackManager.currentSubLevelKeyFlow.value)
        assertEquals(listOf(BottomBarKey.Grammar), backStackManager.subBackStack)
    }

    @Test
    fun `removeLast should pop multiple nested screens correctly`() = runTest {
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        backStackManager.add(Grammar.Prepositions)
        backStackManager.add(Grammar.Prepositions) // Add twice

        // First back
        backStackManager.removeLast {}
        assertEquals(2, backStackManager.subBackStack.size)

        // Second back
        backStackManager.removeLast {}
        assertEquals(1, backStackManager.subBackStack.size)
        assertEquals(BottomBarKey.Grammar, backStackManager.currentSubLevelKeyFlow.value)
    }

    // ========== Back Navigation Tests (Cross-Tab) ==========

    @Test
    fun `removeLast should switch to previous tab when at root of current tab`() = runTest {
        // Visit two tabs
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        backStackManager.addTopLevel(BottomBarKey.Account)

        // Go back from Account root
        backStackManager.removeLast {}

        // Should be back at Grammar
        assertEquals(BottomBarKey.Grammar, backStackManager.currentTopLevelKeyFlow.value)
        assertEquals(BottomBarKey.Grammar, backStackManager.currentSubLevelKeyFlow.value)
    }

    @Test
    fun `removeLast should navigate through multiple tabs in reverse order`() = runTest {
        // Visit: Overview -> Grammar -> Account
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        backStackManager.addTopLevel(BottomBarKey.Account)

        // Back to Grammar
        backStackManager.removeLast {}
        assertEquals(BottomBarKey.Grammar, backStackManager.currentTopLevelKeyFlow.value)

        // Back to Overview
        backStackManager.removeLast {}
        assertEquals(BottomBarKey.Overview, backStackManager.currentTopLevelKeyFlow.value)
    }

    @Test
    fun `removeLast should preserve nested stacks when switching between tabs`() = runTest {
        // Grammar with nested screen
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        backStackManager.add(Grammar.Prepositions)

        // Switch to Account and back
        backStackManager.addTopLevel(BottomBarKey.Account)
        backStackManager.removeLast {}

        // Grammar's nested stack should be preserved
        assertEquals(BottomBarKey.Grammar, backStackManager.currentTopLevelKeyFlow.value)
        assertEquals(Grammar.Prepositions, backStackManager.currentSubLevelKeyFlow.value)
        assertEquals(listOf(BottomBarKey.Grammar, Grammar.Prepositions), backStackManager.subBackStack)
    }

    // ========== Close App Tests ==========

    @Test
    fun `removeLast should call closeApp when at last tab root`() = runTest {
        val closeApp: () -> Unit = mockk(relaxed = true)

        // At initial Overview root
        backStackManager.removeLast(closeApp)

        // Should call closeApp
        verify(exactly = 1) { closeApp() }
    }

    @Test
    fun `removeLast should not call closeApp when nested screens exist`() = runTest {
        val closeApp: () -> Unit = mockk(relaxed = true)

        // Add nested screen
        backStackManager.add(Grammar.Prepositions)

        // Go back (should just pop nested screen, not close app)
        backStackManager.removeLast(closeApp)

        // Should NOT call closeApp
        verify(exactly = 0) { closeApp() }
    }

    @Test
    fun `removeLast should not call closeApp when multiple tabs exist`() = runTest {
        val closeApp: () -> Unit = mockk(relaxed = true)

        // Visit another tab
        backStackManager.addTopLevel(BottomBarKey.Grammar)

        // Go back
        backStackManager.removeLast(closeApp)

        // Should NOT call closeApp (should switch tabs instead)
        verify(exactly = 0) { closeApp() }
        assertEquals(BottomBarKey.Overview, backStackManager.currentTopLevelKeyFlow.value)
    }

    // ========== State Consistency Tests ==========

    @Test
    fun `currentSubLevelKeyFlow should always reflect last item in subBackStack`() = runTest {
        // Initial state
        assertEquals(
            backStackManager.subBackStack.lastOrNull(),
            backStackManager.currentSubLevelKeyFlow.value
        )

        // After top-level navigation
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        assertEquals(
            backStackManager.subBackStack.lastOrNull(),
            backStackManager.currentSubLevelKeyFlow.value
        )

        // After nested navigation
        backStackManager.add(Grammar.Prepositions)
        assertEquals(
            backStackManager.subBackStack.lastOrNull(),
            backStackManager.currentSubLevelKeyFlow.value
        )

        // After back navigation
        backStackManager.removeLast {}
        assertEquals(
            backStackManager.subBackStack.lastOrNull(),
            backStackManager.currentSubLevelKeyFlow.value
        )
    }

    @Test
    fun `subBackStack should only contain screens from current top-level tab`() = runTest {
        // Grammar with nested screen
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        backStackManager.add(Grammar.Prepositions)

        // Switch to Account
        backStackManager.addTopLevel(BottomBarKey.Account)

        // subBackStack should only have Account, not Grammar or Prepositions
        assertEquals(listOf(BottomBarKey.Account), backStackManager.subBackStack)
    }

    @Test
    fun `all flows and stacks should update consistently on any navigation action`() = runTest {
        // Complex navigation scenario
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        backStackManager.add(Grammar.Prepositions)
        backStackManager.addTopLevel(BottomBarKey.Account)
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        backStackManager.removeLast {}

        // Verify consistency
        assertEquals(BottomBarKey.Grammar, backStackManager.currentTopLevelKeyFlow.value)
        assertEquals(BottomBarKey.Grammar, backStackManager.currentSubLevelKeyFlow.value)
        assertEquals(listOf(BottomBarKey.Grammar), backStackManager.subBackStack)
    }

    // ========== Edge Cases ==========

    @Test
    fun `removeLast should handle null currentTabStack gracefully`() = runTest {
        // This shouldn't happen in normal operation, but test defensive behavior
        val closeApp: () -> Unit = mockk(relaxed = true)

        // Try to remove when at initial state
        backStackManager.removeLast(closeApp)

        // Should call closeApp since we're at root of only tab
        verify(exactly = 1) { closeApp() }
    }

    @Test
    fun `navigation to same tab should be idempotent in state`() = runTest {
        backStackManager.addTopLevel(BottomBarKey.Grammar)
        val stateBefore = Triple(
            backStackManager.currentTopLevelKeyFlow.value,
            backStackManager.currentSubLevelKeyFlow.value,
            backStackManager.subBackStack.toList()
        )

        // Navigate to same tab again
        backStackManager.addTopLevel(BottomBarKey.Grammar)

        val stateAfter = Triple(
            backStackManager.currentTopLevelKeyFlow.value,
            backStackManager.currentSubLevelKeyFlow.value,
            backStackManager.subBackStack.toList()
        )

        // State should be same (except visit order internally)
        assertEquals(stateBefore, stateAfter)
    }
}

