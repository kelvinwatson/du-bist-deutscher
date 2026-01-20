package com.watson.kelvin.dubistjetztdeutscher.ui.component.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun OverviewScreen(
    modifier: Modifier = Modifier,
    onSearchBarActivated: () -> Unit = {}, // Should navigate to AdjectivesScreen and focus search bar there
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onSearchBarActivated() },
    ) {
        OutlinedTextField(
            value = "",
            enabled = false,
            onValueChange = { onSearchBarActivated() },
            label = { Text("Search adjectives...") },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true
        )
        // TODO: Navigation should pass a parameter to AdjectivesScreen to focus the search bar
    }
}