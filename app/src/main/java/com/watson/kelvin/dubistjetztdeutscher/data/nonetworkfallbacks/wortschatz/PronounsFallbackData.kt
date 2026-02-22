package com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz

import androidx.annotation.StringRes
import com.watson.kelvin.dubistjetztdeutscher.R

/**
 * Pronouns and Possessives in a "matrix" style: all cases in one row per person.
 */
object PronounsFallbackData {

    /**
     * Personal pronouns
     */
    val personalPronounsMatrix = listOf(
        MatrixPronoun(
            person = "I/me",
            nominative = "ich",
            accusative = "mich",
            dative = "mir",
            genitive = null,
        ),
        MatrixPronoun(
            person = "you",
            nominative = "du",
            accusative = "dich",
            dative = "dir",
            genitive = null,
        ),
        MatrixPronoun(
            person = "he/him",
            nominative = "er",
            accusative = "ihn",
            dative = "ihm",
            genitive = null,
            reflexive = "sich",
        ),
        MatrixPronoun(
            person = "it",
            nominative = "es",
            accusative = "es",
            dative = "ihm",
            genitive = null,
            reflexive = "sich",
        ),
        MatrixPronoun(
            person = "she/her",
            nominative = "sie",
            accusative = "sie",
            dative = "ihr",
            genitive = null,
            reflexive = "sich",
        ),
        MatrixPronoun(
            person = "we/us",
            nominative = "wir",
            accusative = "uns",
            dative = "uns",
            genitive = null,
        ),
        MatrixPronoun(
            person = "you (plural)",
            nominative = "ihr",
            accusative = "euch",
            dative = "euch",
            genitive = null,
        ),
        MatrixPronoun(
            person = "they/them",
            nominative = "sie",
            accusative = "sie",
            dative = "ihnen",
            genitive = null,
            reflexive = "sich",
        ),
        MatrixPronoun(
            person = "You formal",
            nominative = "Sie",
            accusative = "Sie",
            dative = "Ihnen",
            genitive = null,
            reflexive = "sich",
        )
    )

    /**
     * Possessive pronouns matrix
     */
    val possessiveMatrix = listOf(
        MatrixPossessive(
            person = "ich (my)",
            masculine = "mein\nmeinen\nmeinem\nmeiner",
            neuter = "mein\nmein\nmeinem\nmeiner",
            feminine = "meine\nmeine\nmeiner\nmeiner",
            plural = "meine\nmeine\nmeinen\nmeiner"
        ),
        MatrixPossessive(
            person = "du\n(your)",
            masculine = "dein\ndeinen\ndeinem\ndeiner",
            neuter = "dein\ndein\ndeinem\ndeiner",
            feminine = "deine\ndeine\ndeiner\ndeiner",
            plural = "deine\ndeine\ndeinen\ndeiner"
        ),
        MatrixPossessive(
            person = "er\n(his)",
            masculine = "sein\nseinen\nseinem\nseiner",
            neuter = "sein\nsein\nseinem\nseiner",
            feminine = "seine\nseine\nseiner\nseiner",
            plural = "seine\nseine\nseinen\nseiner"
        ),
        MatrixPossessive(
            person = "sie\n(her, their)",
            masculine = "ihr\nihren\nihrem\nihrer",
            neuter = "ihr\nihr\nihrem\nihrer",
            feminine = "ihre\nihre\nihrer\nihrer",
            plural = "ihre\nihre\nihren\nihrer"
        ),
        MatrixPossessive(
            person = "wir\n(our)",
            masculine = "unser\nunseren\nunserem\n unserer",
            neuter = "unser\nunser\nunserem\nunserer",
            feminine = "unsere\nunsere\nunserer\nunserer",
            plural = "unsere\nunsere\nunseren\nunserer"
        ),
        MatrixPossessive(
            person = "ihr\n(your)",
            masculine = "euer\neuren\neurem\neurer",
            neuter = "euer\neuer\neurem\neurer",
            feminine = "eure\neure\neurer\neurer",
            plural = "eure\neure\neuren\neurer"
        ),
        MatrixPossessive(
            person = "Sie\n(Your)",
            masculine = "Ihr\nIhren\nIhrem\nIhrer",
            neuter = "Ihr\nIhr\nIhrem\nIhrer",
            feminine = "Ihre\nIhre\nIhrer\nIhrer",
            plural = "Ihre\nIhre\nIhren\nIhrer"
        )
    )
}

/**
 * Represents grammatical genders with abbreviations
 */
enum class Gender(
    @get:StringRes val fullNameResId: Int,
    @get:StringRes val abbreviationResId: Int,
) {
    Masculine(R.string.gender_masculine, R.string.gender_masculine_abbrev),
    Neuter(R.string.gender_neuter, R.string.gender_neuter_abbrev),
    Feminine(R.string.gender_feminine, R.string.gender_feminine_abbrev),
    Plural(R.string.gender_plural, R.string.gender_plural_abbrev),
}

/**
 * Represents a single pronoun with all cases in one row
 */
data class MatrixPronoun(
    val person: String,
    val nominative: String,
    val accusative: String,
    val dative: String,
    val genitive: String?,
    val reflexive: String? = null,
)

/**
 * Represents possessive forms for all genders and plural in one row
 */
data class MatrixPossessive(
    val person: String,
    val masculine: String,
    val neuter: String,
    val feminine: String,
    val plural: String
)