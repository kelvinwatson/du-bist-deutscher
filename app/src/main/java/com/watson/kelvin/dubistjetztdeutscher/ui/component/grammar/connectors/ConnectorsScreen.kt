package com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar.connectors

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.PrimaryIndicator
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.watson.kelvin.dubistjetztdeutscher.R
import com.watson.kelvin.dubistjetztdeutscher.core.theme.ConnectorColors
import com.watson.kelvin.dubistjetztdeutscher.core.theme.LocalColors
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.data.connectors.Connector
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.ConnectorsFallbackData
import com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar.connectors.ConnectorColorKey.Companion.toColors
import com.watson.kelvin.dubistjetztdeutscher.ui.model.Tab
import javax.annotation.processing.Generated

/**
 * Screen displaying information about German connectors.
 * Demonstrates reuse of TabSelectionUseCase with swipeable content using HorizontalPager.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ConnectorsScreen(
    modifier: Modifier = Modifier,
    connectorsViewModel: ConnectorsViewModel = viewModel(factory = ConnectorsViewModel.Factory),
) {
    val selectedTabIndex: Int by connectorsViewModel.selectedTabIndex.collectAsState()
    val tabs = connectorsViewModel.tabs

    // Create a PagerState synchronized with the selected tab
    val pagerState = rememberPagerState(
        initialPage = selectedTabIndex,
        pageCount = { tabs.size }
    )

    // Sync pager state with ViewModel (when user swipes)
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            connectorsViewModel.selectTab(page)
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
            edgePadding = 0.dp,
            indicator = {
                val tabColor =
                    tabs[selectedTabIndex].colorKey.toColors(LocalColors.current.connectorColors)
                PrimaryIndicator(
                    Modifier.tabIndicatorOffset(selectedTabIndex, matchContentSize = true),
                    width = Dp.Unspecified,
                    color = tabColor
                )
            }
        ) {
            tabs.forEachIndexed { index, tab ->
                val tabColor = tab.colorKey.toColors(LocalColors.current.connectorColors)
                Tab(
                    selected = selectedTabIndex == index,
                    selectedContentColor = tabColor,
                    onClick = { connectorsViewModel.selectTab(index) },
                    text = {
                        Column {
                            Text(
                                text = stringResource(tab.germanRes),
                                style = MaterialTheme.typography.labelLarge,
                                maxLines = 1,
                                softWrap = false,
                                color = tabColor,
                            )
                            Text(
                                text = "(" + stringResource(tab.localizedRes) + ")",
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 1,
                                softWrap = false,
                                color = tabColor,
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
            val tabColor = tab.colorKey.toColors(LocalColors.current.connectorColors)
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = stringResource(tab.noteRes),
                    style = MaterialTheme.typography.bodyMedium,
                    color = tabColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
                ConnectorList(
                    connectors = tab.data,
                    modifier = Modifier.weight(1f),
                    borderColor = tabColor
                )
            }
        }
    }
}

/**
 * Sealed class representing the different connector tabs.
 */
sealed class ConnectorTab(
    val germanRes: Int,
    val localizedRes: Int,
    val data: List<Connector>,
    val noteRes: Int,
    val colorKey: ConnectorColorKey,
) : Tab {
    override val id: String
        get() = this::class.simpleName ?: "unknown"

    data object SubordinatingConjunctions : ConnectorTab(
        germanRes = R.string.no_translate_tab_subordinating_explanation,
        localizedRes = R.string.no_translate_tab_subordinating_explanation,
        data = ConnectorsFallbackData.subordinatingConjunctions,
        noteRes = R.string.connector_subordinating_note,
        colorKey = ConnectorColorKey.Subordinating
    )

    data object CoordinatingConjunctions : ConnectorTab(
        germanRes = R.string.no_translate_tab_coordinating_explanation,
        localizedRes = R.string.no_translate_tab_coordinating_explanation,
        data = ConnectorsFallbackData.coordinatingConjunctions,
        noteRes = R.string.connector_coordinating_note,
        colorKey = ConnectorColorKey.Coordinating
    )

    data object AdverbialConnectors : ConnectorTab(
        germanRes = R.string.no_translate_tab_adverbial_connector_explanation,
        localizedRes = R.string.no_translate_tab_adverbial_connector_explanation,
        data = ConnectorsFallbackData.adverbialConnectors,
        noteRes = R.string.connector_adverbial_note,
        colorKey = ConnectorColorKey.Adverbial
    )
}

enum class ConnectorColorKey {
    Subordinating, Coordinating, Adverbial;

    companion object {
        /**
         * Extension function for ConnectorColorKey to get the color from AppConnectorColors
         */
        fun ConnectorColorKey.toColors(colors: ConnectorColors): Color = when (this) {
            Subordinating -> colors.subordinating
            Coordinating -> colors.coordinating
            Adverbial -> colors.adverbial
        }
    }
}

/**
 * Reusable composable to display a list of connectors.
 */
@Composable
private fun ConnectorList(
    connectors: List<Connector>,
    modifier: Modifier = Modifier,
    borderColor: Color = MaterialTheme.colorScheme.outline,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        items(connectors.size) { index ->
            ConnectorCard(connector = connectors[index], borderColor = borderColor)
        }
    }
}

/**
 * Composable to display a single connector card.
 */
@Composable
private fun ConnectorCard(
    connector: Connector,
    modifier: Modifier = Modifier,
    borderColor: Color = MaterialTheme.colorScheme.outline,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(width = 2.dp, color = borderColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = connector.german,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Text(
                text = connector.english,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            connector.example?.let { example ->
                Text(
                    text = example,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@[Preview Generated Composable]
private fun ConnectorsScreenDarkPreview() {
    Theme {
        ConnectorsScreen()
    }
}
