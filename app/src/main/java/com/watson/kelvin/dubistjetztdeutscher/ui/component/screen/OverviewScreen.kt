package com.watson.kelvin.dubistjetztdeutscher.ui.component.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.watson.kelvin.dubistjetztdeutscher.core.theme.LocalSpacing
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.data.Tips
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Lernen
import javax.annotation.processing.Generated

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalAnimationApi::class,
    ExperimentalLayoutApi::class,
)
@Composable
internal fun OverviewScreen(
    modifier: Modifier = Modifier,
    onSearchBarActivated: (focusSearch: Boolean) -> Unit = {},
    onQuickLinkClick: (AppNavKey) -> Unit = {},
    recentPages: List<String> = emptyList(),
) {
    val quickLinks: List<AppNavKey> = listOf(
        Lernen.AdjectiveEndings,
        Lernen.Adjectives(),
        Lernen.Connectors,
        Lernen.Expressions,
        Lernen.PossessiveArticles,
        Lernen.Prepositions,
        Lernen.Pronouns,
    )

    val sortedQuickLinks: List<Pair<AppNavKey, String>> = buildList {
        quickLinks.forEach { key ->
            add(key to stringResource(key.germanTitleRes))
        }
    }
        .sortedBy { (_, germanTitle) ->
            germanTitle
        }

    val tips: List<AnnotatedString> = Tips.all

    var savedPage: Int by rememberSaveable { mutableIntStateOf(0) }
    val pagerState = rememberPagerState(
        initialPage = savedPage,
        pageCount = { tips.size },
    )

    LaunchedEffect(pagerState.currentPage) {
        savedPage = pagerState.currentPage
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {

        item(key = "tips_carousel") {
            var expandedTipIndex: Int? by remember { mutableStateOf(null) }
            val sheetState = rememberModalBottomSheetState()

            Column {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth(),
                ) { page ->
                    val tipColors: List<Color> = listOf(
                        Theme.caseColors.akkusativ,
                        Theme.caseColors.dativ,
                        Theme.prepositionColors.wechsel,
                        Theme.connectorColors.coordinating,
                    )
                    val tipBackgrounds: List<Color> = listOf(
                        Color(0xFF1A1A2E),
                        Color(0xFF16213E),
                        Color(0xFF1B2631),
                        Color(0xFF2C1A1D),
                    )
                    val tipColor: Color = tipColors[page % tipColors.size]
                    val tipBackground: Color = tipBackgrounds[page % tipBackgrounds.size]
                    Column(
                        modifier = Modifier
                            .padding(horizontal = LocalSpacing.current.screenSpacing)
                            .background(
                                color = tipBackground,
                                shape = RoundedCornerShape(12.dp),
                            )
                            .fillMaxWidth()
                            .height(160.dp)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        var hasOverflow: Boolean by remember { mutableStateOf(false) }
                        Text(
                            text = tips[page],
                            style = MaterialTheme.typography.bodyMedium,
                            color = tipColor,
                            maxLines = 5,
                            overflow = TextOverflow.Ellipsis,
                            onTextLayout = { result ->
                                hasOverflow = result.hasVisualOverflow
                            },
                        )
                        if (hasOverflow) {
                            Text(
                                text = "See more…",
                                style = MaterialTheme.typography.labelSmall,
                                color = tipColor.copy(alpha = 0.7f),
                                modifier = Modifier
                                    .clickable { expandedTipIndex = page }
                                    .padding(top = 4.dp),
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Page indicator dots
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    repeat(tips.size) { index ->
                        val isSelected: Boolean = pagerState.currentPage == index
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .size(if (isSelected) 8.dp else 6.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isSelected) MaterialTheme.colorScheme.primary
                                    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                                ),
                        )
                    }
                }
            }

            // Bottom sheet for full tip text
            if (expandedTipIndex != null) {
                val tipIndex: Int = expandedTipIndex!!
                val tipColors: List<Color> = listOf(
                    Theme.caseColors.akkusativ,
                    Theme.caseColors.dativ,
                    Theme.prepositionColors.wechsel,
                    Theme.connectorColors.coordinating,
                )
                ModalBottomSheet(
                    onDismissRequest = { expandedTipIndex = null },
                    sheetState = sheetState,
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .padding(bottom = 32.dp),
                    ) {
                        Text(
                            text = "Tip of the Day",
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = Tips.expanded[tipIndex],
                            style = MaterialTheme.typography.bodyLarge,
                            color = tipColors[tipIndex % tipColors.size],
                            lineHeight = 28.sp,
                        )
                    }
                }
            }
        }

        // Search Bar
        item(key = "adjectives_search_bar") {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = LocalSpacing.current.screenSpacing)
                    .clickable { onSearchBarActivated(true) },
            ) {
                OutlinedTextField(
                    value = "",
                    enabled = false,
                    onValueChange = { onSearchBarActivated(true) },
                    label = {
                        Text(
                            text = "\uD83D\uDD0D Search adjectives…",
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                )
            }
        }

        item(key = "recently_viewed") {
            Text(
                "Recently viewed",
                style = MaterialTheme.typography.titleLarge,
            )

            Column {
                recentPages.takeIf { it.isNotEmpty() }?.forEach { page ->
                    Text(
                        text = page,
                        modifier = Modifier.padding(start = 16.dp, top = 4.dp),
                    )
                } ?: Text(
                    text = "No recently viewed pages yet. Start surfing.",
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp),
                )
            }
        }

        item(key = "quick_links") {
            Text(
                text = "Quick links",
                style = MaterialTheme.typography.titleLarge,
            )

            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 8.dp,
                        horizontal = LocalSpacing.current.screenSpacing,
                    ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                sortedQuickLinks.forEach { (key, germanTitle) ->
                    val label = germanTitle
                    val chipColor: Color = when (key) {
                        Lernen.AdjectiveEndings -> Theme.grammarCategoryColors.adjectives
                        is Lernen.Adjectives -> Theme.vocabularyCategoryColors.adjectives
                        Lernen.Connectors -> Theme.vocabularyCategoryColors.connectors
                        Lernen.Expressions -> Theme.connectorColors.subordinating
                        Lernen.PossessiveArticles -> Theme.vocabularyCategoryColors.possessiveArticles
                        Lernen.Prepositions -> Theme.vocabularyCategoryColors.prepositions
                        Lernen.Pronouns -> Theme.vocabularyCategoryColors.pronouns
                        else -> Theme.grammarCategoryColors.adjectives
                    }

                    AssistChip(
                        modifier = Modifier
                            .height(28.dp),
                        onClick = { onQuickLinkClick(key) },
                        label = {
                            Text(
                                text = label,
                                style = MaterialTheme.typography.labelSmall,
                            )
                        },
                        colors = AssistChipDefaults.assistChipColors(
                            labelColor = chipColor,
                        ),
                        border = AssistChipDefaults.assistChipBorder(
                            enabled = true,
                            borderColor = chipColor,
                        ),
                    )
                }
            }
        }

        item(key = "whats_new") {
            Text(
                text = "What's new",
                style = MaterialTheme.typography.titleLarge,
            )

            Column {
                Text(
                    text = "Version 1.0.0 - Initial release with core grammar and vocabulary sections.",
                    modifier = Modifier.padding(start = 16.dp, top = 4.dp),
                )
            }
        }

        item(key = "app_info") {

            Text(
                text = "App information",
            )

            Text(
                text = "App version 1.0.0"
            )
        }
    }
}

@[Preview Generated Composable]
internal fun PreviewOverviewScreen() {
    Theme {
        OverviewScreen()
    }
}