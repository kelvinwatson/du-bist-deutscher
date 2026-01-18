package com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded

import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.StringResource
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
        override val germanTitleRes: Int = StringResource.no_translate_title_prepositions
        override val localizedTitleRes: Int = StringResource.title_prepositions
    }

    @Serializable
    data object Connectors: Grammar {
        override val id: String = "Connectors"
        override val germanTitleRes: Int = StringResource.no_translate_title_connectors
        override val localizedTitleRes: Int = StringResource.title_connectors
    }

    @Serializable
    data object Adjectives : Grammar {
        override val id: String = "Adjectives"
        override val germanTitleRes: Int = StringResource.no_translate_title_adjectives
        override val localizedTitleRes: Int = StringResource.title_adjectives
    }
}