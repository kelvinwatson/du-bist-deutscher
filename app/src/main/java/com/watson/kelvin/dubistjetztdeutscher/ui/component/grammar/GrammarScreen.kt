package com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Grammar
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.StringResource

@OptIn(ExperimentalMaterial3Api::class) // TopAppBar
@Composable
fun GrammarScreen(
    onClick: (goTo: AppNavKey) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = Theme.dimens.gridMinCellSize),
        horizontalArrangement = Arrangement.spacedBy(Theme.dimens.gridHorizontalSpacing),
        verticalArrangement = Arrangement.spacedBy(Theme.dimens.gridVerticalSpacing),
    ) {

        item {
            TextButton(
                onClick = { onClick(Grammar.Prepositions) },
                border = BorderStroke(
                    width = Theme.dimens.borderWidth,
                    color = Theme.prepositionColors.akkusativ,
                ),
                contentPadding = PaddingValues(Theme.dimens.cellPadding),
            ) {
                Text(
                    text = "${stringResource(StringResource.no_translate_title_prepositions)}\n(${
                        stringResource(
                            StringResource.prepositions
                        )
                    })",
                    textAlign = TextAlign.Center,
                    color = Theme.prepositionColors.akkusativ
                )
            }
        }

        item {
            TextButton(
                onClick = { onClick(Grammar.Connectors) },
                border = BorderStroke(
                    width = Theme.dimens.borderWidth,
                    color = Theme.connectorColors.coordinating,
                ),
                contentPadding = PaddingValues(Theme.dimens.cellPadding),
            ) {
                Text(
                    text = "${stringResource(StringResource.no_translate_title_connectors)}\n(${
                        stringResource(
                            StringResource.no_translate_title_connectors
                        )
                    })",
                    textAlign = TextAlign.Center,
                    color = Theme.connectorColors.coordinating
                )
            }
        }

        item {
            TextButton(
                onClick = { /* TODO: Navigate to detailed screen */ },
                border = BorderStroke(
                    width = Theme.dimens.borderWidth,
                    color = Color(0xFFB39DDB)
                ), // Example: purple for adverbs
                contentPadding = PaddingValues(Theme.dimens.cellPadding),
            ) {
                Text(
                    text = "${stringResource(StringResource.no_translate_title_adverbs)}\n(${
                        stringResource(
                            StringResource.adverbs
                        )
                    })",
                    textAlign = TextAlign.Center,
                    color = Color(0xFFB39DDB)
                )
            }
        }

    }
}
