package com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz

import androidx.annotation.StringRes
import com.watson.kelvin.dubistjetztdeutscher.R
import com.watson.kelvin.dubistjetztdeutscher.common.EnglishAdjective
import com.watson.kelvin.dubistjetztdeutscher.common.GermanAdjective

/**
 * Categories of adjectives with their display names and
 * German to English translations of common adjectives.
 */
enum class AdjectivesFallback(
    @get:StringRes val displayName: Int,
    val germanToEnglish: Map<String, String>,
) {
    AGE(R.string.adjective_category_age, AdjectivesFallbackDefinitions.age),
    COLOR(R.string.adjective_category_color, AdjectivesFallbackDefinitions.color),
    DIFFICULTY(
        R.string.adjective_category_difficulty,
        AdjectivesFallbackDefinitions.difficulty,
    ),
    EMOTION(R.string.adjective_category_emotion, AdjectivesFallbackDefinitions.emotion),
    MATERIAL(R.string.adjective_category_material, AdjectivesFallbackDefinitions.material),
    OPINION(R.string.adjective_category_opinion, AdjectivesFallbackDefinitions.opinion),
    PERSONALITY(
        R.string.adjective_category_personality,
        AdjectivesFallbackDefinitions.personality,
    ),
    POSITION(R.string.adjective_category_position, AdjectivesFallbackDefinitions.position),
    QUALITY(R.string.adjective_category_quality, AdjectivesFallbackDefinitions.quality),
    QUANTITY_COUNTABLE(
        R.string.adjective_category_quantity_countable,
        AdjectivesFallbackDefinitions.quantityCountable,
    ),
    QUANTITY_UNCOUNTABLE(
        R.string.adjective_category_quantity_uncountable,
        AdjectivesFallbackDefinitions.quantityNonCountable,
    ),
    SHAPE(R.string.adjective_category_shape, AdjectivesFallbackDefinitions.shape),
    SIZE(R.string.adjective_category_size, AdjectivesFallbackDefinitions.size),
    STATE(R.string.adjective_category_state, AdjectivesFallbackDefinitions.state),
    TASTE(R.string.adjective_category_taste, AdjectivesFallbackDefinitions.taste),
    TEMPERATURE(
        R.string.adjective_category_temperature,
        AdjectivesFallbackDefinitions.temperature,
    ),
}

object AdjectivesFallbackDefinitions {
    val age: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "alt" to "old",
        "antik" to "antique",
        "jung" to "young",
        "modern" to "modern",
        "neu" to "new",
    )

    val color: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "blau" to "blue",
        "braun" to "brown",
        "gelb" to "yellow",
        "grau" to "gray",
        "grün" to "green",
        "lila" to "purple",
        "orange" to "orange",
        "rosa" to "pink",
        "rot" to "red",
        "schwarz" to "black",
        "weiß" to "white",
    )

    val difficulty: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "einfach" to "easy",
        "hart" to "hard",
        "herausfordernd" to "challenging",
        "kompliziert" to "complicated",
        "schwer" to "difficult",
        "simpel" to "simple",
    )

    val emotion: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "ängstlich" to "scared",
        "aufgeregt" to "excited",
        "gelangweilt" to "bored",
        "glücklich" to "happy",
        "müde" to "tired",
        "ruhig" to "calm",
        "traurig" to "sad",
        "überrascht" to "surprised",
        "verwirrt" to "confused",
        "wütend" to "angry",
    )

    val material: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "dick" to "thick",
        "dünn" to "thin",
        "fest" to "firm",
        "glatt" to "smooth",
        "hart" to "hard",
        "rau" to "rough",
        "weich" to "soft",
    )

    val opinion: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "billig" to "cheap",
        "interessant" to "interesting",
        "langweilig" to "boring",
        "nützlich" to "useful",
        "praktisch" to "practical",
        "teuer" to "expensive",
        "wichtig" to "important",
    )

    val personality: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "ängstlich" to "fearful",
        "ehrlich" to "honest",
        "faul" to "lazy",
        "fleißig" to "hardworking",
        "freundlich" to "friendly",
        "hilfsbereit" to "helpful",
        "mutig" to "brave",
        "nett" to "nice",
    )

    val position: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "hinten" to "back",
        "links" to "left",
        "oben" to "top",
        "rechts" to "right",
        "unten" to "bottom",
        "vorn" to "front",
    )

    val quality: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "alt" to "old",
        "gut" to "good",
        "hässlich" to "ugly",
        "heiß" to "hot",
        "kalt" to "cold",
        "langsam" to "slow",
        "neu" to "new",
        "sauber" to "clean",
        "schlecht" to "bad",
        "schnell" to "fast",
        "schmutzig" to "dirty",
        "schwach" to "weak",
        "schön" to "beautiful",
        "stark" to "strong",
        "traurig" to "sad",
    )

    val quantityCountable: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "die ganze Menge / alles" to "all",
        "etwas" to "some",
        "genug" to "enough",
        "nichts" to "none",
        "viel" to "much",
        "wenig" to "little",
    )

    val quantityNonCountable: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "die ganze Menge / alles" to "all",
        "etwas" to "some",
        "genug" to "enough",
        "nichts" to "none",
        "viel" to "much",
        "wenig" to "little",
    )

    val shape: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "eckig" to "square",
        "flach" to "flat",
        "langgestreckt" to "elongated",
        "rund" to "round",
        "spitz" to "pointed",
    )

    val size: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "breit" to "wide",
        "eng" to "narrow",
        "groß" to "big",
        "hoch" to "tall",
        "klein" to "small",
        "kurz" to "short",
        "lang" to "long",
        "riesig" to "huge",
        "winzig" to "tiny",
    )

    val state: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "beschäftigt" to "busy",
        "bereit" to "ready",
        "geschlossen" to "closed",
        "kaputt" to "broken",
        "leer" to "empty",
        "offen" to "open",
        "voll" to "full",
    )

    val taste: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "bitter" to "bitter",
        "duftend" to "fragrant",
        "sauer" to "sour",
        "salzig" to "salty",
        "süß" to "sweet",
        "würzig" to "spicy",
    )

    val temperature: Map<GermanAdjective, EnglishAdjective> = mapOf(
        "heiß" to "hot",
        "kalt" to "cold",
        "kühl" to "cool",
        "temperiert" to "temperate",
        "warm" to "warm",
    )
}