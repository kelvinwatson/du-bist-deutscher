package com.watson.kelvin.dubistjetztdeutscher.ui.component.adjectives

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectiveCategory
import com.watson.kelvin.dubistjetztdeutscher.domain.adjectives.AdjectiveSearchUseCase
import com.watson.kelvin.dubistjetztdeutscher.domain.adjectives.DefaultAdjectiveSearchUseCase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

// TODO: Use dependency injection (e.g., Koin) to provide the use case in the future.
class AdjectiveSearchViewModel(
    private val useCase: AdjectiveSearchUseCase = DefaultAdjectiveSearchUseCase(),
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _showGermanFirst = MutableStateFlow(true)
    val showGermanFirst = _showGermanFirst.asStateFlow()

    companion object {
        private const val CACHED_RESULTS_KEY = "cached_results"
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun toggleLanguageOrder(showGermanFirst: Boolean) {
        _showGermanFirst.value = showGermanFirst
    }

    @OptIn(FlowPreview::class)
    val filteredCategories: StateFlow<List<Pair<AdjectiveCategory, List<Pair<String, String>>>>> =
        _searchQuery
            .debounce(250)
            .map { query ->
                val cacheKey = "$CACHED_RESULTS_KEY-$query"
                savedStateHandle[cacheKey]
                    ?: useCase.searchAdjectives(query).also { savedStateHandle[cacheKey] = it }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000), emptyList()
            )
}
