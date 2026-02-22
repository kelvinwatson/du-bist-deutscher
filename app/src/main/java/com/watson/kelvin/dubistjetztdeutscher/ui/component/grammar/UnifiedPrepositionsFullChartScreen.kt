package com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz.PrepositionsFallbackData
import javax.annotation.processing.Generated

@Composable
internal fun UnifiedPrepositionsFullChartScreen(
    modifier: Modifier = Modifier,
) {
    val data = PrepositionsFallbackData.UnifiedPrepositionsFullChartFallbackData
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Title with icon
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "\uD83D\uDCC8", // Chart icon
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = data.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        // People/services table
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "\uD83D\uDC64", // Person icon
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = data.peopleServicesTitle,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        PrepositionsTable(
            headers = data.peopleServicesHeaders,
            rows = data.peopleServicesRows,
            headerColors = List(3) {
                Theme.prepositionColors.dativ
            },
        )
        Spacer(modifier = Modifier.height(24.dp))
        // Buildings/interiors table
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "\uD83C\uDFE2", // Building icon
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = data.buildingsTitle,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        PrepositionsTable(
            headers = data.buildingsHeaders,
            rows = data.buildingsRows,
            headerColors = listOf(
                Theme.prepositionColors.dativ,
                Theme.prepositionColors.dativ,
                Theme.prepositionColors.akkusativ,
            ),
        )
    }
}

@Composable
private fun PrepositionsTable(
    headers: List<String>,
    rows: List<List<String>>,
    headerColors: List<Color>,
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                headers.forEachIndexed { index, header ->
                    Text(
                        text = header,
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .background(
                                headerColors[index].copy(alpha = 0.3f),
                                RoundedCornerShape(4.dp),
                            ),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            rows.forEach { row ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    row.forEach { cell ->
                        Text(
                            text = cell,
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp),
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                }
            }
        }
    }
}

@[Preview Generated Composable]
internal fun UnifiedPrepositionsFullChartScreenPreview() {
    Theme {
        UnifiedPrepositionsFullChartScreen()
    }
}

