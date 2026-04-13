package com.kelvinwatson.dubistjetztdeutscher.data.model

enum class GrammaticalCase {
    AKKUSATIV,
    DATIV,
    GENITIV,
    WECHSEL,
    DATIV_GENITIV
}

enum class PrepositionCategory(val displayName: String) {
    AKKUSATIV_FIXED("Akkusativ (fixed)"),
    WECHSEL("Wechselpräpositionen"),
    DATIV_FIXED("Dativ (fixed)"),
    DATIV_GENITIV("Dativ / Genitiv"),
    GENITIV_FIXED("Genitiv (fixed)")
}

data class Preposition(
    val word: String,
    val case: GrammaticalCase,
    val category: PrepositionCategory,
    val semanticRole: String,
    val exampleAkk: String? = null,
    val exampleDat: String? = null,
    val exampleGen: String? = null,
    val note: String? = null
) {
    /** Returns the single example for fixed-case prepositions, or null for Wechsel. */
    val primaryExample: String?
        get() = exampleAkk ?: exampleDat ?: exampleGen
}

