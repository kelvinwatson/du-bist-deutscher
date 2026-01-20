package com.watson.kelvin.dubistjetztdeutscher.ui.component.adjectives

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectiveCategory
import com.watson.kelvin.dubistjetztdeutscher.domain.adjectives.DefaultAdjectiveSearchUseCase
import com.watson.kelvin.dubistjetztdeutscher.ui.component.state.UiState
import com.watson.kelvin.dubistjetztdeutscher.ui.component.title.withParenthesizedTranslation
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.StringResource
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import javax.annotation.processing.Generated

/**
 * Main entry point for production usage (with ViewModel)
 *
 * @param modifier The modifier to be applied to the screen.
 * @param viewModel The ViewModel to be used for state management.
 */
@OptIn(FlowPreview::class)
@Composable
fun AdjectivesScreen(
    modifier: Modifier = Modifier,
    viewModel: AdjectivesViewModel = viewModel {
        AdjectivesViewModel(
            useCase = DefaultAdjectiveSearchUseCase(),
//            savedStateHandle = createSavedStateHandle()
        )
    }
) {
    val uiState by viewModel.uiState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val showGermanFirst by viewModel.showGermanFirst.collectAsState()

    // Debounce the search query in the UI layer
    LaunchedEffect(searchQuery, showGermanFirst) {
        flowOf(Pair(searchQuery, showGermanFirst))
            .debounce(300)
            .collectLatest { (debouncedQuery, debouncedShowGermanFirst) ->
                viewModel.updateSearchQuery(debouncedQuery)
                viewModel.toggleLanguageOrder(debouncedShowGermanFirst)
            }
    }

    when (val state = uiState) {
        is UiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(StringResource.ui_state_loading),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }

        is AdjectivesUiState.Success -> {
            AdjectivesScreen(
                modifier = modifier,
                searchQuery = state.searchQuery,
                filteredCategories = state.filteredCategories,
                showGermanFirst = state.showGermanFirst,
                onToggleLanguageOrder = viewModel::toggleLanguageOrder,
                onSearchQueryChange = viewModel::updateSearchQuery,
            )
        }

        is UiState.Error -> {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.message,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

/**
 * Stateless version of AdjectivesScreen for preview and testing.
 */
@Composable
internal fun AdjectivesScreen(
    modifier: Modifier = Modifier,
    searchQuery: String,
    filteredCategories: List<Pair<AdjectiveCategory, List<Pair<String, String>>>>,
    showGermanFirst: Boolean = true,
    onToggleLanguageOrder: (Boolean) -> Unit = {},
    onSearchQueryChange: (String) -> Unit = {},
) {
    println("Stateless AdjectivesScreen: searchQuery='$searchQuery'")
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = StringResource.no_translate_toggle_english_first.withParenthesizedTranslation(
                    translation = StringResource.no_translate_en_toggle_english_first
                ),
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = showGermanFirst,
                onCheckedChange = onToggleLanguageOrder,
                colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colorScheme.onPrimary)
            )
        }
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            label = { Text(stringResource(StringResource.no_translate_en_search_hint)) },
            modifier = Modifier
                .fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                cursorColor = MaterialTheme.colorScheme.onPrimary,
            )
        )
        val categories = filteredCategories.map { it.first }
        if (categories.isEmpty()) {
            // Show empty state if there are no categories, but keep search bar and toggle visible
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(StringResource.ui_state_empty),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        } else {
            var selectedTabIndex by remember { mutableIntStateOf(0) }
            val pagerState = rememberPagerState(
                initialPage = selectedTabIndex,
                pageCount = { categories.size }
            )
            // Sync pager state with tab selection
            LaunchedEffect(pagerState) {
                snapshotFlow { pagerState.currentPage }.collect { page ->
                    selectedTabIndex = page
                }
            }
            LaunchedEffect(selectedTabIndex) {
                if (pagerState.currentPage != selectedTabIndex) {
                    pagerState.animateScrollToPage(selectedTabIndex)
                }
            }
            PrimaryScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.fillMaxWidth(),
                edgePadding = 0.dp
            ) {
                categories.forEachIndexed { index, category ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(stringResource(category.displayName)) }
                    )
                }
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.Top,
            ) { page ->
                val selectedCategory = categories.getOrNull(page)
                val selectedAdjectives = filteredCategories.getOrNull(page)?.second ?: emptyList()
                Column(modifier = Modifier.fillMaxWidth()) {
                    if (selectedCategory != null && selectedAdjectives.isNotEmpty()) {
                        Text(
                            text = stringResource(selectedCategory.displayName),
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                        )
                        selectedAdjectives.forEach { (en, de) ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp),
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    val (first, second) = if (showGermanFirst) {
                                        de to en
                                    } else {
                                        en to de
                                    }
                                    Text(text = first, style = MaterialTheme.typography.bodyLarge)
                                    Text(
                                        text = second,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSecondary // Use app's white color
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@[Preview Generated Composable]
internal fun AdjectivesScreenPreview() {
    Theme {
        AdjectivesScreen(
            searchQuery = "",
            filteredCategories = listOf(
                AdjectiveCategory.COLOR to listOf(
                    "red" to "rot",
                    "blue" to "blau"
                ),
                AdjectiveCategory.SIZE to listOf(
                    "big" to "groß",
                    "small" to "klein"
                )
            )
        )
    }
}
