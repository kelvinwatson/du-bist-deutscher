package com.watson.kelvin.dubistjetztdeutscher.ui.component.adjectives

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.AdjectiveCategory
import com.watson.kelvin.dubistjetztdeutscher.domain.adjectives.DefaultAdjectiveSearchUseCase
import javax.annotation.processing.Generated

/**
 * Stateless version of AdjectivesScreen for preview and testing.
 */
@Composable
internal fun AdjectivesScreen(
    searchQuery: String,
    filteredCategories: List<Pair<AdjectiveCategory, List<Pair<String, String>>>>,
    modifier: Modifier = Modifier,
    showGermanFirst: Boolean = true,
    onToggleLanguageOrder: (Boolean) -> Unit = {},
    onSearchQueryChange: (String) -> Unit = {},
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
            Text(text = if (showGermanFirst) "Deutsch (Englisch)" else "English (Deutsch)")
            Switch(
                checked = showGermanFirst,
                onCheckedChange = onToggleLanguageOrder,
                colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colorScheme.onPrimary)
            )
        }
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            label = { Text("Search adjectives") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                cursorColor = MaterialTheme.colorScheme.onPrimary,
            )
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(filteredCategories) { (category, adjectives) ->
                if (adjectives.isNotEmpty()) {
                    Text(
                        text = stringResource(category.displayName),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    )
                    adjectives.forEach { (en, de) ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 4.dp)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                if (showGermanFirst) {
                                    Text(text = de, style = MaterialTheme.typography.bodyLarge)
                                    Text(
                                        text = en,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onPrimary // Use app's white color
                                    )
                                } else {
                                    Text(text = en, style = MaterialTheme.typography.bodyLarge)
                                    Text(
                                        text = de,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onPrimary // Use app's white color
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

// Main entry point for production usage (with ViewModel)
@Composable
fun AdjectivesScreen(
    modifier: Modifier = Modifier,
    viewModel: AdjectiveSearchViewModel = viewModel(
        initializer = {
            AdjectiveSearchViewModel(
                useCase = DefaultAdjectiveSearchUseCase(),
                savedStateHandle = createSavedStateHandle()
            )
        }
    )
) {
    val searchQuery: String by viewModel.searchQuery.collectAsState()
    val filteredCategories: List<Pair<AdjectiveCategory, List<Pair<String, String>>>> by viewModel.filteredCategories.collectAsState()
    val showGermanFirst: Boolean by viewModel.showGermanFirst.collectAsState()
    AdjectivesScreen(
        searchQuery = searchQuery,
        filteredCategories = filteredCategories,
        showGermanFirst = showGermanFirst,
        onToggleLanguageOrder = viewModel::toggleLanguageOrder,
        onSearchQueryChange = viewModel::updateSearchQuery,
        modifier = modifier
    )
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
