package com.watson.kelvin.dubistjetztdeutscher.ui.component.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.watson.kelvin.dubistjetztdeutscher.R
import com.watson.kelvin.dubistjetztdeutscher.core.theme.LocalSpacing
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Grammar
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Vocabulary
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
        Grammar.AdjectiveEndings,
        Vocabulary.Adjectives(),
        Vocabulary.Connectors,
        Vocabulary.PossessiveArticles,
        Vocabulary.Prepositions,
        Vocabulary.Pronouns,
    )

    val sortedQuickLinks: List<Pair<AppNavKey, String>> = buildList {
        quickLinks.forEach { key ->
            add(key to stringResource(key.germanTitleRes))
        }
    }
        .sortedBy { (_, germanTitle) ->
            germanTitle
        }

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {

        item(key = "app_logo_and_welcome") {
            Row(
                modifier = Modifier
                    .background(
                        color = Theme.grammarColors.tableHeader,
                        shape = RoundedCornerShape(4.dp),
                    )
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_app_logo_simple),
                    contentDescription = null,
                    modifier = Modifier.size(96.dp),
                )

                Spacer(modifier = Modifier.width(16.dp))

                // Welcome text
                // TODO: let's actually make this a full bleed banner
                Text(
                    text = "We're going to learn German together. This is a reference companion containing grammar rules and vocabulary.",
                )
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
                        Grammar.AdjectiveEndings -> Theme.grammarCategoryColors.adjectives
                        is Vocabulary.Adjectives -> Theme.vocabularyCategoryColors.adjectives
                        Vocabulary.Connectors -> Theme.vocabularyCategoryColors.connectors
                        Vocabulary.PossessiveArticles -> Theme.vocabularyCategoryColors.possessiveArticles
                        Vocabulary.Prepositions -> Theme.vocabularyCategoryColors.prepositions
                        Vocabulary.Pronouns -> Theme.vocabularyCategoryColors.pronouns
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