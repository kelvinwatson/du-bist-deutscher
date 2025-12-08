package com.watson.kelvin.dubistjetztdeutscher.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

typealias Theme = MaterialTheme


/**
 * There is only one theme, dark. Perhaps in the future, it can be customized to change the text
 * color from pink to yellow to green.
 */
private val appColorScheme = darkColorScheme(
    primary = Black,
    secondary = Gray,
    onPrimary = Yellow,
    onSecondary = Color(0xFFFF5ce9)
)

private val appTextStyleDefault = TextStyle.Default.copy(
    color = Yellow,
    fontFamily = FontFamily.Monospace,
)
private val materialTypography = androidx.compose.material3.Typography()
private val appTypography = androidx.compose.material3.Typography(
    displayLarge = materialTypography.displayLarge.merge(appTextStyleDefault),
    displayMedium = materialTypography.displayMedium.merge(appTextStyleDefault),
    displaySmall = materialTypography.displaySmall.merge(appTextStyleDefault),
    headlineLarge = materialTypography.headlineLarge.merge(appTextStyleDefault),
    headlineMedium = materialTypography.headlineMedium.merge(appTextStyleDefault),
    headlineSmall = materialTypography.headlineSmall.merge(appTextStyleDefault),
    titleLarge = materialTypography.titleLarge.merge(appTextStyleDefault),
    titleMedium = materialTypography.titleMedium.merge(appTextStyleDefault),
    titleSmall = materialTypography.titleSmall.merge(appTextStyleDefault),
    bodyLarge = materialTypography.bodyLarge.merge(appTextStyleDefault),
    bodyMedium = materialTypography.bodyMedium.merge(appTextStyleDefault),
    bodySmall = materialTypography.bodySmall.merge(appTextStyleDefault),
    labelLarge = materialTypography.labelLarge.merge(appTextStyleDefault),
    labelMedium = materialTypography.labelMedium.merge(appTextStyleDefault),
    labelSmall = materialTypography.labelSmall.merge(appTextStyleDefault),
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = appColorScheme,
        typography = appTypography
    ) {
        ProvideTextStyle(appTextStyleDefault) {
            content()
        }
    }
}

object AppTheme {
    @get:ReadOnlyComposable
    val prepositionColors: PrepositionColors = PrepositionColors

    @get:ReadOnlyComposable
    val caseColors: CaseColors = CaseColors
}

internal object CoreColors {
    val nominativ: Color = Color(0xFF00ffff)
    val akkusativ: Color = Color(0xFFFF5ce9)
    val dativ: Color = Color(0xFF00FF04)
    val genitive: Color = Color(0xFFb65Cff)
    val wechsel: Color = Color(0xFFFFA800)
}

object PrepositionColors {
    val akkusativ: Color = CoreColors.akkusativ
    val dativ: Color = CoreColors.dativ
    val wechsel: Color = CoreColors.wechsel
    val genitive: Color = CoreColors.genitive
}

object CaseColors {
    val nominativ: Color = CoreColors.nominativ
    val akkusativ: Color = CoreColors.akkusativ
    val dativ: Color = CoreColors.dativ
    val genitive: Color = CoreColors.genitive
}
