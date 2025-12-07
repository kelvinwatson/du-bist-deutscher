package com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded

import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.AppStringResource
import kotlinx.serialization.Serializable

/**
 * Top level navigation destinations used in the embedded mode of the app.
 */
sealed interface EmbeddedModeNavKey : AppNavKey

sealed interface Grammar : EmbeddedModeNavKey {

    /**
     * A full screen destination in the app.
     */
    @Serializable
    data object Prepositions : Grammar {
        override val id: String = "Prepositions"
        override val titleRes: Int = AppStringResource.title_prepositions
    }
}