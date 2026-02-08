package com.watson.kelvin.dubistjetztdeutscher.core.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Centralized dimensions for the app
object Dimensions {
    val gridMinCellSize: Dp = 140.dp
    val gridHorizontalSpacing: Dp = 16.dp
    val gridVerticalSpacing: Dp = 8.dp
    val cellPadding: Dp = 16.dp
    val borderWidth: Dp = 2.dp
    val cornerRadius: Dp = 8.dp
    val screenPadding: Dp = 16.dp
    val sectionSpacing: Dp = 16.dp
    val pronounHeaderWidth: Dp = 100.dp
    val pronounCaseWidth: Dp = 96.dp
    val pronounPossessiveWidth: Dp = 120.dp
    val pronounRowHeight: Dp = 48.dp
}

val LocalDimens = staticCompositionLocalOf { Dimensions }
