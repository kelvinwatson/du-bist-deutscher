package com.watson.kelvin.dubistjetztdeutscher.ui.component.title

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
    return "${stringResource(localizedTitleRes)} (${stringResource(germanTitleRes)})"
}

/**
 * Construct a translated title in the format:
 * <German>
 * (<Localized>)
 *
 * e.g.
 *
 * Präpositionen
 * (Prepositions)
 *
 * @param delimiter The delimiter to use between the two titles. Defaults to a newline.
 */
@Composable
fun NavIdentifier.delimitedTitle(delimiter: String = "\n"): String {
    return "${stringResource(localizedTitleRes)}\n(${stringResource(germanTitleRes)})"
}