package com.watson.kelvin.dubistjetztdeutscher.ui.component.common

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
import androidx.compose.ui.text.style.TextOverflow
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey

/**
 * Data class representing a feature grid item.
 *
 * To hide a feature (e.g. Account), simply comment out or remove its FeatureGridItem from the items list in the calling screen.
 */
data class FeatureGridItem(
    val label: String,
    val translation: String? = null,
    val color: Color,
    val navKey: AppNavKey,
    // val isVisible: Boolean = true // Uncomment if you want to toggle visibility dynamically
)

/**
 * Common grid screen for displaying feature navigation.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureGridScreen(
    items: List<FeatureGridItem>,
    modifier: Modifier = Modifier,
    onClick: (AppNavKey) -> Unit = {},
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = Theme.dimens.gridMinCellSize),
        horizontalArrangement = Arrangement.spacedBy(Theme.dimens.gridHorizontalSpacing),
        verticalArrangement = Arrangement.spacedBy(Theme.dimens.gridVerticalSpacing),
    ) {
        items(items.size) { index ->
            val item = items[index]
            TextButton(
                onClick = { onClick(item.navKey) },
                border = BorderStroke(
                    width = Theme.dimens.borderWidth,
                    color = item.color,
                ),
                contentPadding = PaddingValues(Theme.dimens.cellPadding),
            ) {
                Text(
                    text = if (item.translation != null) item.label + "\n" + item.translation else item.label,
                    textAlign = TextAlign.Center,
                    color = item.color,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

// To hide the Account screen, remove or comment out its FeatureGridItem in the items list in VocabularyScreen or GrammarScreen.
// No code change needed here unless you want to support dynamic hiding via a property.
