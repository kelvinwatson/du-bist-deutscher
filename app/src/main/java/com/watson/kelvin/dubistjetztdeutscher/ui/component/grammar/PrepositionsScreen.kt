package com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.watson.kelvin.dubistjetztdeutscher.R
import com.watson.kelvin.dubistjetztdeutscher.ui.theme.AppTheme
import com.watson.kelvin.dubistjetztdeutscher.ui.theme.Theme

/**
 * Prepositions screen with tabbed navigation for different preposition categories.
 * Demonstrates Material3 TabRow with multiple tabs for organizing content.
 */
@Composable
fun PrepositionsScreen(
    modifier: Modifier = Modifier,
) {
    // State to track the selected tab
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    // Define the tabs
    val tabs = listOf(
        PrepositionTab.Accusative,
        PrepositionTab.Dative,
        PrepositionTab.TwoWay,
        PrepositionTab.Genitive
    )

    Column(modifier = modifier.fillMaxSize()) {
        // TabRow for navigation
        androidx.compose.foundation.layout.Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selectedContentColor = tab.highlightColor,
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Column {
                            Text(
                                text = stringResource(tab.germanRes),
                                style = MaterialTheme.typography.labelLarge,
                                maxLines = 1,
                                softWrap = false,
                                color = tab.highlightColor,
                            )
                            Text(
                                text = "(" + stringResource(tab.localizedRes) + ")",
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 1,
                                softWrap = false,
                                color = tab.highlightColor,
                            )
                        }
                    },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            }
        }

        tabs[selectedTabIndex].let { tab ->
            PrepositionList(
                prepositions = tab.data,
                highlightColor = tab.highlightColor
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
    val highlightColor: Color
) {
    data object Accusative : PrepositionTab(
        germanRes = R.string.tab_accusative,
        localizedRes = R.string.tab_accusative_explanation,
        data = accusativePrepositions,
        highlightColor = AppTheme.prepositionColors.akkusativ,
    )

    data object Dative : PrepositionTab(
        germanRes = R.string.tab_dative,
        localizedRes = R.string.tab_dative_explanation,
        data = dativePrepositions,
        highlightColor = AppTheme.prepositionColors.dativ,
    )

    data object TwoWay : PrepositionTab(
        germanRes = R.string.tab_twoway,
        localizedRes = R.string.tab_twoway_explanation,
        data = twoWayPrepositions,
        highlightColor = AppTheme.prepositionColors.wechsel,
    )

    data object Genitive : PrepositionTab(
        germanRes = R.string.tab_genitive,
        localizedRes = R.string.tab_genitive_explanation,
        data = genitivePrepositions,
        highlightColor = AppTheme.prepositionColors.genitive,
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
    Preposition("während", "during", "Während des Essens telefoniere ich nicht."),
    Preposition("wegen", "because of", "Wegen des Regens bleiben wir zu Hause."),
    Preposition("trotz", "despite", "Trotz des schlechten Wetters gehen wir spazieren."),
    Preposition("statt", "instead of", "Statt des Autos nehme ich das Fahrrad."),
    Preposition("außerhalb", "outside", "Außerhalb der Stadt ist es ruhig."),
    Preposition("innerhalb", "inside/within", "Innerhalb einer Woche bekommst du eine Antwort.")
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
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
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
                Preposition("gegen", "against", "Er ist gegen die Wand gelaufen."),
                Preposition("ohne", "without", "Ich kann nicht ohne dich leben.")
            )
        )
    }
}
