package com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz

/**
 * Represents an adverb with its English meaning and example sentence.
 */
data class Adverb(
    val word: String,
    val meaning: String,
    val example: String?
)

/**
 * Adverbs fallback data → for offline usage or no-network scenarios.
 */
object AdverbsFallbackData {

    /**
     * Temporal adverbs → indicate time, continuation, sequence, or frequency.
     */
    val temporalAdverbs = listOf(
        Adverb("bald", "soon", "Wir treffen uns bald."),
        Adverb("gestern", "yesterday", "Gestern habe ich viel gelernt."),
        Adverb("heute", "today", "Heute gehe ich ins Kino."),
        Adverb("immer", "always", "Ich lerne immer Deutsch."),
        Adverb("morgen", "tomorrow", "Morgen fahren wir nach Berlin."),
        Adverb("noch", "still, yet", "Ich bin noch nicht fertig."),
        Adverb("weiterhin", "still, furthermore, continuing", "Ich werde weiterhin Deutsch lernen.")
    )

    /**
     * Degree/adverbial modifiers → intensity, amount, or extent.
     */
    val degreeAdverbs = listOf(
        Adverb("etwas", "somewhat, a bit", "Ich bin etwas müde."),
        Adverb("sehr", "very", "Ich bin sehr müde."),
        Adverb("ziemlich", "quite, rather", "Das ist ziemlich schwierig.")
    )

    /**
     * Manner adverbs → describe how an action is performed.
     */
    val mannerAdverbs = listOf(
        Adverb("gut", "well", "Ich kann gut kochen."),
        Adverb("langsam", "slowly", "Sie spricht langsam."),
        Adverb("schlecht", "badly", "Er singt schlecht."),
        Adverb("schnell", "quickly", "Er läuft schnell.")
    )
}