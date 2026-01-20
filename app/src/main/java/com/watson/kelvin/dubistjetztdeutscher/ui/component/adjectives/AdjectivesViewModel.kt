package com.watson.kelvin.dubistjetztdeutscher.ui.component.adjectives

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watson.kelvin.dubistjetztdeutscher.domain.adjectives.AdjectiveSearchUseCase
import com.watson.kelvin.dubistjetztdeutscher.domain.adjectives.DefaultAdjectiveSearchUseCase
import com.watson.kelvin.dubistjetztdeutscher.ui.component.state.UiState
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

@OptIn(FlowPreview::class)
class AdjectivesViewModel(
    private val useCase: AdjectiveSearchUseCase = DefaultAdjectiveSearchUseCase(),
) : ViewModel() {
    private val searchQueryMutable = MutableStateFlow("")
    val searchQuery: StateFlow<String> = searchQueryMutable.asStateFlow()

    private val showGermanFirstMutable = MutableStateFlow(true)
    val showGermanFirst: StateFlow<Boolean> = showGermanFirstMutable.asStateFlow()

    // Only one flow for UI state, updated by debounced filtering in the UI layer
    private val uiStateMutable = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = uiStateMutable.asStateFlow()

    init {
        // Combine search query and language order, update UI state reactively
        searchQueryMutable
            .combine(showGermanFirstMutable) { query, showGermanFirst ->
                Pair(query, showGermanFirst)
            }
            .distinctUntilChanged() // Only trigger on distinct changes
            .map { (query, showGermanFirst) ->
                val filteredCategories = useCase.searchAdjectives(query)
                AdjectivesUiState.Success(
                    searchQuery = query,
                    filteredCategories = filteredCategories,
                    showGermanFirst = showGermanFirst
                ) as UiState
            }
            .catch {
                emit(UiState.Error(it.localizedMessage ?: "An unknown error occurred"))
            }
            .onEach { uiState ->
                uiStateMutable.value = uiState
            }
            .launchIn(viewModelScope)
    }

    fun updateSearchQuery(query: String) {
        searchQueryMutable.value = query
    }

    fun toggleLanguageOrder(showGermanFirst: Boolean) {
        showGermanFirstMutable.value = showGermanFirst
    }

    companion object Companion {
        // Removed unused CACHED_RESULTS_KEY
    }
}