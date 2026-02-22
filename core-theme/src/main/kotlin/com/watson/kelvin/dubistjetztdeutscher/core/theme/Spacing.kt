package com.watson.kelvin.dubistjetztdeutscher.core.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Data class for holding standard spacing values used throughout the app.
 */
data class Spacing(
    val screenSpacing: Dp = 16.dp,
)

/**
 * CompositionLocal for providing [Spacing] throughout the Compose hierarchy.
 */
val LocalSpacing = compositionLocalOf { Spacing() }
