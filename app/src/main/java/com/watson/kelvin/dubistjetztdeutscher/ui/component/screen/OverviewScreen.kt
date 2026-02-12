package com.watson.kelvin.dubistjetztdeutscher.ui.component.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.watson.kelvin.dubistjetztdeutscher.R
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun OverviewScreen(
    modifier: Modifier = Modifier,
    onSearchBarActivated: (focusSearch: Boolean) -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(Theme.dimens.screenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        // App Logo
        Image(
            painter = painterResource(R.drawable.ic_app_logo_simple),
            contentDescription = "Du bist jetzt Deutscher Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(top = 32.dp),
        )

        // Search Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onSearchBarActivated(true) },
        ) {
            OutlinedTextField(
                value = "",
                enabled = false,
                onValueChange = { onSearchBarActivated(true) },
                label = { Text("Search adjectives...") },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true,
            )
            // TODO: Navigation should pass a parameter to AdjectivesScreen to focus the search bar
        }
    }
}