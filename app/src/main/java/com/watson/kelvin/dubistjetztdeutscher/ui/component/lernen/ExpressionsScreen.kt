package com.watson.kelvin.dubistjetztdeutscher.ui.component.lernen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.data.ExpressionsPhraseData
import javax.annotation.processing.Generated

/**
 * Screen displaying conversational phrases for expressing feelings, opinions,
 * agreement, and disagreement in German. Tapping a phrase with a "›" indicator
 * opens a bottom sheet with more examples and context.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ExpressionsScreen(
    modifier: Modifier = Modifier,
) {
    val sections: List<ExpressionsPhraseData.Section> = ExpressionsPhraseData.sections
    var selectedPhrase: ExpressionsPhraseData.Phrase? by remember { mutableStateOf(null) }
    val sheetState = rememberModalBottomSheetState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        sections.forEach { section ->
            item(key = "header_${section.title}") {
                Column(modifier = Modifier.padding(top = 20.dp, bottom = 4.dp)) {
                    Text(
                        text = section.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Theme.caseColors.akkusativ,
                    )
                    section.subtitle?.let { subtitle ->
                        Text(
                            text = subtitle,
                            style = MaterialTheme.typography.bodySmall,
                            fontStyle = FontStyle.Italic,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
            }

            items(
                items = section.phrases,
                key = { "${section.title}_${it.german}" },
            ) { phrase ->
                PhraseRow(
                    phrase = phrase,
                    onTap = if (phrase.expanded != null) {
                        { selectedPhrase = phrase }
                    } else {
                        null
                    },
                )
            }

            item(key = "divider_${section.title}") {
                HorizontalDivider(
                    modifier = Modifier.padding(top = 12.dp),
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                )
            }
        }

        item(key = "bottom_spacer") {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }

    // Bottom sheet for expanded phrase content
    if (selectedPhrase != null) {
        val phrase: ExpressionsPhraseData.Phrase = selectedPhrase!!
        ModalBottomSheet(
            onDismissRequest = { selectedPhrase = null },
            sheetState = sheetState,
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 32.dp),
            ) {
                // Header phrase
                Text(
                    text = phrase.german,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = phrase.english,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                phrase.note?.let { note ->
                    Text(
                        text = note,
                        style = MaterialTheme.typography.labelSmall,
                        fontStyle = FontStyle.Italic,
                        color = Theme.caseColors.dativ,
                        modifier = Modifier.padding(top = 2.dp),
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "More examples",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Expanded phrases
                phrase.expanded?.forEach { expandedPhrase ->
                    Column(modifier = Modifier.padding(vertical = 6.dp)) {
                        Text(
                            text = expandedPhrase.german,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(
                            text = expandedPhrase.english,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        expandedPhrase.note?.let { note ->
                            Text(
                                text = note,
                                style = MaterialTheme.typography.labelSmall,
                                fontStyle = FontStyle.Italic,
                                color = Theme.caseColors.dativ,
                                modifier = Modifier.padding(top = 2.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * A single phrase row. Shows German bold, English below, optional note.
 * Displays a "›" chevron when the phrase has expanded content.
 */
@Composable
private fun PhraseRow(
    phrase: ExpressionsPhraseData.Phrase,
    modifier: Modifier = Modifier,
    onTap: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (onTap != null) Modifier.clickable(onClick = onTap)
                else Modifier,
            )
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.Top,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = phrase.german,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = phrase.english,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            phrase.note?.let { note ->
                Text(
                    text = "ℹ️ $note",
                    style = MaterialTheme.typography.labelSmall,
                    color = Theme.caseColors.dativ,
                    modifier = Modifier.padding(top = 2.dp),
                )
            }
        }
        if (onTap != null) {
            Text(
                text = "›",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(start = 8.dp, top = 2.dp),
            )
        }
    }
}

@[Preview Generated Composable]
internal fun PreviewExpressionsScreen() {
    Theme {
        ExpressionsScreen()
    }
}
