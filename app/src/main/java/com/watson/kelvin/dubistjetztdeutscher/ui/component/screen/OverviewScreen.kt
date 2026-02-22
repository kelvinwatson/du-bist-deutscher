package com.watson.kelvin.dubistjetztdeutscher.ui.component.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.watson.kelvin.dubistjetztdeutscher.R
import com.watson.kelvin.dubistjetztdeutscher.core.theme.LocalSpacing
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import javax.annotation.processing.Generated

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun OverviewScreen(
    modifier: Modifier = Modifier,
    onSearchBarActivated: (focusSearch: Boolean) -> Unit = {},
    recentPages: List<String> = emptyList(),
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {

        item(key = "app_logo_and_welcome") {
            Row(
                modifier = Modifier
                    .background(
                        color = Theme.coreColors.green700,
                        shape = RoundedCornerShape(4.dp),
                    )
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_app_logo_simple),
                    contentDescription = null,
                    modifier = Modifier.size(96.dp)
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
                    .padding(LocalSpacing.current.screenSpacing)
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
private fun PreviewOverviewScreen() {
    Theme {
        OverviewScreen()
    }
}