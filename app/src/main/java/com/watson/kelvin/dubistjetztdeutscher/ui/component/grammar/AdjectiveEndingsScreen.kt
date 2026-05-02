package com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import javax.annotation.processing.Generated

/**
 * Screen displaying adjective endings tables for definite and indefinite articles.
 */
@Composable
internal fun AdjectiveEndingsScreen(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(Theme.spacing.screenSpacing),
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {

        // Definite Article Table
        item {
            AdjectiveEndingTable(
                title = "Definite Article (der, das, die)",
                headers = listOf("", "♂\nmaskulin", "⚲\nneutral", "♀\nfeminin", "⚭\nPlural"),
                rows = listOf(
                    AdjectiveTableRow(
                        caseLabel = "Nominativ",
                        caseColor = Theme.adjectiveEndingColors.nominativ,
                        rowCells = listOf(
                            RowCell(
                                content = buildAnnotatedString {
                                    append("der groß")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("e")
                                    pop()

                                    append(" Mann")
                                },
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("das groß")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("e")
                                    pop()

                                    append(" Bild")
                                },
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("die groß")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("e")
                                    pop()

                                    append(" Hilfe")
                                },
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("die nett")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("en")
                                    pop()

                                    append(" Leuten")
                                },
                                ending = Ending.EN,
                            ),
                        ),
                    ),
                    AdjectiveTableRow(
                        caseLabel = "Akkusativ",
                        caseColor = Theme.adjectiveEndingColors.akkusativ,
                        rowCells = listOf(

                            RowCell(
                                content = buildAnnotatedString {
                                    append("den groß")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("en")
                                    pop()

                                    append(" Mann")
                                },
                                ending = Ending.EN,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("das groß")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("e")
                                    pop()

                                    append(" Bild")
                                },
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("die groß")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("e")
                                    pop()

                                    append(" Hilfe")
                                },
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("die nett")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("en")
                                    pop()

                                    append(" Leuten")
                                },
                                ending = Ending.EN,
                            ),
                        ),
                    ),
                    AdjectiveTableRow(
                        caseLabel = "Dativ",
                        caseColor = Theme.adjectiveEndingColors.dativ,
                        rowCells = listOf(
                            RowCell(
                                content = buildAnnotatedString {
                                    append("mit dem groß")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("en")
                                    pop()

                                    append(" Mann")
                                },
                                ending = Ending.EN,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("mit dem groß")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("en")
                                    pop()

                                    append(" Bild")
                                },
                                ending = Ending.EN,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("mit der groß")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("en")
                                    pop()

                                    append(" Hilfe")
                                },
                                ending = Ending.EN,
                            ),
                            RowCell(
                                content = buildAnnotatedString {

                                    append("mit den nett")

                                    pushStyle(
                                        SpanStyle(
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )
                                    append("en")
                                    pop()

                                    append(" Leuten")
                                },
                                ending = Ending.EN,
                            ),
                        ),
                    ),
                ),
            )
        }

        // Ein-words (ein, kein)
        item {
            AdjectiveEndingTable(
                title = "🟡 Ein-words (ein, kein)",
                headers = listOf("", "♂\nmaskulin", "⚲\nneutral", "♀\nfeminin"),
                note = "💡 \"ein\" has no plural — use kein/mein/etc. for plural forms (see below).",
                rows = listOf(
                    AdjectiveTableRow(
                        caseLabel = "Nominativ",
                        caseColor = Theme.adjectiveEndingColors.nominativ,
                        rowCells = listOf(
                            RowCell(
                                content = buildAnnotatedString {
                                    append("ein teu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("rer")
                                    pop()
                                    append(" Anzug")
                                },
                                ending = Ending.ER,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("ein hübsch")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("es")
                                    pop()
                                    append(" Hemd")
                                },
                                ending = Ending.ES,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("eine hell")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("e")
                                    pop()
                                    append(" Bluse")
                                },
                            ),
                        ),
                    ),
                    AdjectiveTableRow(
                        caseLabel = "Akkusativ",
                        caseColor = Theme.adjectiveEndingColors.akkusativ,
                        rowCells = listOf(
                            RowCell(
                                content = buildAnnotatedString {
                                    append("einen teur")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" Anzug")
                                },
                                ending = Ending.EN,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("ein hübsch")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("es")
                                    pop()
                                    append(" Hemd")
                                },
                                ending = Ending.ES,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("eine hell")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("e")
                                    pop()
                                    append(" Bluse")
                                },
                            ),
                        ),
                    ),
                    AdjectiveTableRow(
                        caseLabel = "Dativ",
                        caseColor = Theme.adjectiveEndingColors.dativ,
                        rowCells = listOf(
                            RowCell(
                                content = buildAnnotatedString {
                                    append("einem teur")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" Anzug")
                                },
                                ending = Ending.EN,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("einem hübsch")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" Hemd")
                                },
                                ending = Ending.EN,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("einer hell")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" Bluse")
                                },
                                ending = Ending.EN,
                            ),
                        ),
                    ),
                ),
            )
        }

        // Possessive (mein, dein, ihr...) — Singular + Plural
        item {
            AdjectiveEndingTable(
                title = "🟢 Singular Possessive (mein, dein, ihr...)",
                subtitle = "Same table as above",
                headers = listOf("", "♂\nmaskulin", "⚲\nneutral", "♀\nfeminin"),
                rows = listOf(
                    AdjectiveTableRow(
                        caseLabel = "Nominativ",
                        caseColor = Theme.adjectiveEndingColors.nominativ,
                        rowCells = listOf(
                            RowCell(
                                content = buildAnnotatedString {
                                    append("mein neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("er")
                                    pop()
                                    append(" Kollege")
                                },
                                ending = Ending.ER,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("mein neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("es")
                                    pop()
                                    append(" Auto")
                                },
                                ending = Ending.ES,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("meine neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("e")
                                    pop()
                                    append(" Tasche")
                                },
                            ),
                        ),
                    ),
                    AdjectiveTableRow(
                        caseLabel = "Akkusativ",
                        caseColor = Theme.adjectiveEndingColors.akkusativ,
                        rowCells = listOf(
                            RowCell(
                                content = buildAnnotatedString {
                                    append("meinen neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" Kollegen")
                                },
                                ending = Ending.EN,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("mein neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("es")
                                    pop()
                                    append(" Auto")
                                },
                                ending = Ending.ES,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("meine neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("e")
                                    pop()
                                    append(" Tasche")
                                },
                            ),
                        ),
                    ),
                    AdjectiveTableRow(
                        caseLabel = "Dativ",
                        caseColor = Theme.adjectiveEndingColors.dativ,
                        rowCells = listOf(
                            RowCell(
                                content = buildAnnotatedString {
                                    append("meinem neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" Kollegen")
                                },
                                ending = Ending.EN,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("meinem neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" Auto")
                                },
                                ending = Ending.EN,
                            ),
                            RowCell(
                                content = buildAnnotatedString {
                                    append("meiner neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" Tasche")
                                },
                                ending = Ending.EN,
                            ),
                        ),
                    ),
                ),
                pluralTitle = "Plural",
                pluralHeaders = listOf("", "Beispiel"),
                pluralRows = listOf(
                    AdjectiveTableRow(
                        caseLabel = "Nominativ",
                        caseColor = Theme.adjectiveEndingColors.nominativ,
                        rowCells = listOf(
                            RowCell(
                                content = buildAnnotatedString {
                                    append("meine neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" Kollegen")
                                },
                                ending = Ending.EN,
                            ),
                        ),
                    ),
                    AdjectiveTableRow(
                        caseLabel = "Akkusativ",
                        caseColor = Theme.adjectiveEndingColors.akkusativ,
                        rowCells = listOf(
                            RowCell(
                                content = buildAnnotatedString {
                                    append("meine neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" Kollegen")
                                },
                                ending = Ending.EN,
                            ),
                        ),
                    ),
                    AdjectiveTableRow(
                        caseLabel = "Dativ",
                        caseColor = Theme.adjectiveEndingColors.dativ,
                        rowCells = listOf(
                            RowCell(
                                content = buildAnnotatedString {
                                    append("mein")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" neu")
                                    pushStyle(SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold))
                                    append("en")
                                    pop()
                                    append(" Kollegen")
                                },
                                ending = Ending.EN,
                            ),
                        ),
                    ),
                ),
                pluralNote = "👉 Note:\n• meinen (dative plural)\n• noun gets -n → Kollegen",
            )
        }
    }
}

/**
 * Data class representing a row in the adjective endings table.
 */
private data class AdjectiveTableRow(
    val caseLabel: String,
    val caseLabelAbbrev: String = caseLabel.take(3).uppercase(),
    val caseColor: Color,
    val rowCells: List<RowCell>,
)

private data class RowCell(
    val content: AnnotatedString,
    val ending: Ending = Ending.E,
)

private enum class Ending {
    E, ER, ES, EN,
}

/**
 * Composable for displaying a complete adjective ending table.
 */
@Composable
private fun AdjectiveEndingTable(
    title: String,
    headers: List<String>,
    rows: List<AdjectiveTableRow>,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    note: String? = null,
    pluralTitle: String? = null,
    pluralHeaders: List<String>? = null,
    pluralRows: List<AdjectiveTableRow>? = null,
    pluralNote: String? = null,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        // Title
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
        )

        // Subtitle
        subtitle?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Normal,
            )
        }

        // Table
        TableSection(headers = headers, rows = rows)

        // Note section
        note?.let {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Text(
                    text = it,
                    fontSize = 10.sp,
                    lineHeight = 14.sp,
                )
            }
        }

        // Plural section
        if (pluralTitle != null && pluralHeaders != null && pluralRows != null) {
            Text(
                text = pluralTitle,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp),
            )

            TableSection(headers = pluralHeaders, rows = pluralRows)

            pluralNote?.let {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                ) {
                    Text(
                        text = it,
                        fontSize = 10.sp,
                        lineHeight = 14.sp,
                    )
                }
            }
        }
    }
}

@Composable
private fun TableSection(
    headers: List<String>,
    rows: List<AdjectiveTableRow>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ) {
        // Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme.grammarColors.tableHeader),
        ) {
            headers.forEachIndexed { index, header ->
                Box(
                    modifier = Modifier
                        .let {
                            if (index == 0) {
                                it.weight(0.3f)
                            } else {
                                it.weight(1f)
                            }
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = header,
                        autoSize = TextAutoSize.StepBased(
                            maxFontSize = 8.sp,
                        ),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondary,
                    )
                }
            }
        }

        // Data rows
        rows.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Case label (first column)
                Box(
                    modifier = Modifier
                        .weight(0.3f)
                        .background(row.caseColor)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = row.caseLabelAbbrev,
                        autoSize = TextAutoSize.StepBased(
                            maxFontSize = 7.sp,
                        ),
                        textAlign = TextAlign.Center,
                    )
                }

                // Value columns
                row.rowCells.forEachIndexed { index, value ->
                    Box(
                        modifier = Modifier
                            .let {
                                when (value.ending) {
                                    Ending.ER -> it.background(Color.Blue.copy(alpha = 0.15f))
                                    Ending.EN -> it.background(Color.Magenta.copy(alpha = 0.09f))
                                    Ending.ES -> it.background(Color.Green.copy(alpha = 0.15f))
                                    else -> it
                                }
                            }
                            .weight(1f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = value.content,
                            modifier = Modifier.padding(4.dp),
                            fontSize = 8.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 14.sp,
                        )
                    }
                }
            }
        }
    }
}

@[Preview Generated Composable]
internal fun AdjectiveEndingsScreenPreview() {
    Theme {
        AdjectiveEndingsScreen()
    }
}
