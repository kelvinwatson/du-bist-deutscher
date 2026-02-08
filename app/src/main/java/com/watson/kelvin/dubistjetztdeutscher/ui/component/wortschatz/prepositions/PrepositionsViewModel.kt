package com.watson.kelvin.dubistjetztdeutscher.ui.component.wortschatz.prepositions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.watson.kelvin.dubistjetztdeutscher.domain.usecase.TabSelectionUseCase
import com.watson.kelvin.dubistjetztdeutscher.domain.usecase.TabSelectionUseCaseImpl

/**
 * ViewModel for managing the state and business logic of the Prepositions screen.
 * Uses Kotlin delegation to delegate tab selection logic to TabSelectionUseCase.
 */
class PrepositionsViewModel(
    tabSelectionUseCase: TabSelectionUseCase<PrepositionTab>,
) : ViewModel(),
    TabSelectionUseCase<PrepositionTab> by tabSelectionUseCase {

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val tabs = listOf(
                    PrepositionTab.Accusative,
                    PrepositionTab.Dative,
                    PrepositionTab.TwoWay,
                    PrepositionTab.Genitive
                )
                PrepositionsViewModel(
                    tabSelectionUseCase = TabSelectionUseCaseImpl(tabs)
                )
            }
        }
    }
}

