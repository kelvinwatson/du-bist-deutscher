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
import com.watson.kelvin.dubistjetztdeutscher.core.theme.AppPrepositionColors
import com.watson.kelvin.dubistjetztdeutscher.core.theme.PrepositionColorKey
import com.watson.kelvin.dubistjetztdeutscher.core.theme.AppTheme
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.domain.model.Tab

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
    val selectedTabIndex by prepositionsViewModel.selectedTabIndex.collectAsState()
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
                val color = tab.colorKey.color(AppTheme.prepositionColors)
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
            val color = tab.colorKey.color(AppTheme.prepositionColors)
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
        germanRes = R.string.tab_accusative,
        localizedRes = R.string.tab_accusative_explanation,
        data = accusativePrepositions,
        colorKey = PrepositionColorKey.Akkusativ,
    )

    data object Dative : PrepositionTab(
        germanRes = R.string.tab_dative,
        localizedRes = R.string.tab_dative_explanation,
        data = dativePrepositions,
        colorKey = PrepositionColorKey.Dativ,
    )

    data object TwoWay : PrepositionTab(
        germanRes = R.string.tab_twoway,
        localizedRes = R.string.tab_twoway_explanation,
        data = twoWayPrepositions,
        colorKey = PrepositionColorKey.Wechsel,
    )

    data object Genitive : PrepositionTab(
        germanRes = R.string.tab_genitive,
        localizedRes = R.string.tab_genitive_explanation,
        data = genitivePrepositions,
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
            .padding(vertical = 8.dp)
            .border(width = 1.dp, shape = RoundedCornerShape(8.dp), color = borderColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme.colorScheme.primary)
                .padding(8.dp)
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

/**
 * Extension function for PrepositionColorKey to get the color from AppPrepositionColors
 */
fun PrepositionColorKey.color(colors: AppPrepositionColors): Color = when (this) {
    PrepositionColorKey.Akkusativ -> colors.akkusativ
    PrepositionColorKey.Dativ -> colors.dativ
    PrepositionColorKey.Wechsel -> colors.wechsel
    PrepositionColorKey.Genitive -> colors.genitive
}

// ========== Sample Data Lists ===========

private val accusativePrepositions = listOf(
    Preposition("bis", "until, up to, by", "Ich gehe bis die Ecke."),
    Preposition("bis an", "right up to (a border or edge)", "Ich fahre bis an den Strand."),
    Preposition("bis auf", "except for / down to", "Bis auf einen Fehler war alles richtig."),
    Preposition("bis in", "into (time/direction)", "Wir haben bis in die Nacht gefeiert."),
    Preposition("bis über", "beyond / over", "Das Wasser ist bis über die Knie gestiegen."),
    Preposition(
        "bis unter",
        "up to underneath / as low as",
        "Der Schnee ist bis unter das Fenster gegangen."
    ),
    Preposition("durch", "through", "Wir gehen durch den Park."),
    Preposition("für", "for", "Das Geschenk ist für den Lehrer."),
    Preposition("gegen", "against", "Ich nehme Medizin gegen den Schnupfen."),
    Preposition("ins", "in the (maskulin/neuter)", "Wir fahren ins Büro."),
    Preposition("ohne", "without", "Ich gehe ohne den Freund."),
    Preposition("um", "around, at (time)", "Wir sitzen um den Tisch.")
)

private val dativePrepositions = listOf(
    Preposition("ab", "from (without range)", null),
    Preposition("am", "on (static location/temporal/event)", "Am Dienstag kann ich leider nicht."),
    Preposition("aus", "out of, from", "Ich komme aus dem Haus."),
    Preposition("bei", "at, with", "Ich bin bei dem Lehrer."),
    Preposition("bis zu", "up to / as far as / until", "Ich gehe bis zu der Schule."),
    Preposition("im", "in the ([dat] maskulin/neuter)", null),
    Preposition("gegenüber", "opposite", "Das Café ist dem Bahnhof gegenüber."),
    Preposition("mit", "with", "Ich gehe mit dem Freund."),
    Preposition("nach", "to, after", "Wir fahren nach der Schule."),
    Preposition("seit", "since, for (time)", "Ich lerne Deutsch seit einem Jahr."),
    Preposition("von", "from (with range), of", "Das Geschenk ist von dem Freund."),
    Preposition("von dem", "from the", null),
    Preposition("zu", "to", "Ich gehe zu meinen Eltern."),
    Preposition("zum", "to a/the ([mask, neut])", "Treffen wir uns zum Kaffee?"),
    Preposition("zur", "to a/the ([fem])", "Ich gehe zur Schule.")
)

private val twoWayPrepositions = listOf(
    Preposition(
        "an",
        "at, on (vertical surface)",
        "Akk: Ich hänge das Bild an die Wand. / Dat: Das Bild hängt an der Wand."
    ),
    Preposition(
        "am",
        "on (static location/temporal/event)",
        "Dat: Am Dienstag kann ich leider nicht."
    ),
    Preposition(
        "auf",
        "on (horizontal surface), up",
        "Akk: Ich lege das Buch auf den Tisch. / Dat: Das Buch liegt auf dem Tisch."
    ),
    Preposition("hinter", "behind", "Akk [movement]: Dat [static location/temporal/event]:"),
    Preposition("in", "in, into", "Akk: Ich gehe in das Haus. / Dat: Ich bin in dem Haus."),
    Preposition("ins", "in the ([akk] neuter)", null),
    Preposition(
        "neben",
        "next to",
        "Akk: Ich setze mich neben den Mann. / Dat: Ich setze neben dem Mann."
    ),
    Preposition(
        "über",
        "over, above",
        "Akk: Ich hänge die Lampe über den Tisch. / Dat: Die Lampe hängt über dem Tisch."
    ),
    Preposition(
        "unter",
        "under",
        "Akk: Ich lege die Katze unter den Tisch. / Dat: Die Katze liegt unter dem Tisch."
    ),
    Preposition("vor", "in front of", "Akk: Ich gehe vor das Haus. / Dat: Ich stehe vor dem Haus."),
    Preposition(
        "zwischen",
        "in between",
        "Akk: Ich gehe zwischen die Häuser. / Dat: Ich stehe zwischen den Häusern."
    )
)

private val genitivePrepositions = listOf(
    Preposition("außerhalb", "outside", "Außerhalb der Stadt ist es ruhig."),
    Preposition("innerhalb", "inside/within", "Innerhalb einer Woche bekommst du eine Antwort."),
    Preposition("statt", "instead of", "Statt des Autos nehme ich das Fahrrad."),
    Preposition("trotz", "despite", "Trotz des schlechten Wetters gehen wir spazieren."),
    Preposition("während", "during", "Während des Essens telefoniere ich nicht."),
    Preposition("wegen", "because of", "Wegen des Regens bleiben wir zu Hause."),
)

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
    AppTheme {
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
    AppTheme {
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
    AppTheme {
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
    AppTheme {
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
    AppTheme {
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
