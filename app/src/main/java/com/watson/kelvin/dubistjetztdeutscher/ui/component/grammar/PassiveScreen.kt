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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import javax.annotation.processing.Generated

/**
 * Screen displaying German passive voice (Passiv) tables and explanations.
 */
@Composable
internal fun PassiveScreen(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(Theme.spacing.screenSpacing),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        // Definitions
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "Passiv (Passive Voice)",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    text = "• Vorgangspassiv = action/process (something is happening)\n• Zustandspassiv = state/result (something is already done)",
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                )
            }
        }

        item { HorizontalDivider(color = MaterialTheme.colorScheme.outline) }

        // Passive table
        item {
            PassiveTable()
        }

        item { HorizontalDivider(color = MaterialTheme.colorScheme.outline) }

        // Key section
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "🔑 Key",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    text = buildAnnotatedString {
                        append("• ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                        append("werden")
                        pop()
                        append("-system → action (Vorgangspassiv)\n• ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                        append("sein")
                        pop()
                        append("-system → state (Zustandspassiv)\n• ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red))
                        append("worden")
                        pop()
                        append(" → ONLY passive\n• ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                        append("geworden")
                        pop()
                        append(" → \"become\" (NOT passive)")
                    },
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                )
            }
        }

        item { HorizontalDivider(color = MaterialTheme.colorScheme.outline) }

        // Quick contrast
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "⚡ Quick Contrast",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    text = buildAnnotatedString {
                        append("• Die Tür ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF64B5F6)))
                        append("wird")
                        pop()
                        append(" geschlossen. → The door is being closed (action)\n• Die Tür ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF81C784)))
                        append("ist")
                        pop()
                        append(" geschlossen. → The door is closed (state)")
                    },
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                )
            }
        }

        item { HorizontalDivider(color = MaterialTheme.colorScheme.outline) }

        // Active vs Passive compact view
        item {
            Text(
                text = "Aktiv vs. Passiv",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }

        item {
            ActiveVsPassiveTable()
        }

        item { HorizontalDivider(color = MaterialTheme.colorScheme.outline) }

        // Active vs Passive key
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "🔑 Key",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    text = buildAnnotatedString {
                        append("• ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold, color = vorgangColor))
                        append("Aktiv")
                        pop()
                        append(" → subject does the action\n• ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold, color = zustandColor))
                        append("Passiv")
                        pop()
                        append(" → subject receives the action\n• Passive uses:\n  → ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                        append("werden")
                        pop()
                        append(" (present/past/future)\n  → ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                        append("sein + PII + worden")
                        pop()
                        append(" (perfect tenses)")
                    },
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                )
            }
        }

        item { HorizontalDivider(color = MaterialTheme.colorScheme.outline) }

        // State passive extra
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "📌 Extra (Zustandspassiv)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                StatePassiveTable()
            }
        }
    }
}

private val vorgangColor = Color(0xFF64B5F6) // blue
private val zustandColor = Color(0xFF81C784) // green
private val tableFontFamily = FontFamily.SansSerif

private data class PassiveRow(
    val type: String,
    val typeColor: Color,
    val tense: String,
    val structure: AnnotatedString,
    val example: AnnotatedString,
    val translation: String,
    val dividerBelow: Boolean = false,
)

private val werdenStyle = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF64B5F6))
private val seinStyle = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF81C784))

private val passiveRows = listOf(
    PassiveRow("Vorgangs-", vorgangColor, "Präsens",
        structure = buildAnnotatedString { pushStyle(werdenStyle); append("wird"); pop(); append(" + PII") },
        example = buildAnnotatedString { append("Die Tür "); pushStyle(werdenStyle); append("wird"); pop(); append(" geschlossen") },
        translation = "The door is being closed",
    ),
    PassiveRow("Vorgangs-", vorgangColor, "Präteritum",
        structure = buildAnnotatedString { pushStyle(werdenStyle); append("wurde"); pop(); append(" + PII") },
        example = buildAnnotatedString { append("Die Tür "); pushStyle(werdenStyle); append("wurde"); pop(); append(" geschlossen") },
        translation = "The door was closed",
        dividerBelow = true,
    ),
    PassiveRow("Vorgangs-", vorgangColor, "Perfekt",
        structure = buildAnnotatedString { pushStyle(seinStyle); append("ist"); pop(); append(" + PII + "); pushStyle(werdenStyle); append("worden"); pop() },
        example = buildAnnotatedString { append("Die Tür "); pushStyle(seinStyle); append("ist"); pop(); append(" geschlossen "); pushStyle(werdenStyle); append("worden"); pop() },
        translation = "The door has been closed",
    ),
    PassiveRow("Vorgangs-", vorgangColor, "Plusquam.",
        structure = buildAnnotatedString { pushStyle(seinStyle); append("war"); pop(); append(" + PII + "); pushStyle(werdenStyle); append("worden"); pop() },
        example = buildAnnotatedString { append("Die Tür "); pushStyle(seinStyle); append("war"); pop(); append(" geschlossen "); pushStyle(werdenStyle); append("worden"); pop() },
        translation = "The door had been closed",
    ),
    PassiveRow("Vorgangs-", vorgangColor, "Futur",
        structure = buildAnnotatedString { pushStyle(werdenStyle); append("wird"); pop(); append(" + PII + "); pushStyle(werdenStyle); append("werden"); pop() },
        example = buildAnnotatedString { append("Die Tür "); pushStyle(werdenStyle); append("wird"); pop(); append(" geschlossen "); pushStyle(werdenStyle); append("werden"); pop() },
        translation = "The door will be closed",
    ),
    PassiveRow("Zustands-", zustandColor, "Präsens",
        structure = buildAnnotatedString { pushStyle(seinStyle); append("ist"); pop(); append(" + PII") },
        example = buildAnnotatedString { append("Die Tür "); pushStyle(seinStyle); append("ist"); pop(); append(" geschlossen") },
        translation = "The door is closed",
    ),
    PassiveRow("Zustands-", zustandColor, "Präteritum",
        structure = buildAnnotatedString { pushStyle(seinStyle); append("war"); pop(); append(" + PII") },
        example = buildAnnotatedString { append("Die Tür "); pushStyle(seinStyle); append("war"); pop(); append(" geschlossen") },
        translation = "The door was closed (state)",
    ),
    PassiveRow("Zustands-", zustandColor, "Perfekt",
        structure = buildAnnotatedString { pushStyle(seinStyle); append("ist"); pop(); append(" + PII + "); pushStyle(seinStyle); append("gewesen"); pop() },
        example = buildAnnotatedString { append("Die Tür "); pushStyle(seinStyle); append("ist"); pop(); append(" geschlossen "); pushStyle(seinStyle); append("gewesen"); pop() },
        translation = "The door has been closed (state)",
    ),
)

@Composable
private fun PassiveTable(
    modifier: Modifier = Modifier,
) {
    val headers = listOf("Typ", "Tempus", "Struktur", "Beispiel", "Translation")

    Column(
        modifier = modifier.fillMaxWidth(),
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
                        .weight(
                            when (index) {
                                0 -> 0.5f
                                1 -> 0.5f
                                2 -> 0.9f
                                3 -> 1.3f
                                else -> 1.3f
                            },
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = header,
                        fontSize = 9.sp,
                        fontFamily = tableFontFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondary,
                    )
                }
            }
        }

        // Data rows
        passiveRows.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Type column
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxHeight()
                        .background(row.typeColor.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = row.type,
                        fontSize = 7.sp,
                        fontFamily = tableFontFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = row.typeColor,
                    )
                }

                // Tense column
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = row.tense,
                        fontSize = 8.sp,
                        fontFamily = tableFontFamily,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(4.dp),
                    )
                }

                // Structure column
                Box(
                    modifier = Modifier
                        .weight(0.9f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = row.structure,
                        fontSize = 8.sp,
                        fontFamily = tableFontFamily,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(2.dp),
                    )
                }

                // Example column
                Box(
                    modifier = Modifier
                        .weight(1.3f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = row.example,
                        fontSize = 8.sp,
                        fontFamily = tableFontFamily,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(2.dp),
                    )
                }

                // Translation column
                Box(
                    modifier = Modifier
                        .weight(1.3f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = row.translation,
                        fontSize = 8.sp,
                        fontFamily = tableFontFamily,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(2.dp),
                    )
                }
            }

            if (row.dividerBelow) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                )
            }
        }
    }
}

private data class ActiveVsPassiveRow(
    val tense: String,
    val active: String,
    val passive: String,
)

private val activeVsPassiveRows = listOf(
    ActiveVsPassiveRow("Präsens", "Ich schließe die Tür", "Die Tür wird geschlossen"),
    ActiveVsPassiveRow("Präteritum", "Ich schloss die Tür", "Die Tür wurde geschlossen"),
    ActiveVsPassiveRow("Perfekt", "Ich habe die Tür geschlossen", "Die Tür ist geschlossen worden"),
    ActiveVsPassiveRow("Plusquam.", "Ich hatte die Tür geschlossen", "Die Tür war geschlossen worden"),
    ActiveVsPassiveRow("Futur", "Ich werde die Tür schließen", "Die Tür wird geschlossen werden"),
)

@Composable
private fun ActiveVsPassiveTable(
    modifier: Modifier = Modifier,
) {
    val headers = listOf("Tempus", "Aktiv", "Vorgangspassiv")

    Column(
        modifier = modifier.fillMaxWidth(),
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
                        .weight(if (index == 0) 0.5f else 1.2f),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = header,
                        fontSize = 9.sp,
                        fontFamily = tableFontFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondary,
                    )
                }
            }
        }

        // Data rows
        activeVsPassiveRows.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Tense column
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = row.tense,
                        fontSize = 8.sp,
                        fontFamily = tableFontFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(4.dp),
                    )
                }

                // Active column
                Box(
                    modifier = Modifier
                        .weight(1.2f)
                        .fillMaxHeight()
                        .background(vorgangColor.copy(alpha = 0.08f)),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = row.active,
                        fontSize = 8.sp,
                        fontFamily = tableFontFamily,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(4.dp),
                    )
                }

                // Passive column
                Box(
                    modifier = Modifier
                        .weight(1.2f)
                        .fillMaxHeight()
                        .background(zustandColor.copy(alpha = 0.08f)),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = row.passive,
                        fontSize = 8.sp,
                        fontFamily = tableFontFamily,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(4.dp),
                    )
                }
            }
        }
    }
}

@Composable
private fun StatePassiveTable(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        // Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Theme.grammarColors.tableHeader),
        ) {
            listOf("Typ", "Beispiel", "Meaning").forEachIndexed { index, header ->
                Box(
                    modifier = Modifier
                        .weight(if (index == 0) 0.6f else 1f),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = header,
                        fontSize = 9.sp,
                        fontFamily = tableFontFamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondary,
                    )
                }
            }
        }

        // Single data row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxHeight()
                    .background(zustandColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Zustands-",
                    fontSize = 7.sp,
                    fontFamily = tableFontFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = zustandColor,
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Die Tür ist geschlossen",
                    fontSize = 8.sp,
                    fontFamily = tableFontFamily,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(4.dp),
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "The door is closed",
                    fontSize = 8.sp,
                    fontFamily = tableFontFamily,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(4.dp),
                )
            }
        }
    }
}

@[Preview Generated Composable]
internal fun PassiveScreenPreview() {
    Theme {
        PassiveScreen()
    }
}
