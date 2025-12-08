package com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Grammar
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.AppStringResource
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme

@OptIn(ExperimentalMaterial3Api::class) // TopAppBar
@Composable
fun GrammarScreen(
    onClick: (goTo: AppNavKey) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = 140.dp),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(
            16.dp
        ),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(
            8.dp
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
