package com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar.prepositions

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.watson.kelvin.dubistjetztdeutscher.R
import com.watson.kelvin.dubistjetztdeutscher.core.theme.PrepositionColorKey
import com.watson.kelvin.dubistjetztdeutscher.core.theme.PrepositionColorKey.Companion.toColor
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.PrepositionsFallbackData
import com.watson.kelvin.dubistjetztdeutscher.ui.model.Tab

/**
 * Prepositions screen with tabbed navigation for different preposition categories.
 * Demonstrates Material3 TabRow with swipeable content using HorizontalPager.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PrepositionsScreen(
    modifier: Modifier = Modifier,
    prepositionsViewModel: PrepositionsViewModel = viewModel(factory = PrepositionsViewModel.Factory),
) {
    val selectedTabIndex: Int by prepositionsViewModel.selectedTabIndex.collectAsState()
    val tabs = prepositionsViewModel.tabs

    // Create a PagerState synchronized with the selected tab
    val pagerState = rememberPagerState(
        initialPage = selectedTabIndex,
        pageCount = { tabs.size }
    )

    // Sync pager state with ViewModel (when user swipes)
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            prepositionsViewModel.selectTab(page)
        }
    }

    // Sync ViewModel state with pager (when tab is clicked or programmatically changed)
    LaunchedEffect(selectedTabIndex) {
        if (pagerState.currentPage != selectedTabIndex) {
            pagerState.animateScrollToPage(selectedTabIndex)
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        // PrimaryScrollableTabRow for navigation
        PrimaryScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth(),
            edgePadding = 0.dp
        ) {
            tabs.forEachIndexed { index, tab ->
                val color = tab.colorKey.toColor(Theme.prepositionColors)
                Tab(
                    selectedContentColor = color,
                    selected = selectedTabIndex == index,
                    onClick = { prepositionsViewModel.selectTab(index) },
                    text = {
                        Column {
                            Text(
                                text = stringResource(tab.germanRes),
                                style = MaterialTheme.typography.labelLarge,
                                maxLines = 1,
                                softWrap = false,
                                color = color,
                            )
                            Text(
                                text = "(" + stringResource(tab.localizedRes) + ")",
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 1,
                                softWrap = false,
                                color = color,
                            )
                        }
                    },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }

        // HorizontalPager for swipeable content
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val tab = tabs[page]
            val color = tab.colorKey.toColor(Theme.prepositionColors)
            PrepositionList(
                prepositions = tab.data,
                highlightColor = color
            )
        }
    }
}

/**
 * Sealed class representing the different preposition tabs.
 */
sealed class PrepositionTab(
    val germanRes: Int,
    val localizedRes: Int,
    val data: List<Preposition>,
    val colorKey: PrepositionColorKey
) : Tab {
    override val id: String
        get() = this::class.simpleName ?: "unknown"

    data object Accusative : PrepositionTab(
        germanRes = R.string.no_translate_tab_accusative,
        localizedRes = R.string.no_translate_tab_accusative_explanation,
        data = PrepositionsFallbackData.accusativePrepositions,
        colorKey = PrepositionColorKey.Akkusativ,
    )

    data object Dative : PrepositionTab(
        germanRes = R.string.no_translate_tab_dative,
        localizedRes = R.string.no_translate_tab_dative_explanation,
        data = PrepositionsFallbackData.dativePrepositions,
        colorKey = PrepositionColorKey.Dativ,
    )

    data object TwoWay : PrepositionTab(
        germanRes = R.string.no_translate_tab_twoway,
        localizedRes = R.string.no_translate_tab_twoway_explanation,
        data = PrepositionsFallbackData.twoWayPrepositions,
        colorKey = PrepositionColorKey.Wechsel,
    )

    data object Genitive : PrepositionTab(
        germanRes = R.string.no_translate_tab_genitive,
        localizedRes = R.string.no_translate_tab_genitive_explanation,
        data = PrepositionsFallbackData.genitivePrepositions,
        colorKey = PrepositionColorKey.Genitive,
    )
}

/**
 * Data class representing a preposition entry.
 */
data class Preposition(
    val german: String,
    val english: String,
    val example: String? = null,
)

/**
 * Reusable composable to display a list of prepositions.
 */
@Composable
private fun PrepositionList(
    prepositions: List<Preposition>,
    modifier: Modifier = Modifier,
    highlightColor: Color? = null // Optional color for highlighting
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        items(prepositions) { preposition ->
            PrepositionCard(
                preposition = preposition,
                highlightColor = highlightColor
            )
        }
    }
}

/**
 * Card displaying a single preposition with its translation and optional example.
 */
@Composable
private fun PrepositionCard(
    preposition: Preposition,
    modifier: Modifier = Modifier,
    highlightColor: Color? = null
) {
    val borderColor = highlightColor ?: MaterialTheme.colorScheme.outline
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Theme.dimens.gridVerticalSpacing)
            .border(
                width = Theme.dimens.borderWidth,
                shape = RoundedCornerShape(Theme.dimens.cornerRadius),
                color = borderColor,
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(Theme.dimens.cellPadding)
        ) {
            Text(
                text = preposition.german,
                style = MaterialTheme.typography.titleMedium,
                color = highlightColor ?: MaterialTheme.colorScheme.onPrimary,
            )
            Text(
                text = preposition.english,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            preposition.example?.let { example ->
                Text(
                    text = example,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
        }
    }
}

// ========== Compose Previews ==========

/**
 * Preview of the full PrepositionsScreen with tabbed navigation.
 */
@Preview(
    name = "Prepositions Screen - Light",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun PrepositionsScreenPreview() {
    Theme {
        PrepositionsScreen()
    }
}

/**
 * Preview of the PrepositionsScreen in dark mode.
 */
@Preview(
    name = "Prepositions Screen - Dark",
    showBackground = true,
    backgroundColor = 0xFF000000,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun PrepositionsScreenDarkPreview() {
    Theme {
        PrepositionsScreen()
    }
}

/**
 * Preview of a single PrepositionCard component.
 */
@Preview(
    name = "Preposition Card",
    showBackground = true
)
@Composable
private fun PrepositionCardPreview() {
    Theme {
        PrepositionCard(
            preposition = Preposition(
                german = "durch",
                english = "through",
                example = "Wir gehen durch den Park."
            ),
        )
    }
}

/**
 * Preview of a PrepositionCard without an example.
 */
@Preview(
    name = "Preposition Card - No Example",
    showBackground = true
)
@Composable
private fun PrepositionCardNoExamplePreview() {
    Theme {
        PrepositionCard(
            preposition = Preposition(
                german = "für",
                english = "for",
                example = null
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

/**
 * Preview of PrepositionList with sample data.
 */
@Preview(
    name = "Preposition List",
    showBackground = true,
    heightDp = 600
)
@Composable
private fun PrepositionListPreview() {
    Theme {
        PrepositionList(
            prepositions = listOf(
                Preposition("durch", "through", "Wir gehen durch den Park."),
                Preposition("für", "for", "Das Geschenk ist für dich."),
                Preposition("gegen", "against", "Er is gegen die Wand gelaufen."),
                Preposition("ohne", "without", "Ich kann nicht ohne dich leben.")
            )
        )
    }
}
