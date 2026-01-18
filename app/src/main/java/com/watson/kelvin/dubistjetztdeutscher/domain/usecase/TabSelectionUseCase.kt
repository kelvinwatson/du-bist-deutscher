package com.watson.kelvin.dubistjetztdeutscher.domain.usecase

import com.watson.kelvin.dubistjetztdeutscher.ui.model.Tab
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Use case interface for managing tab selection logic.
 * Provides reusable tab navigation functionality that can be used across different screens.
 *
 * @param T The type of tab, must implement the [Tab] interface
 */
interface TabSelectionUseCase<T : Tab> {
    val selectedTabIndex: StateFlow<Int>
    val currentTab: T
    val tabs: List<T>

    fun selectTab(index: Int)
    fun selectNextTab()
    fun selectPreviousTab()
    fun reset()
}

/**
 * Default implementation of [TabSelectionUseCase].
 *
 * @param tabs The list of available tabs
 */
class TabSelectionUseCaseImpl<T : Tab>(
    override val tabs: List<T>
) : TabSelectionUseCase<T> {
    private val _selectedTabIndex = MutableStateFlow(0)
    override val selectedTabIndex: StateFlow<Int> = _selectedTabIndex.asStateFlow()

    /**
     * Gets the currently selected tab.
     */
    override val currentTab: T
        get() = tabs[_selectedTabIndex.value]

    /**
     * Selects a tab by index.
     * If the index is out of bounds, defaults to the first tab (index 0).
     *
     * @param index The index of the tab to select
     */
    override fun selectTab(index: Int) {
        if (index in tabs.indices) {
            _selectedTabIndex.value = index
        } else {
            reset()
        }
    }

    /**
     * Selects the next tab in the list.
     * Wraps around to the first tab if currently on the last tab.
     */
    override fun selectNextTab() {
        _selectedTabIndex.value = (_selectedTabIndex.value + 1) % tabs.size
    }

    /**
     * Selects the previous tab in the list.
     * Wraps around to the last tab if currently on the first tab.
     */
    override fun selectPreviousTab() {
        _selectedTabIndex.value = if (_selectedTabIndex.value == 0) {
            tabs.size - 1
        } else {
            _selectedTabIndex.value - 1
        }
    }

    /**
     * Resets the selection to the first tab.
     */
    override fun reset() {
        _selectedTabIndex.value = 0
    }
}

