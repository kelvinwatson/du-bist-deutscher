package com.watson.kelvin.dubistjetztdeutscher.ui.component.adjectives

import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectiveCategory
import com.watson.kelvin.dubistjetztdeutscher.ui.component.state.UiState

/**
 * UI state for the Adjectives screen.
 */
sealed class AdjectivesUiState : UiState {
    data class Success(
        val searchQuery: String,
        val filteredCategories: List<Pair<AdjectiveCategory, List<Pair<String, String>>>>,
        val showGermanFirst: Boolean,
    ) : AdjectivesUiState()
}
