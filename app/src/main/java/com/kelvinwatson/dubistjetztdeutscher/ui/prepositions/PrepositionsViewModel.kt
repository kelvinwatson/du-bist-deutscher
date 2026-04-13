package com.kelvinwatson.dubistjetztdeutscher.ui.prepositions

import androidx.lifecycle.ViewModel
import com.kelvinwatson.dubistjetztdeutscher.data.PrepositionData
import com.kelvinwatson.dubistjetztdeutscher.data.model.Preposition
import com.kelvinwatson.dubistjetztdeutscher.data.model.PrepositionCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class PrepositionsUiState(
    val groupedPrepositions: Map<PrepositionCategory, List<Preposition>> = PrepositionData.allGrouped,
    val expandedCategory: PrepositionCategory? = null
)

class PrepositionsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PrepositionsUiState())
    val uiState: StateFlow<PrepositionsUiState> = _uiState.asStateFlow()

    fun toggleCategory(category: PrepositionCategory) {
        _uiState.value = _uiState.value.let { state ->
            state.copy(
                expandedCategory = if (state.expandedCategory == category) null else category
            )
        }
    }
}

