package com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded

import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.StringResource
import kotlinx.serialization.Serializable

/**
 * Top level navigation destinations used in the embedded mode of the app.
 */
sealed interface EmbeddedModeNavKey : AppNavKey

/**
 * All embedded sub-screens within the Lernen (Learn) tab.
 */
sealed interface Lernen : EmbeddedModeNavKey {

    @Serializable
    data object AdjectiveEndings : Lernen {
        override val id: String = "AdjectiveEndings"
        override val germanTitleRes: Int = StringResource.no_translate_title_adjective_endings
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_adjective_endings
    }

    @Serializable
    data object Connectors : Lernen {
        override val id: String = "Connectors"
        override val germanTitleRes: Int = StringResource.no_translate_title_connectors
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_connectors
    }

    @Serializable
    data object Expressions : Lernen {
        override val id: String = "Expressions"
        override val germanTitleRes: Int = StringResource.no_translate_title_expressions
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_expressions
    }

    @Serializable
    data object Prepositions : Lernen {
        override val id: String = "Prepositions"
        override val germanTitleRes: Int = StringResource.no_translate_title_prepositions
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_prepositions
    }

    @Serializable
    data class Adjectives(
        val focusSearch: Boolean = false,
    ) : Lernen {
        override val id: String = "Adjectives"
        override val germanTitleRes: Int = StringResource.no_translate_title_adjectives
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_adjectives
    }

    @Serializable
    data object Passive : Lernen {
        override val id: String = "Passive"
        override val germanTitleRes: Int = StringResource.no_translate_title_passive
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_passive
    }

    @Serializable
    data object PossessiveArticles : Lernen {
        override val id: String = "PossessiveArticles"
        override val germanTitleRes: Int = StringResource.no_translate_title_possessive_articles
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_possessive_articles
    }

    @Serializable
    data object Pronouns : Lernen {
        override val id: String = "Pronouns"
        override val germanTitleRes: Int = StringResource.no_translate_title_pronouns
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_pronouns
    }
}
