package com.watson.kelvin.dubistjetztdeutscher.ui.nav.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.watson.kelvin.dubistjetztdeutscher.data.recent.RecentPagesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn

/**
 * ViewModel for the MainActivity that manages activity level state, such as the list of recently
 * accessed pages. However, given that this is a single activity app, the MainActivityViewModel is
 * really more of a global state holder for the app for things that are meant to be shared across
 * multiple screens and survive configuration changes and perhaps process death. The recent pages
 * list is a good example of this, as it needs to be accessed from multiple screens and should be
 * preserved across configuration changes and app kills.
 */
class SingleActivityAppViewModel(
    savedStateHandle: SavedStateHandle,
    application: Application,
    repository: RecentPagesRepository = RecentPagesRepository.create(application, savedStateHandle),
) : AndroidViewModel(application = application) {

    val recentPages: StateFlow<List<String>> = repository.recentPages
        .distinctUntilChanged() // only update the savedStateHandle when the list of recent pages changes
        .onEach { recentlyAccessed ->
            savedStateHandle[RECENT_PAGES_KEY] = recentlyAccessed
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = savedStateHandle[RECENT_PAGES_KEY] ?: emptyList(),
        )

    companion object Companion {
        private const val RECENT_PAGES_KEY = "recent_pages"

        class Factory {
            fun create(
                application: Application,
                savedStateHandle: SavedStateHandle,
            ): SingleActivityAppViewModel {
                return SingleActivityAppViewModel(
                    savedStateHandle = savedStateHandle,
                    application = application,
                )
            }
        }
    }
}