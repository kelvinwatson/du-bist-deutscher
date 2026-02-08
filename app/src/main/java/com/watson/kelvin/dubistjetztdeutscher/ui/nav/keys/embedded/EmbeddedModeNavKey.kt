package com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded

import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.StringResource
import kotlinx.serialization.Serializable

/**
 * Top level navigation destinations used in the embedded mode of the app.
 */
sealed interface EmbeddedModeNavKey : AppNavKey

sealed interface Grammar : EmbeddedModeNavKey
sealed interface Vocabulary : EmbeddedModeNavKey {

    /**
     * A full screen destination in the app.
     */
    @Serializable
    data object Prepositions : Vocabulary {
        override val id: String = "Prepositions"
        override val germanTitleRes: Int = StringResource.no_translate_title_prepositions
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_prepositions
    }

    @Serializable
    data object Connectors : Vocabulary {
        override val id: String = "Connectors"
        override val germanTitleRes: Int = StringResource.no_translate_title_connectors
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_connectors
    }

    @Serializable
    data class Adjectives(
        val focusSearch: Boolean = false,
    ) : Vocabulary {
        override val id: String = "Adjectives"
        override val germanTitleRes: Int = StringResource.no_translate_title_adjectives
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_adjectives
    }

    @Serializable
    data object PossessiveArticles : Vocabulary {
        override val id: String = "PossessiveArticles"
        override val germanTitleRes: Int = StringResource.no_translate_title_possessive_articles
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_possessive_articles
    }

    @Serializable
    data object Pronouns : Vocabulary {
        override val id: String = "Pronouns"
        override val germanTitleRes: Int = StringResource.no_translate_title_pronouns
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_pronouns
    }
}
