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
