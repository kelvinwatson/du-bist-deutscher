package com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.ui.graphics.vector.ImageVector
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.StringResource
import kotlinx.serialization.Serializable

/**
 * Bottom navigation destinations used in the app.
 */
sealed interface BottomBarKey : AppNavKey {

    /**
     * The icon associated with this bottom navigation destination.
     */
    val icon: ImageVector

    /**
     * The localized string resource associated with this bottom navigation destination.
     */
    @get:StringRes
    val labelResource: Int

    @Serializable
    data object Overview : BottomBarKey {
        override val id: String = "Overview"
        override val germanTitleRes: Int = StringResource.no_translate_title_overview
        override val localizedTitleRes: Int? = null
        override val icon: ImageVector = Icons.Default.Home
        override val labelResource: Int = StringResource.nav_overview
    }

    @Serializable
    data object Grammar : BottomBarKey {
        override val id: String = "Grammar"
        override val germanTitleRes: Int = StringResource.no_translate_title_grammar
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_grammar
        override val icon: ImageVector = Icons.Default.School
        override val labelResource: Int = StringResource.nav_grammar
    }

    @Serializable
    data object Vocabulary : BottomBarKey {
        override val id: String = "Vocabulary"
        override val germanTitleRes: Int = StringResource.no_translate_title_vocabulary
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_vocabulary
        override val icon: ImageVector = Icons.Default.School
        override val labelResource: Int = StringResource.nav_vocabulary
    }

    @Serializable
    data object Account : BottomBarKey {
        override val id: String = "Account"
        override val germanTitleRes: Int = StringResource.no_translate_title_account
        override val localizedTitleRes: Int = StringResource.no_translate_en_title_account
        override val icon: ImageVector = Icons.Default.Person
        override val labelResource: Int = StringResource.nav_account
    }
}


object BottomBarNavKeys {
    val bottomBarKeys: List<BottomBarKey> = listOf(
        BottomBarKey.Overview,
        BottomBarKey.Grammar,
        BottomBarKey.Vocabulary,
        BottomBarKey.Account,
    )
}