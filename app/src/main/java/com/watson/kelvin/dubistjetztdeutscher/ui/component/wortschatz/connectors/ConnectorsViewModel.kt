package com.watson.kelvin.dubistjetztdeutscher.ui.component.wortschatz.connectors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.watson.kelvin.dubistjetztdeutscher.domain.usecase.TabSelectionUseCase
import com.watson.kelvin.dubistjetztdeutscher.domain.usecase.TabSelectionUseCaseImpl

/**
 * ViewModel for managing the state and business logic of the Connectors screen.
 * Demonstrates reuse of the TabSelectionUseCase with Kotlin delegation.
 */
class ConnectorsViewModel(
    tabSelectionUseCase: TabSelectionUseCase<ConnectorTab>
) : ViewModel(),
    TabSelectionUseCase<ConnectorTab> by tabSelectionUseCase {

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val tabs = listOf(
                    ConnectorTab.CoordinatingConjunctions,
                    ConnectorTab.SubordinatingConjunctions,
                    ConnectorTab.AdverbialConnectors
                )
                ConnectorsViewModel(
                    tabSelectionUseCase = TabSelectionUseCaseImpl(tabs)
                )
            }
        }
    }
}

