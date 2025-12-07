package com.watson.kelvin.dubistjetztdeutscher.ui.nav.viewmodel

import androidx.lifecycle.ViewModel
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.manager.BackStackManagement
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.manager.BackStackManager

/**
 * EmbeddedModeNavKey <-- user goes to Prepositions screen
 *   Grammar  <-- user goes to Grammar screen
 *   Overview <-- initial position
 * GlobalModeNavKey
 *
 * Stack-based navigation view model to manage global navigation state.
 */
class NavigationViewModel(
    // TODO Use Koin dependency injection
    private val backStackManager: BackStackManagement<AppNavKey> = BackStackManager(BottomBarKey.Overview)
) : ViewModel(), BackStackManagement<AppNavKey> by backStackManager