package com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.grammatik.regeln

/**
 * Fallback data for German verb conjugation rules.
 */
object VerbConjugationRules {

    /**
     * Regular verb conjugation pattern (example: spielen)
     */
    val regularVerbs = VerbRule(
        infinitive = "spielen",
        present = "ich spiele, du spielst, er/sie/es spielt, wir spielen, ihr spielt, sie spielen",
        past = "ich spielte, du spieltest, er/sie/es spielte, wir spielten, ihr spieltet, sie spielten",
        perfect = "ich habe gespielt, du hast gespielt, er/sie/es hat gespielt",
        description = "Regular verbs follow a consistent pattern in present, past, and perfect tense."
    )

    /**
     * Irregular verb conjugation pattern (example: gehen)
     */
    val irregularVerbs = VerbRule(
        infinitive = "gehen",
        present = "ich gehe, du gehst, er/sie/es geht, wir gehen, ihr geht, sie gehen",
        past = "ich ging, du gingst, er/sie/es ging, wir gingen, ihr gingt, sie gingen",
        perfect = "ich bin gegangen, du bist gegangen, er/sie/es ist gegangen",
        description = "Irregular verbs often have stem changes and use sein or haben in perfect tense."
    )

    /**
     * Modal verbs example (können)
     */
    val modalVerbs = VerbRule(
        infinitive = "können",
        present = "ich kann, du kannst, er/sie/es kann, wir können, ihr könnt, sie können",
        past = "ich konnte, du konntest, er/sie/es konnte, wir konnten, ihr konntet, sie konnten",
        perfect = "ich habe gekonnt, du hast gekonnt, er/sie/es hat gekonnt",
        description = "Modal verbs have irregular present tense and often use another verb in infinitive."
    )

    /**
     * All rules in a list for easy access
     */
    val allVerbRules = listOf(
        regularVerbs,
        irregularVerbs,
        modalVerbs
    )
}

/**
 * Data class representing verb conjugation rules
 */
data class VerbRule(
    val infinitive: String,
    val present: String,
    val past: String,
    val perfect: String,
    val description: String
)