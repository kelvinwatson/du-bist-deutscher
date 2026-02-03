package com.watson.kelvin.dubistjetztdeutscher.ui.nav.args

/**
 * Navigation argument for AdjectivesScreen.
 * Use FocusSearch to request focus on the search bar when navigating.
 */
sealed class AdjectivesScreenNavArg {
    object Default : AdjectivesScreenNavArg()
    object FocusSearch : AdjectivesScreenNavArg()
}

