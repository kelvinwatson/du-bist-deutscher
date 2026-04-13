package com.kelvinwatson.dubistjetztdeutscher.ui.prepositions

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kelvinwatson.dubistjetztdeutscher.data.PrepositionData
import com.kelvinwatson.dubistjetztdeutscher.data.model.Preposition
import com.kelvinwatson.dubistjetztdeutscher.data.model.PrepositionCategory
import javax.annotation.processing.Generated

@Composable
fun PrepositionsScreen(
    modifier: Modifier = Modifier,
    viewModel: PrepositionsViewModel = viewModel(),
) {
    val uiState: PrepositionsUiState by viewModel.uiState.collectAsState()

    PrepositionsScreen(
        groupedPrepositions = uiState.groupedPrepositions,
        expandedCategory = uiState.expandedCategory,
        onToggleCategory = viewModel::toggleCategory,
        modifier = modifier,
    )
}

@Composable
internal fun PrepositionsScreen(
    groupedPrepositions: Map<PrepositionCategory, List<Preposition>>,
    expandedCategory: PrepositionCategory?,
    onToggleCategory: (PrepositionCategory) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            MentalModelCard()
        }

        groupedPrepositions.forEach { (category, prepositions) ->
            item(key = category.name) {
                PrepositionCategoryCard(
                    category = category,
                    prepositions = prepositions,
                    isExpanded = expandedCategory == category,
                    onToggle = { onToggleCategory(category) },
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun MentalModelCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "🧠 The Mental Model",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Only Wechselpräpositionen care about Wo vs. Wohin.",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "• Wechsel + movement (Wohin?) → Akkusativ\n" +
                        "• Wechsel + position (Wo?) → Dativ\n" +
                        "• Everything else → fixed case (just memorize it)",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun PrepositionCategoryCard(
    category: PrepositionCategory,
    prepositions: List<Preposition>,
    isExpanded: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    val containerColor = when (category) {
        PrepositionCategory.AKKUSATIV_FIXED -> MaterialTheme.colorScheme.errorContainer
        PrepositionCategory.WECHSEL -> MaterialTheme.colorScheme.tertiaryContainer
        PrepositionCategory.DATIV_FIXED -> MaterialTheme.colorScheme.secondaryContainer
        PrepositionCategory.DATIV_GENITIV -> MaterialTheme.colorScheme.surfaceVariant
        PrepositionCategory.GENITIV_FIXED -> MaterialTheme.colorScheme.inverseSurface.copy(alpha = 0.12f)
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Column {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onToggle)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = category.displayName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${prepositions.size} prepositions",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Collapse" else "Expand"
                )
            }


            // Expanded detail table
            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                ) {
                    HorizontalDivider(modifier = Modifier.padding(bottom = 8.dp))

                    if (category == PrepositionCategory.WECHSEL) {
                        WechselTable(prepositions)
                    } else {
                        FixedCaseTable(prepositions)
                    }
                }
            }
        }
    }
}

@Composable
private fun WechselTable(
    prepositions: List<Preposition>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        // Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.5f))
                .padding(8.dp)
        ) {
            Text(
                text = "Prep.",
                modifier = Modifier.width(64.dp),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Wohin? → Akk",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Wo? → Dat",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )
        }

        prepositions.forEach { prep ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = prep.word,
                    modifier = Modifier.width(64.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = prep.exampleAkk ?: "—",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodySmall,
                    fontFamily = FontFamily.Default,
                )
                Text(
                    text = prep.exampleDat ?: "—",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodySmall,
                    fontFamily = FontFamily.Default,
                )
            }
            if (prep.note != null) {
                Text(
                    text = "ℹ️ ${prep.note}",
                    modifier = Modifier.padding(start = 72.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.bodySmall,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
            )
        }
    }
}

@Composable
private fun FixedCaseTable(
    prepositions: List<Preposition>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        // Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.5f))
                .padding(8.dp)
        ) {
            Text(
                text = "Prep.",
                modifier = Modifier.width(80.dp),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Role",
                modifier = Modifier.width(120.dp),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Example",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold
            )
        }

        prepositions.forEach { prep ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = prep.word,
                    modifier = Modifier.width(80.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = prep.semanticRole,
                    modifier = Modifier.width(120.dp),
                    style = MaterialTheme.typography.bodySmall,
                    fontFamily = FontFamily.Default,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Text(
                    text = prep.primaryExample ?: "—",
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodySmall,
                    fontFamily = FontFamily.Default,
                )
            }
            if (prep.note != null) {
                Text(
                    text = "⚠️ ${prep.note}",
                    modifier = Modifier.padding(start = 80.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.bodySmall,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.error
                )
            }
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f)
            )
        }
    }
}

@[Preview Generated Composable]
internal fun PrepositionsScreenPreview() {
    MaterialTheme {
        PrepositionsScreen(
            groupedPrepositions = PrepositionData.allGrouped,
            expandedCategory = PrepositionCategory.WECHSEL,
            onToggleCategory = {},
        )
    }
}

