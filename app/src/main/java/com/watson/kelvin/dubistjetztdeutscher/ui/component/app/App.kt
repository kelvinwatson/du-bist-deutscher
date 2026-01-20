package com.watson.kelvin.dubistjetztdeutscher.ui.component.app

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.watson.kelvin.dubistjetztdeutscher.ui.component.adjectives.AdjectivesScreen
import com.watson.kelvin.dubistjetztdeutscher.ui.component.bottombar.BottomBar
import com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar.GrammarScreen
import com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar.prepositions.PrepositionsScreen
import com.watson.kelvin.dubistjetztdeutscher.ui.component.screen.AccountScreen
import com.watson.kelvin.dubistjetztdeutscher.ui.component.screen.OverviewScreen
import com.watson.kelvin.dubistjetztdeutscher.ui.component.title.singleLineTitle
import com.watson.kelvin.dubistjetztdeutscher.ui.component.vocabulary.VocabularyScreen
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Grammar
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.viewmodel.NavigationViewModel
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.StringResource

/**
 * Stateless version of App that uses lambdas for navigation actions.
 * This allows for more flexible composition and testing without exposing the BackStackManagement directly.
 *
 * @param currentTopLevelKey The current active (top-level) bottom nav selection (e.g. Overview, Grammar, Account)
 * @param currentSubLevelKey The current active nested/sub screen within the [currentTopLevelKey] (e.g. Prepositions)
 * @param backStackForCurrentKey The nested/sub back stack associated with the [currentTopLevelKey]
 * @param onNavigateToTopLevel Callback to navigate to a top-level (bottom nav) route (e.g. Overview, Grammar, Account)
 * @param onNavigate Callback to add a nested screen to the current route
 * @param removeLastKey Callback to handle back navigation
 * @param modifier Optional modifier to apply to the root composable
 */
@OptIn(ExperimentalMaterial3Api::class)
@VisibleForTesting
@Composable
internal fun App(
    currentTopLevelKey: AppNavKey,
    currentSubLevelKey: AppNavKey,
    backStackForCurrentKey: List<AppNavKey>,
    onNavigateToTopLevel: (AppNavKey) -> Unit,
    onNavigate: (goTo: AppNavKey) -> Unit,
    removeLastKey: (closeApp: () -> Unit) -> Unit,
    modifier: Modifier = Modifier,
) {
    // Handle system back presses to navigate the bottom bar back stack when there are no more
    // entries to pop in the current bottom bar selection's internal back stack.
    val activity = LocalActivity.current
    BackHandler {
        removeLastKey { activity?.finish() }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = currentSubLevelKey.singleLineTitle(),
                    )
                },
                navigationIcon = {
                    // Optionally show back button if we are not on a top-level screen
                    if (backStackForCurrentKey.size > 1) {
                        IconButton(
                            onClick = { removeLastKey {} }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Sharp.ArrowBack,
                                contentDescription = stringResource(StringResource.nav_back),
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomBar(
                currentTopLevel = currentTopLevelKey,
                onClick = onNavigateToTopLevel,
            )
        }
    ) { innerPadding ->

        NavDisplay(

            modifier = Modifier
                .padding(innerPadding),

            backStack = backStackForCurrentKey, // bottom bar selection's internal back stack

            onBack = { removeLastKey {} },

            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),

            entryProvider = entryProvider {
                entry<BottomBarKey.Overview> {
                    OverviewScreen(
                        onSearchBarActivated = { onNavigate(Grammar.Adjectives) }
                    )
                }
                entry<BottomBarKey.Grammar> {
                    GrammarScreen(
                        onClick = onNavigate,
                    )
                }
                entry<BottomBarKey.Account> {
                    AccountScreen()
                }
                entry<BottomBarKey.Vocabulary> {
                    VocabularyScreen(onClick = onNavigate)
                }
                entry<Grammar.Prepositions> { key ->
                    PrepositionsScreen()
                }
                entry<Grammar.Adjectives> { key ->
                    AdjectivesScreen()
                }
                entry<Grammar.Connectors> { key ->
                    com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar.connectors.ConnectorsScreen()
                }
            },
        )
    }
}

/**
 * Convenience version of App that creates a NavigationViewModel.
 * This is useful for simple use cases where you want the default ViewModel behavior.
 *
 * @param modifier The modifier to apply to the root composable
 * @param navigationViewModel The navigation view model
 */
@Composable
fun App(
    modifier: Modifier = Modifier,
    navigationViewModel: NavigationViewModel = viewModel<NavigationViewModel>(),
) {
    val currentTopLevelKey: AppNavKey by navigationViewModel.currentTopLevelKeyFlow.collectAsState()
    val currentSubLevelKey: AppNavKey by navigationViewModel.currentSubLevelKeyFlow.collectAsState()

    App(
        currentTopLevelKey = currentTopLevelKey,
        currentSubLevelKey = currentSubLevelKey,
        backStackForCurrentKey = navigationViewModel.subBackStack,
        onNavigateToTopLevel = navigationViewModel::addTopLevel,
        onNavigate = navigationViewModel::add,
        removeLastKey = navigationViewModel::removeLast,
        modifier = modifier
    )
}
