@file:Suppress("ObjectPropertyName", "ConstPropertyName")

package com.watson.kelvin.dubistjetztdeutscher.core.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Yellow

val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("No AppColors provided")
}

@Composable
fun ProvideAppColors(
    appColors: AppColors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAppColors provides appColors
    ) {
        content()
    }
}

private object CoreColors {
    const val Nominativ: Int = 0xFF00FFFF.toInt()
    const val Akkusativ: Int = 0xFFFF5CE9.toInt()
    const val Dativ: Int = 0xFF00FF04.toInt()
    const val Genitive: Int = 0xFFb65Cff.toInt()
    const val Wechsel: Int = 0xFFFFA800.toInt()
}

enum class PrepositionColorKey { Akkusativ, Dativ, Wechsel, Genitive }
object PrepositionColors {
    const val Akkusativ: Int = CoreColors.Akkusativ
    const val Dativ: Int = CoreColors.Dativ
    const val Wechsel: Int = CoreColors.Wechsel
    const val Genitive: Int = CoreColors.Genitive
}

enum class CaseColorKey { Nominativ, Akkusativ, Dativ, Genitive }
object CaseColors {
    const val Nominativ: Int = CoreColors.Nominativ
    const val Akkusativ: Int = CoreColors.Akkusativ
    const val Dativ: Int = CoreColors.Dativ
    const val Genitive: Int = CoreColors.Genitive
}

class AppColors(
    val prepositionColors: AppPrepositionColors,
    val caseColors: AppCaseColors
)

class AppPrepositionColors(
    val akkusativ: Color,
    val dativ: Color,
    val wechsel: Color,
    val genitive: Color
)

class AppCaseColors(
    val nominativ: Color,
    val akkusativ: Color,
    val dativ: Color,
    val genitive: Color
)

internal val appMaterialBasedColorScheme = darkColorScheme(
    primary = Black,
    secondary = Gray,
    onPrimary = Yellow,
)

internal val defaultAppColors = AppColors(
    AppPrepositionColors(
        akkusativ = Color(PrepositionColors.Akkusativ),
        dativ = Color(PrepositionColors.Dativ),
        wechsel = Color(PrepositionColors.Wechsel),
        genitive = Color(PrepositionColors.Genitive)
    ),
    AppCaseColors(
        nominativ = Color(CaseColors.Nominativ),
        akkusativ = Color(CaseColors.Akkusativ),
        dativ = Color(CaseColors.Dativ),
        genitive = Color(CaseColors.Genitive)
    )
)
