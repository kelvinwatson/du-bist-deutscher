package com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Grammar
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.AppStringResource
import com.watson.kelvin.dubistjetztdeutscher.ui.theme.Theme

@OptIn(ExperimentalMaterial3Api::class) // TopAppBar
@Composable
fun GrammarScreen(
    onClick: (destinationKey: AppNavKey) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier,
        contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
        columns = GridCells.Adaptive(minSize = 140.dp),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(
            16.dp, alignment = Alignment.CenterHorizontally
        ),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(
            16.dp,
            alignment = Alignment.CenterVertically
        ),
    ) {

        item {
            TextButton(
                onClick = { onClick(Grammar.Prepositions) },
                border = BorderStroke(width = 1.dp, color = Theme.colorScheme.onPrimary),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
            ) {
                Text(
                    text = "${stringResource(AppStringResource.no_translate_prepositions)}\n(${
                        stringResource(
                            AppStringResource.prepositions
                        )
                    })",
                    textAlign = TextAlign.Center,
                )
            }

        }

        item {
            TextButton(
                onClick = { /* TODO: Navigate to detailed screen */ },
                border = BorderStroke(width = 1.dp, color = Theme.colorScheme.onPrimary),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
            ) {
                Text(
                    text = "${stringResource(AppStringResource.no_translate_adverbs)}\n(${
                        stringResource(
                            AppStringResource.adverbs
                        )
                    })",
                    textAlign = TextAlign.Center,
                )
            }
        }

    }
}


//
//
//    LazyColumn(modifier = modifier) {
//        item {
//            Text(
//                text = "Welcome to the Wortschatz Screen!",
//            )
//        }
//
//        item {
//            Text(
//                text = "VERBEN",
//            )
//        }
//
//        item {
//            Text(
//                text = "benutzen/verwenden = to use\n",
//                modifier = Modifier.padding(top = 16.dp),
//            )
//        }
//
//        item {
//            Text(
//                text = "mögen (Modalverb) = like (modal). z.B. Ich mag Pizza\n" +
//                        "\n" +
//                        "möchten (Konjunktiv II—polite form—of mögen, not Modal but used like one) = would like/want (Ich möchte essen)\n" +
//                        "wollen (Modalverb) = want (Ich will essen)\n" +
//                        "\n" +
//                        "werden: to become, will, must be\n" +
//                        "* “to become” when used alone\n" +
//                        "  - Ich werde Arzt (I become a Dr)\n" +
//                        "* “will” when used with infinitive\n" +
//                        "  - Ich werde morgen arbeiten (will)\n" +
//                        "* “being done” when used with past particip\n" +
//                        "  - Das Haus wird gebaut (house is being built)\n" +
//                        "* “must be/probably is” when used with present\n" +
//                        "  - Er wird krank sein (He must be sick)\n" +
//                        "  - Passiv + infinitive: Das Buch würde gelesen werden (The book would be(come) read)\n" +
//                        "* würde (Konjunctive II) would (hypothetical / conditional / polite)\n" +
//                        "  - Ich würde gehen (I would go)\n",
//                modifier = Modifier.padding(top = 16.dp),
//            )
//        }
//    }
