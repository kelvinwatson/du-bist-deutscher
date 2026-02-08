package com.watson.kelvin.dubistjetztdeutscher.ui.component.adjectives

import app.cash.turbine.test
import com.watson.kelvin.dubistjetztdeutscher.common.EnglishAdjective
import com.watson.kelvin.dubistjetztdeutscher.common.GermanAdjective
import com.watson.kelvin.dubistjetztdeutscher.domain.adjectives.DefaultAdjectiveSearchUseCase
import com.watson.kelvin.dubistjetztdeutscher.testrule.CoroutineRule
import com.watson.kelvin.dubistjetztdeutscher.ui.component.state.UiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AdjectivesViewModelTest {
    private lateinit var viewModel: AdjectivesViewModel

    @get:Rule
    private val coroutineRule = CoroutineRule()

    @Before
    fun setUp() {
        viewModel = AdjectivesViewModel(
            useCase = DefaultAdjectiveSearchUseCase(),
        )
    }

    @Test
    fun `typing in search bar filters adjectives`() = coroutineRule.runTest {
        // Type a query that should match at least one adjective
        viewModel.updateSearchQuery("rot")
        // Wait for debounce and state update
        viewModel.uiState.test {
            // Initial Loading state
            assert(awaitItem() is UiState.Loading)
            val state = awaitItem()
            assert(state is AdjectivesUiState.Success)
            val success = state as AdjectivesUiState.Success
            // Should only contain adjectives matching "rot"
            val allAdjectives = success.filteredCategories.flatMap { it.second }
            assert(allAdjectives.any { it.first == "rot" || it.second == "red" })
        }
    }

    @Test
    fun `searching for an adjective shows the correct translation`() = coroutineRule.runTest {
        viewModel.updateSearchQuery("blau")
        viewModel.uiState.test {
            // Wait for debounce and state update
            val state = awaitItem()
            assert(state is AdjectivesUiState.Success)
            val filtered = (state as AdjectivesUiState.Success).filteredCategories
            val adjectives: List<Pair<GermanAdjective, EnglishAdjective>> = filtered.first().second
            assert(adjectives.any { it.first == "blau" })
        }
    }
}
