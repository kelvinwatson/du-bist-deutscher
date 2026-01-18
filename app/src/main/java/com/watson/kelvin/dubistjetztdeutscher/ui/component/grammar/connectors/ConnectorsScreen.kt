package com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar.connectors

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import com.watson.kelvin.dubistjetztdeutscher.domain.model.Tab

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
    val selectedTabIndex by connectorsViewModel.selectedTabIndex.collectAsState()
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
            edgePadding = 0.dp
        ) {
            tabs.forEachIndexed { index, tab ->

                Tab(
                    selected = selectedTabIndex == index,
                    selectedContentColor = tab.color(),
                    onClick = { connectorsViewModel.selectTab(index) },
                    text = {
                        Column {

                            val resolvedColor = tab.color()

                            Text(
                                text = stringResource(tab.germanRes),
                                style = MaterialTheme.typography.labelLarge,
                                maxLines = 1,
                                softWrap = false,
                                color = resolvedColor,
                            )
                            Text(
                                text = "(" + stringResource(tab.localizedRes) + ")",
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 1,
                                softWrap = false,
                                color = resolvedColor,
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
            Column(modifier = Modifier.fillMaxSize()) {
                val resolvedColor = tab.color()

                Text(
                    text = tab.notes,
                    style = MaterialTheme.typography.bodyMedium,
                    color = resolvedColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )

                ConnectorList(
                    connectors = tab.data,
                    modifier = Modifier.weight(1f),
                    borderColor = resolvedColor
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
    val notes: String,
    val color: @Composable () -> Color,
) : Tab {
    override val id: String
        get() = this::class.simpleName ?: "unknown"

    /**
     * Send the verb to the end.
     */
    data object SubordinatingConjunctions : ConnectorTab(
        germanRes = R.string.tab_subordinating_conjunction,
        localizedRes = R.string.tab_subordinating_explanation,
        data = subordinatingConjunctions,
        notes = "Nebensatz. ALWAYS send the verb to the end. WEIL–DASS–OB → verb goes to the end.",
        color = { MaterialTheme.colorScheme.error }
    )

    data object CoordinatingConjunctions : ConnectorTab(
        germanRes = R.string.tab_coordinating_conjunction,
        localizedRes = R.string.tab_coordinating_explanation,
        data = coordinatingConjunctions,
        notes = "Hauptsatz. Conjugated verb in pos2. These do NOT change word order.",
        color = {
            MaterialTheme.colorScheme.secondary
        }
    )

    data object AdverbialConnectors : ConnectorTab(
        germanRes = R.string.tab_adverbial_connector,
        localizedRes = R.string.tab_adverbial_connector_explanation,
        data = adverbialConnectors,
        notes = "Hauptsatz, Conjugated verb in pos2. Not conjunctions. They take position 1, so the verb must follow right after.",
        color = {
            MaterialTheme.colorScheme.tertiary
        }
    )
}

/**
 * Data class representing a connector entry.
 */
data class Connector(
    val german: String,
    val english: String,
    val example: String? = null,
    val notes: String? = null,
)

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
        items(connectors) { connector ->
            ConnectorCard(connector = connector, borderColor = borderColor)
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

// Coordinating conjunctions → Hauptsatz (normal V2)
// Conjugated verb is in pos 2. These do not alter word order.
private val coordinatingConjunctions = listOf(
    Connector("aber", "but", "Ich mag Kaffee, aber ich trinke auch Tee."),
    Connector(
        "denn",
        "because/for",
        "Ich bleibe zu Hause, denn es regnet.",
        notes = "denn ≠ weil. denn → main clause (V2)\n" +
                "\n" +
                "weil → subordinate clause (verb-final)"
    ),
    Connector("oder", "or", "Willst du Tee oder willst du Kaffee?"),
    Connector("sondern", "but rather", "Nicht Kaffee, sondern Tee."),
    Connector("und", "and", "Ich komme und ich helfe dir."),
)

// Subordinating conjunctions → Nebensatz (verb-final)
// ALWAYS send the conjugated verb to the end of the clause.
private val subordinatingConjunctions = listOf(
    Connector("als", "when (past)", "Als ich jung war, spielte ich Fußball."),
    Connector("bevor", "before", "Bevor er geht, ruft er an."),
    Connector("bis", "until", "Ich warte, bis du kommst."),
    Connector("damit", "so that", "Ich spreche laut, damit du mich hörst."),
    Connector("dass", "that", "Ich denke, dass es regnet."),
    Connector("falls", "in case", "Falls du kommst, bringst du Essen mit (bleiben wir drin)."),
    Connector("nachdem", "after", "Nachdem ich gegessen habe, gehe ich (spazieren)."),
    Connector("ob", "whether/if", "Ich frage mich, ob er da ist."),
    Connector("obwohl", "although", "Obwohl ich müde bin, arbeite ich."),
    Connector("seit/seitdem", "since", "Seit ich hier wohne, bin ich glücklich."),
    Connector("während", "while/whereas", "Während ich arbeite, hört er Musik (lese er)."),
    Connector("weil", "because", "Ich bleibe zu Hause, weil es regnet."),
    Connector("wenn", "when/if", "Wenn es regnet, bleibe ich zu Hause."),
)

// Linking adverbs / Satzadverbien (Hauptsatz, verb in 2nd position)
private val adverbialConnectors = listOf(
    Connector(
        "außerdem",
        "aside from that/besides/furthermore/moreover",
        "Ich gehe nicht einkaufen, außerdem habe ich keine Zeit."
    ),
    Connector(
        "allerdings",
        "however",
        "Ich komme mit. Allerdings bin ich etwas spät."
    ),
    Connector("dann", "then", "Zuerst essen wir, dann gehen wir spazieren."),
    Connector("danach", "afterwards", "Wir essen, danach gehen wir spazieren."),
    Connector("darum", "that's why", "Ich bin müde, darum gehe ich früh ins Bett."),
    Connector("deshalb", "therefore", "Ich habe hunger. Deshalb esse ich."),
    Connector("davor", "before that", "Wir gehen einkaufen, davor frühstücken wir."),
    Connector("jedoch", "however", "Ich mag Kaffee, jedoch trinke ich lieber Tee."),
    Connector("sonst", "otherwise", "Beeil dich, sonst verpassen wir den Zug."),
    Connector("trotzdem", "nevertheless/despite that", "Es regnet, trotzdem gehe ich mit."),
)

@Preview(
    name = "Connectors Screen - Dark",
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun ConnectorsScreenDarkPreview() {
    ConnectorsScreen()
}
