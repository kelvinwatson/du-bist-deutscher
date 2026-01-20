package com.watson.kelvin.dubistjetztdeutscher.ui.component.vocabulary

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
import androidx.compose.ui.text.style.TextAlign
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.ui.component.title.withParenthesizedTranslation
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.StringResource

/**
 * Main screen for the Vocabulary tab. Displays vocabulary features in a grid.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VocabularyScreen(
    modifier: Modifier = Modifier,
    onClick: (goTo: AppNavKey) -> Unit = {},
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = Theme.dimens.gridMinCellSize),
        horizontalArrangement = Arrangement.spacedBy(Theme.dimens.gridHorizontalSpacing),
        verticalArrangement = Arrangement.spacedBy(Theme.dimens.gridVerticalSpacing),
    ) {
        item {
            TextButton(
                onClick = { onClick(com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Grammar.Connectors) },
                border = BorderStroke(
                    width = Theme.dimens.borderWidth,
                    color = Theme.connectorColors.coordinating,
                ),
                contentPadding = PaddingValues(Theme.dimens.cellPadding),
            ) {
                Text(
                    text = StringResource.no_translate_title_connectors.withParenthesizedTranslation(
                        translation = StringResource.no_translate_en_title_connectors
                    ),
                    textAlign = TextAlign.Center,
                    color = Theme.connectorColors.coordinating
                )
            }
        }
        item {
            TextButton(
                onClick = { onClick(com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Grammar.Adjectives) },
                border = BorderStroke(
                    width = Theme.dimens.borderWidth,
                    color = Color(0xFF81C784), // Example: green for adjectives
                ),
                contentPadding = PaddingValues(Theme.dimens.cellPadding),
            ) {
                Text(
                    text = StringResource.no_translate_title_adjectives.withParenthesizedTranslation(
                        StringResource.no_translate_en_title_adjectives,
                    ),
                    textAlign = TextAlign.Center,
                    color = Color(0xFF81C784)
                )
            }
        }
    }
}
