package com.watson.kelvin.dubistjetztdeutscher.ui.component.wortschatz.pronouns

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz.MatrixPronoun
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz.PronounsFallbackData

/**
 * ViewModel for PersonalPronounsScreen that manages pronoun display logic.
 */
class PersonalPronounsViewModel : ViewModel() {

    /**
     * All personal pronouns data from the fallback source.
     */
    val matrixData = PronounsFallbackData.personalPronounsMatrix

    /**
     * Gets the display value for a pronoun at a specific case.
     * Appends reflexive form if available (for 3rd person and formal you).
     *
     * @param pronoun The pronoun data
     * @param caseIndex The case index (0=Nominativ, 1=Akkusativ, 2=Dativ)
     * @return The formatted string to display
     */
    fun getCaseValue(
        pronoun: MatrixPronoun,
        caseIndex: Int,
    ): String = when (caseIndex) {
        0 -> pronoun.nominative
        1 -> pronoun.accusative
        2 -> pronoun.dative
        else -> ""
    }.also {
        if (!pronoun.reflexive.isNullOrBlank()) {
            "$it\n${pronoun.reflexive}"
        }
    }

    /**
     * Gets the color for a specific case from the provided list.
     *
     * @param caseIndex The case index (0=Nominativ, 1=Akkusativ, 2=Dativ)
     * @param caseColors The list of case colors
     * @param fallbackColor The fallback color if index is out of bounds
     * @return The color for the case
     */
    fun getCaseColor(
        caseIndex: Int,
        caseColors: List<Color>,
        fallbackColor: Color,
    ): Color = caseColors.getOrElse(caseIndex) { fallbackColor }
}

