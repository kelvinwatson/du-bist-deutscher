package com.watson.kelvin.dubistjetztdeutscher.ui.nav.viewmodel

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.watson.kelvin.dubistjetztdeutscher.data.recent.RecentPagesRepository
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.EmbeddedModeNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.manager.BackStackManagement
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.manager.BackStackManager
import kotlinx.coroutines.launch

/**
 * EmbeddedModeNavKey <-- user goes to Prepositions screen
 *   Grammar  <-- user goes to Grammar screen
 *   Overview <-- initial position
 * GlobalModeNavKey
 *
 * Stack-based navigation view model to manage global navigation state.
 */
class NavigationViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val application: Application,
    // TODO Use Koin dependency injection
    private val backStackManager: BackStackManagement<AppNavKey> = BackStackManager(BottomBarKey.Overview),
    private val recentPagesRepository: RecentPagesRepository =
        RecentPagesRepository.create(application, savedStateHandle),
) : ViewModel(), BackStackManagement<AppNavKey> by backStackManager {

    /**
     * Navigate to a screen and record it in recent pages if it is embedded.
     */
    fun navigateTo(key: AppNavKey) {
        if (key is EmbeddedModeNavKey) {
            viewModelScope.launch {
                recentPagesRepository.addPage(key.id)
            }
        }
        add(key)
    }
}
