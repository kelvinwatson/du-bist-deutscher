package com.watson.kelvin.dubistjetztdeutscher.core.theme

import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

internal val appMaterialBasedTextStyleDefault = TextStyle.Default.copy(
    color = Yellow,
    fontFamily = FontFamily.Monospace,
)

private val materialTypography = androidx.compose.material3.Typography()

internal val appMaterialBasedTypography = androidx.compose.material3.Typography(
    displayLarge = materialTypography.displayLarge.merge(appMaterialBasedTextStyleDefault),
    displayMedium = materialTypography.displayMedium.merge(appMaterialBasedTextStyleDefault),
    displaySmall = materialTypography.displaySmall.merge(appMaterialBasedTextStyleDefault),
    headlineLarge = materialTypography.headlineLarge.merge(appMaterialBasedTextStyleDefault),
    headlineMedium = materialTypography.headlineMedium.merge(appMaterialBasedTextStyleDefault),
    headlineSmall = materialTypography.headlineSmall.merge(appMaterialBasedTextStyleDefault),
    titleLarge = materialTypography.titleLarge.merge(appMaterialBasedTextStyleDefault),
    titleMedium = materialTypography.titleMedium.merge(appMaterialBasedTextStyleDefault),
    titleSmall = materialTypography.titleSmall.merge(appMaterialBasedTextStyleDefault),
    bodyLarge = materialTypography.bodyLarge.merge(appMaterialBasedTextStyleDefault),
    bodyMedium = materialTypography.bodyMedium.merge(appMaterialBasedTextStyleDefault),
    bodySmall = materialTypography.bodySmall.merge(appMaterialBasedTextStyleDefault),
    labelLarge = materialTypography.labelLarge.merge(appMaterialBasedTextStyleDefault),
    labelMedium = materialTypography.labelMedium.merge(appMaterialBasedTextStyleDefault),
    labelSmall = materialTypography.labelSmall.merge(appMaterialBasedTextStyleDefault),
)
