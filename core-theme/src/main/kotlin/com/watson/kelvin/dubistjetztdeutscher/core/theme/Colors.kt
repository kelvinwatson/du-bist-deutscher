@file:Suppress("ObjectPropertyName", "ConstPropertyName")

package com.watson.kelvin.dubistjetztdeutscher.core.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Color.Companion.White

val LocalColors = staticCompositionLocalOf<Colors> {
    error("No AppColors provided")
}

private object CoreColorResources {
    const val Nominativ: Int = 0xFF00FFFF.toInt()
    const val Akkusativ: Int = 0xFFFF5CE9.toInt()
    const val Dativ: Int = 0xFF00FF04.toInt()
    const val Genitive: Int = 0xFFb65Cff.toInt()
    const val Wechsel: Int = 0xFFFFA800.toInt()
}

enum class PrepositionColorKey {
    Akkusativ, Dativ, Wechsel, Genitive, ;

    companion object {
        /**
         * Extension function for PrepositionColorKey to get the color from AppPrepositionColors
         */
        fun PrepositionColorKey.toColor(colors: PrepositionColors): Color = when (this) {
            Akkusativ -> colors.akkusativ
            Dativ -> colors.dativ
            Wechsel -> colors.wechsel
            Genitive -> colors.genitive
        }

    }
}

object PrepositionColorResources {
    const val Akkusativ: Int = CoreColorResources.Akkusativ
    const val Dativ: Int = CoreColorResources.Dativ
    const val Wechsel: Int = CoreColorResources.Wechsel
    const val Genitive: Int = CoreColorResources.Genitive
}

enum class CaseColorKey { Nominativ, Akkusativ, Dativ, Genitive }
object CaseColorResources {
    const val Nominativ: Int = CoreColorResources.Nominativ
    const val Akkusativ: Int = CoreColorResources.Akkusativ
    const val Dativ: Int = CoreColorResources.Dativ
    const val Genitive: Int = CoreColorResources.Genitive
}

object ConnectorColorResources {
    const val Subordinating: Int = 0xFFD32F2F.toInt() // Red 700
    const val Coordinating: Int = 0xFF1976D2.toInt() // Blue 700
    const val Adverbial: Int = 0xFF388E3C.toInt() // Green 700
}

class PrepositionColors(
    val akkusativ: Color,
    val dativ: Color,
    val wechsel: Color,
    val genitive: Color
)

class CaseColors(
    val nominativ: Color,
    val akkusativ: Color,
    val dativ: Color,
    val genitive: Color
)

class ConnectorColors(
    val subordinating: Color,
    val coordinating: Color,
    val adverbial: Color
)

internal val appMaterialBasedColorScheme = darkColorScheme(
    primary = Black,
    secondary = Gray,
    onPrimary = Yellow,
    onSecondary = White,
)

object Colors {
    val prepositionColors = PrepositionColors(
        akkusativ = Color(PrepositionColorResources.Akkusativ),
        dativ = Color(PrepositionColorResources.Dativ),
        wechsel = Color(PrepositionColorResources.Wechsel),
        genitive = Color(PrepositionColorResources.Genitive)
    )
    val caseColors = CaseColors(
        nominativ = Color(CaseColorResources.Nominativ),
        akkusativ = Color(CaseColorResources.Akkusativ),
        dativ = Color(CaseColorResources.Dativ),
        genitive = Color(CaseColorResources.Genitive)
    )
    val connectorColors = ConnectorColors(
        subordinating = Color(ConnectorColorResources.Subordinating),
        coordinating = Color(ConnectorColorResources.Coordinating),
        adverbial = Color(ConnectorColorResources.Adverbial)
    )
}
