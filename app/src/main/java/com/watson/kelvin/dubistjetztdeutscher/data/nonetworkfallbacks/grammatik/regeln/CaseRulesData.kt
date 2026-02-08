package com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.grammatik.regeln

/**
 * Fallback data for German case rules.
 */
object CaseRulesData {

    /**
     * Rule: Dative before Accusative
     */
    val dativeBeforeAccusative = Rule(
        name = "Dativ-vor-Akkusativ",
        description = "When a sentence contains both a dative and an accusative object, " +
                "the dative object usually comes first. Exceptions apply when pronouns are involved.",
        examples = listOf(
            "Ich gebe dem Mann das Buch.",
            "Ich gebe es dem Mann. (pronoun exception)",
            "Ich gebe ihn mir. (two pronouns: accusative before dative)"
        ),
    )

    /**
     * Rule: Genitive usage
     */
    val genitiveRules = Rule(
        name = "Genitivregel",
        description = "Certain prepositions and possessive constructions require the genitive case.",
        examples = listOf(
            "Wegen des Regens bleiben wir zu Hause.",
            "Trotz des schlechten Wetters gehen wir spazieren.",
            "Während des Essens telefoniere ich nicht."
        ),
    )

    /**
     * Rule: Two-way (Wechsel) prepositions
     */
    val twoWayPrepositionRule = Rule(
        name = "Wechselpräpositionen",
        description = "Two-way prepositions take the accusative for movement/direction " +
                "and dative for static location/time.",
        examples = listOf(
            "Akk: Ich lege das Buch auf den Tisch.",
            "Dat: Das Buch liegt auf dem Tisch.",
            "Akk: Ich gehe in das Haus.",
            "Dat: Ich bin in dem Haus."
        )
    )

    /**
     * All rules in a list for easy access
     */
    val allRules = listOf(
        dativeBeforeAccusative,
        genitiveRules,
        twoWayPrepositionRule
    )
}

/**
 * Data class representing a grammar rule
 */
data class Rule(
    val name: String,
    val description: String,
    val examples: List<String>
)