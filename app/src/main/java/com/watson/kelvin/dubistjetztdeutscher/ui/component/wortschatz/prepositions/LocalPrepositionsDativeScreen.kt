package com.watson.kelvin.dubistjetztdeutscher.ui.component.wortschatz.prepositions

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LocalPrepositionsDativeScreen(modifier: Modifier = Modifier) {
    val headers = listOf("Woher?\n+ Dativ", "Wo?\n+ Dativ", "Wohin?\n+ Dativ")
    val rows = listOf(
        listOf("Firmennamen:", "vom MöbelMaxx", "bei MöbelMaxx", "zu MöbelMaxx"),
        listOf("Personen:", "vom Benni", "bei Benni", "zu Benni"),
        listOf("vom Bäcker", "beim Bäcker", "zum Bäcker"),
        listOf("Aktivitäten:", "vom Einkaufen", "beim Einkaufen", "zum Einkaufen")
    )
    val headerColor = Color(0xFFE0E0E0)
    val borderColor = Color(0xFFBDBDBD)
    val highlightColor = Color(0xFFD32F2F) // Red for prepositions

    Column(
        modifier = modifier
            .padding(16.dp)
            .border(1.dp, borderColor, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
    ) {
        // Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(headerColor)
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("", modifier = Modifier.weight(1f)) // Empty top-left cell
            headers.forEach { header ->
                Text(
                    text = header,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.weight(2f),
                    color = Color.Black,
                )
            }
        }
        // Data rows
        rows.forEachIndexed { rowIndex, row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                row.forEachIndexed { colIndex, cell ->
                    val isHeader = colIndex == 0
                    val isPreposition = !isHeader && (cell.startsWith("vom") || cell.startsWith("bei") || cell.startsWith("zu") || cell.startsWith("beim") || cell.startsWith("zum"))
                    Box(
                        modifier = Modifier
                            .weight(if (isHeader) 1f else 2f)
                            .border(1.dp, borderColor)
                            .background(if (isHeader) headerColor else Color.Transparent)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = cell,
                            color = if (isPreposition) highlightColor else Color.Black,
                            style = if (isHeader) MaterialTheme.typography.labelLarge else MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

