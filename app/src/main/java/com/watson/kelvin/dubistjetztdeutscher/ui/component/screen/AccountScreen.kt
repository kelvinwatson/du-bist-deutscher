package com.watson.kelvin.dubistjetztdeutscher.ui.component.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "Welcome to the Profile Screen!",
    )
}