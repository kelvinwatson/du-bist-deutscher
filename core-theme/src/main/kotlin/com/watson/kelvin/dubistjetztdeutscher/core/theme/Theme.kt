package com.watson.kelvin.dubistjetztdeutscher.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

typealias Theme = MaterialTheme

@Composable
fun AppTheme(
    appColors: AppColors = defaultAppColors,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = appMaterialBasedColorScheme,
        typography = appMaterialBasedTypography
    ) {
        ProvideAppColors(appColors) {
            ProvideTextStyle(appMaterialBasedTextStyleDefault) {
                content()
            }
        }
    }
}

object AppTheme {

    @get:ReadOnlyComposable
    val prepositionColors: AppPrepositionColors
        @Composable get() = LocalAppColors.current.prepositionColors

}
