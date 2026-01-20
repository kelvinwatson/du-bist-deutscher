package com.watson.kelvin.dubistjetztdeutscher.ui.component.state

/**
 * Generalized UI state interface for Compose screens.
 * Extend this for screen-specific UI state.
 */
interface UiState {
    object Loading : UiState
    object Empty : UiState
    data class Error(val message: String) : UiState
}
