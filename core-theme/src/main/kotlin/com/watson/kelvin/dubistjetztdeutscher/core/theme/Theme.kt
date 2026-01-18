package com.watson.kelvin.dubistjetztdeutscher.core.theme

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle

@Composable
fun Theme(
    colors: Colors = Colors,
    dimensions: Dimensions = Dimensions,
    textStyle: TextStyle = LocalTextStyle.current.merge(appMaterialBasedTextStyleDefault),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = appMaterialBasedColorScheme,
        typography = appMaterialBasedTypography
    ) {
        CompositionLocalProvider(
            LocalColors provides colors,
            LocalDimens provides dimensions,
            LocalTextStyle provides textStyle,
            content = content,
        )
    }
}

object Theme {
    val caseColors: CaseColors
        @Composable get() = LocalColors.current.caseColors
    val connectorColors: ConnectorColors
        @Composable get() = LocalColors.current.connectorColors
    val dimens: Dimensions
        @Composable get() = LocalDimens.current
    val prepositionColors: PrepositionColors
        @Composable get() = LocalColors.current.prepositionColors
}
