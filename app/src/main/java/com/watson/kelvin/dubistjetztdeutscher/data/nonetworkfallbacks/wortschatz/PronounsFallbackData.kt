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
            person = "1st singular",
            nominative = "ich",
            accusative = "mich",
            dative = "mir",
            genitive = null,
        ),
        MatrixPronoun(
            person = "2nd singular informal",
            nominative = "du",
            accusative = "dich",
            dative = "dir",
            genitive = null,
        ),
        MatrixPronoun(
            person = "3rd singular masculine",
            nominative = "er",
            accusative = "ihn",
            dative = "ihm",
            genitive = null,
            reflexive = "sich",
        ),
        MatrixPronoun(
            person = "3rd singular feminine",
            nominative = "sie",
            accusative = "sie",
            dative = "ihr",
            genitive = null,
            reflexive = "sich",
        ),
        MatrixPronoun(
            person = "3rd singular neuter",
            nominative = "es",
            accusative = "es",
            dative = "ihm",
            genitive = null,
            reflexive = "sich",
        ),
        MatrixPronoun(
            person = "1st plural",
            nominative = "wir",
            accusative = "uns",
            dative = "uns",
            genitive = null,
        ),
        MatrixPronoun(
            person = "2nd plural informal",
            nominative = "ihr",
            accusative = "euch",
            dative = "euch",
            genitive = null,
        ),
        MatrixPronoun(
            person = "3rd plural",
            nominative = "sie",
            accusative = "sie",
            dative = "ihnen",
            genitive = null,
            reflexive = "sich",
        ),
        MatrixPronoun(
            person = "2nd singular & plural formal",
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
            person = "1st singular",
            masculine = "mein / meinen / meinem / meiner",
            neuter = "mein / mein / meinem / meiner",
            feminine = "meine / meine / meiner / meiner",
            plural = "meine / meine / meinen / meiner"
        ),
        MatrixPossessive(
            person = "2nd singular informal",
            masculine = "dein / deinen / deinem / deiner",
            neuter = "dein / dein / deinem / deiner",
            feminine = "deine / deine / deiner / deiner",
            plural = "deine / deine / deinen / deiner"
        ),
        MatrixPossessive(
            person = "3rd singular masculine",
            masculine = "sein / seinen / seinem / seiner",
            neuter = "sein / sein / seinem / seiner",
            feminine = "seine / seine / seiner / seiner",
            plural = "seine / seine / seinen / seiner"
        ),
        MatrixPossessive(
            person = "3rd singular feminine",
            masculine = "ihr / ihren / ihrem / ihrer",
            neuter = "ihr / ihr / ihrem / ihrer",
            feminine = "ihre / ihre / ihrer / ihrer",
            plural = "ihre / ihre / ihren / ihrer"
        ),
        MatrixPossessive(
            person = "1st plural",
            masculine = "unser / unseren / unserem / unserer",
            neuter = "unser / unser / unserem / unserer",
            feminine = "unsere / unsere / unserer / unserer",
            plural = "unsere / unsere / unseren / unserer"
        ),
        MatrixPossessive(
            person = "2nd plural informal",
            masculine = "euer / euren / eurem / eurer",
            neuter = "euer / euer / eurem / eurer",
            feminine = "eure / eure / eurer / eurer",
            plural = "eure / eure / euren / eurer"
        ),
        MatrixPossessive(
            person = "2nd singular & plural formal",
            masculine = "Ihr / Ihren / Ihrem / Ihrer",
            neuter = "Ihr / Ihr / Ihrem / Ihrer",
            feminine = "Ihre / Ihre / Ihrer / Ihrer",
            plural = "Ihre / Ihre / Ihren / Ihrer"
        )
    )
}

/**
 * Represents grammatical genders with abbreviations
 */
enum class Gender(
    @StringRes val fullNameResId: Int,
    @StringRes val abbreviationResId: Int,
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