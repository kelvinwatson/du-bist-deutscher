package com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.watson.kelvin.dubistjetztdeutscher.R
import com.watson.kelvin.dubistjetztdeutscher.common.EnglishAdjective
import com.watson.kelvin.dubistjetztdeutscher.common.GermanAdjective
import com.watson.kelvin.dubistjetztdeutscher.core.theme.AdjectiveCategoryColors


/**
 * All adjective categories.
 */
enum class AdjectiveCategory(@get:StringRes val displayName: Int) {
    AGE(R.string.adjective_category_age),
    COLOR(R.string.adjective_category_color),
    DIFFICULTY(R.string.adjective_category_difficulty),
    EMOTION(R.string.adjective_category_emotion),
    MATERIAL(R.string.adjective_category_material),
    OPINION(R.string.adjective_category_opinion),
    PERSONALITY(R.string.adjective_category_personality),
    POSITION(R.string.adjective_category_position),
    QUALITY(R.string.adjective_category_quality),
    QUANTITY_COUNTABLE(R.string.adjective_category_quantity_countable),
    QUANTITY_UNCOUNTABLE(R.string.adjective_category_quantity_uncountable),
    SHAPE(R.string.adjective_category_shape),
    SIZE(R.string.adjective_category_size),
    STATE(R.string.adjective_category_state),
    TASTE(R.string.adjective_category_taste),
    TEMPERATURE(R.string.adjective_category_temperature);

    fun getMap(): Map<GermanAdjective, EnglishAdjective> = when (this) {
        AGE -> AdjectivesFallbackData.age
        COLOR -> AdjectivesFallbackData.color
        DIFFICULTY -> AdjectivesFallbackData.difficulty
        EMOTION -> AdjectivesFallbackData.emotion
        MATERIAL -> AdjectivesFallbackData.material
        OPINION -> AdjectivesFallbackData.opinion
        PERSONALITY -> AdjectivesFallbackData.personality
        POSITION -> AdjectivesFallbackData.position
        QUALITY -> AdjectivesFallbackData.quality
        QUANTITY_COUNTABLE -> AdjectivesFallbackData.quantityCountable
        QUANTITY_UNCOUNTABLE -> AdjectivesFallbackData.quantityUncountable
        SHAPE -> AdjectivesFallbackData.shape
        SIZE -> AdjectivesFallbackData.size
        STATE -> AdjectivesFallbackData.state
        TASTE -> AdjectivesFallbackData.taste
        TEMPERATURE -> AdjectivesFallbackData.temperature
    }

    fun getColor(colors: AdjectiveCategoryColors): Color = when (this) {
        AGE -> colors.age
        COLOR -> colors.color
        DIFFICULTY -> colors.difficulty
        EMOTION -> colors.emotion
        MATERIAL -> colors.material
        OPINION -> colors.opinion
        PERSONALITY -> colors.personality
        POSITION -> colors.position
        QUALITY -> colors.quality
        QUANTITY_COUNTABLE -> colors.quantityCountable
        QUANTITY_UNCOUNTABLE -> colors.quantityNonCountable
        SHAPE -> colors.shape
        SIZE -> colors.size
        STATE -> colors.state
        TASTE -> colors.taste
        TEMPERATURE -> colors.temperature
    }
}

object AdjectivesFallbackData {
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
    val quantityUncountable: Map<GermanAdjective, EnglishAdjective> = mapOf(
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
