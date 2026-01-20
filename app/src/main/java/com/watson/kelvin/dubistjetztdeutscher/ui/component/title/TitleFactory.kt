package com.watson.kelvin.dubistjetztdeutscher.ui.component.title

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.NavIdentifier

/**
 * Construct a translated title in the format: <German> (<Localized>)
 *
 * e.g. Präpositionen (Prepositions)
 */
@Composable
fun NavIdentifier.singleLineTitle(): String {
    val germanTitle = stringResource(germanTitleRes)
    return localizedTitleRes?.let { "${stringResource(it)} ($germanTitle)" } ?: germanTitle
}

@Composable
fun @receiver:StringRes Int.withParenthesizedTranslation(@StringRes translation: Int): String {
    return "${stringResource(this)} (${stringResource(translation)})"
}
