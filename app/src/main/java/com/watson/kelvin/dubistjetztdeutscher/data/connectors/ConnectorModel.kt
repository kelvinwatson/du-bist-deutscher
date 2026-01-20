package com.watson.kelvin.dubistjetztdeutscher.data.connectors

/**
 * ============================================================
 * Connector categories based on clause type and verb position
 * ============================================================
 */
enum class ConnectorCategory(
    val description: String,
    val verbRule: String
) {
    COORDINATING(
        description = "Coordinating conjunction (Hauptsatz + Hauptsatz)",
        verbRule = "Verb stays in position 2 (V2)"
    ),

    SUBORDINATING(
        description = "Subordinating conjunction (Nebensatz)",
        verbRule = "Conjugated verb goes to the end (verb-final)"
    ),

    ADVERBIAL(
        description = "Adverbial connector (sentence adverb)",
        verbRule = "Verb stays in position 2, often with inversion"
    ),

    NON_CONNECTOR(
        description = "Not a real connector",
        verbRule = "No effect on word order"
    )
}

/**
 * ============================================================
 * Connector data model
 * ============================================================
 */
data class Connector(
    val german: String,
    val english: String,
    val example: String,
    val category: ConnectorCategory,
    val notes: String? = null
)
