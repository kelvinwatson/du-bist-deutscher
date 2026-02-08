package com.watson.kelvin.dubistjetztdeutscher.ui.component.adjectives

import com.watson.kelvin.dubistjetztdeutscher.common.EnglishAdjective
import com.watson.kelvin.dubistjetztdeutscher.common.GermanAdjective
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz.AdjectiveCategory
import com.watson.kelvin.dubistjetztdeutscher.ui.component.state.UiState

/**
 * UI state for the Adjectives screen.
 */
sealed class AdjectivesUiState : UiState {
    data class Success(
        val searchQuery: String,
        val filteredCategories: List<Pair<AdjectiveCategory, List<Pair<GermanAdjective, EnglishAdjective>>>>,
        val showGermanFirst: Boolean,
    ) : AdjectivesUiState()
}
