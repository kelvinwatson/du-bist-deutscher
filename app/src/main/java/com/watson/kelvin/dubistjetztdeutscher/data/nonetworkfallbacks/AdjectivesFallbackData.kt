package com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks

import androidx.annotation.StringRes
import com.watson.kelvin.dubistjetztdeutscher.R

// Enum for all adjective categories
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

    fun getMap(): Map<String, String> = when (this) {
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
}

object AdjectivesFallbackData {
    val age = mapOf(
        "antique" to "antik",
        "modern" to "modern",
        "new" to "neu",
        "old" to "alt",
        "young" to "jung"
    )
    val color = mapOf(
        "black" to "schwarz",
        "blue" to "blau",
        "brown" to "braun",
        "gray" to "grau",
        "green" to "grün",
        "orange" to "orange",
        "pink" to "rosa",
        "purple" to "lila",
        "red" to "rot",
        "white" to "weiß",
        "yellow" to "gelb"
    )
    val difficulty = mapOf(
        "challenging" to "herausfordernd",
        "complicated" to "kompliziert",
        "difficult" to "schwer",
        "easy" to "einfach",
        "hard" to "hart",
        "simple" to "simpel"
    )
    val emotion = mapOf(
        "angry" to "wütend",
        "bored" to "gelangweilt",
        "calm" to "ruhig",
        "confused" to "verwirrt",
        "excited" to "aufgeregt",
        "happy" to "glücklich",
        "sad" to "traurig",
        "scared" to "ängstlich",
        "surprised" to "überrascht",
        "tired" to "müde"
    )
    val material = mapOf(
        "firm" to "fest",
        "hard" to "hart",
        "rough" to "rau",
        "smooth" to "glatt",
        "soft" to "weich",
        "thick" to "dick",
        "thin" to "dünn"
    )
    val opinion = mapOf(
        "boring" to "langweilig",
        "cheap" to "billig",
        "expensive" to "teuer",
        "important" to "wichtig",
        "interesting" to "interessant",
        "practical" to "praktisch",
        "useful" to "nützlich"
    )
    val personality = mapOf(
        "brave" to "mutig",
        "fearful" to "ängstlich",
        "friendly" to "freundlich",
        "hardworking" to "fleißig",
        "helpful" to "hilfsbereit",
        "honest" to "ehrlich",
        "lazy" to "faul",
        "nice" to "nett"
    )
    val position = mapOf(
        "back" to "hinten",
        "bottom" to "unten",
        "front" to "vorn",
        "left" to "links",
        "right" to "rechts",
        "top" to "oben"
    )
    val quality = mapOf(
        "bad" to "schlecht",
        "beautiful" to "schön",
        "clean" to "sauber",
        "cold" to "kalt",
        "dirty" to "schmutzig",
        "fast" to "schnell",
        "good" to "gut",
        "happy" to "glücklich",
        "hot" to "heiß",
        "new" to "neu",
        "old" to "alt",
        "sad" to "traurig",
        "slow" to "langsam",
        "strong" to "stark",
        "ugly" to "hässlich",
        "weak" to "schwach"
    )
    val quantityCountable = mapOf(
        "all" to "die ganze Menge / alles",
        "enough" to "genug",
        "little" to "wenig",
        "much" to "viel",
        "none" to "nichts",
        "some" to "etwas"
    )
    val quantityUncountable = mapOf(
        "all" to "die ganze Menge / alles",
        "enough" to "genug",
        "little" to "wenig",
        "much" to "viel",
        "none" to "nichts",
        "some" to "etwas"
    )
    val shape = mapOf(
        "elongated" to "langgestreckt",
        "flat" to "flach",
        "pointed" to "spitz",
        "round" to "rund",
        "square" to "eckig"
    )
    val size = mapOf(
        "big" to "groß",
        "huge" to "riesig",
        "long" to "lang",
        "narrow" to "eng",
        "short" to "kurz",
        "small" to "klein",
        "tall" to "hoch",
        "tiny" to "winzig",
        "wide" to "breit"
    )
    val state = mapOf(
        "broken" to "kaputt",
        "busy" to "beschäftigt",
        "closed" to "geschlossen",
        "empty" to "leer",
        "full" to "voll",
        "open" to "offen",
        "ready" to "bereit"
    )
    val taste = mapOf(
        "bitter" to "bitter",
        "fragrant" to "duftend",
        "salty" to "salzig",
        "sour" to "sauer",
        "spicy" to "würzig",
        "sweet" to "süß"
    )
    val temperature = mapOf(
        "cold" to "kalt",
        "cool" to "kühl",
        "hot" to "heiß",
        "temperate" to "temperiert",
        "warm" to "warm"
    )
}
