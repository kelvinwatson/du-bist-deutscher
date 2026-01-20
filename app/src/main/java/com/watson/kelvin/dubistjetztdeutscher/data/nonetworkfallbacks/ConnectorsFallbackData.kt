package com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks

import com.watson.kelvin.dubistjetztdeutscher.data.connectors.Connector
import com.watson.kelvin.dubistjetztdeutscher.data.connectors.ConnectorCategory

// TODO: Replace static preposition lists with dynamic data loaded from an external source (e.g., remote CSV, API, or GitHub) so that prepositions can be updated without publishing a new app.
object ConnectorsFallbackData {

    /**
     * ============================================================
     * COORDINATING CONJUNCTIONS
     * → Hauptsatz + Hauptsatz
     * → Verb stays in position 2 (V2)
     * ============================================================
     */
    val coordinatingConjunctions = listOf(
        Connector(
            german = "und",
            english = "and",
            example = "Ich komme und ich helfe dir.",
            category = ConnectorCategory.COORDINATING
        ),
        Connector(
            german = "oder",
            english = "or",
            example = "Willst du Tee oder willst du Kaffee?",
            category = ConnectorCategory.COORDINATING
        ),
        Connector(
            german = "aber",
            english = "but",
            example = "Ich mag Kaffee, aber ich trinke auch Tee.",
            category = ConnectorCategory.COORDINATING
        ),
        Connector(
            german = "denn",
            english = "because / for",
            example = "Ich bleibe zu Hause, denn es regnet.",
            category = ConnectorCategory.COORDINATING,
            notes = "⚠️ denn ≠ weil — denn uses V2, weil is verb-final"
        ),
        Connector(
            german = "sondern",
            english = "but rather",
            example = "Nicht Kaffee, sondern Tee.",
            category = ConnectorCategory.COORDINATING
        )
    )

    /**
     * ============================================================
     * SUBORDINATING CONJUNCTIONS
     * → Nebensatz
     * → Conjugated verb ALWAYS at the end
     * ============================================================
     */
    val subordinatingConjunctions = listOf(
        Connector(
            german = "dass",
            english = "that",
            example = "Ich denke, dass es regnet.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "weil",
            english = "because",
            example = "Ich bleibe zu Hause, weil es regnet.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "da",
            english = "because (formal)",
            example = "Da es regnet, bleibe ich zu Hause.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "wenn",
            english = "when / if",
            example = "Wenn er müde ist, geht er nicht zum Sport.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "als",
            english = "when (past)",
            example = "Als ich jung war, spielte ich Fußball.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "ob",
            english = "whether / if",
            example = "Ich frage mich, ob er da ist.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "obwohl",
            english = "although",
            example = "Obwohl ich müde bin, arbeite ich.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "bevor",
            english = "before",
            example = "Bevor er geht, ruft er an.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "nachdem",
            english = "after",
            example = "Nachdem ich gegessen habe, gehe ich spazieren.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "bis",
            english = "until",
            example = "Ich warte, bis du kommst.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "seit / seitdem",
            english = "since",
            example = "Seit ich hier wohne, bin ich glücklich.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "während",
            english = "while / whereas",
            example = "Während ich arbeite, hört er Musik.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "falls",
            english = "in case",
            example = "Falls du kommst, bringst du Essen mit.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "damit",
            english = "so that",
            example = "Ich spreche laut, damit du mich hörst.",
            category = ConnectorCategory.SUBORDINATING,
            notes = "⚠️ Do not confuse with dazu / dafür (adverbial, V2)"
        ),
        Connector(
            german = "sobald",
            english = "as soon as",
            example = "Sobald er ankommt, rufe ich dich an.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "solange",
            english = "as long as",
            example = "Solange es regnet, bleiben wir drin.",
            category = ConnectorCategory.SUBORDINATING
        ),
        Connector(
            german = "indem",
            english = "by doing",
            example = "Er lernt Deutsch, indem er viel liest.",
            category = ConnectorCategory.SUBORDINATING
        )
    )

    /**
     * ============================================================
     * ADVERBIAL CONNECTORS
     * → Hauptsatz
     * → Verb stays in position 2 (often inversion)
     * ============================================================
     */
    val adverbialConnectors = listOf(
        Connector(
            german = "außerdem",
            english = "furthermore",
            example = "Ich gehe nicht einkaufen. Außerdem habe ich keine Zeit.",
            category = ConnectorCategory.ADVERBIAL
        ),
        Connector(
            german = "dazu",
            english = "in addition / while doing so",
            example = "Er kocht gern. Dazu hört er Musik.",
            category = ConnectorCategory.ADVERBIAL
        ),
        Connector(
            german = "deshalb",
            english = "therefore",
            example = "Ich habe Hunger. Deshalb esse ich.",
            category = ConnectorCategory.ADVERBIAL
        ),
        Connector(
            german = "darum",
            english = "that’s why",
            example = "Ich bin müde. Darum gehe ich früh ins Bett.",
            category = ConnectorCategory.ADVERBIAL
        ),
        Connector(
            german = "daher",
            english = "therefore",
            example = "Es regnet. Daher bleiben wir zu Hause.",
            category = ConnectorCategory.ADVERBIAL
        ),
        Connector(
            german = "trotzdem",
            english = "nevertheless",
            example = "Es regnet. Trotzdem gehe ich raus.",
            category = ConnectorCategory.ADVERBIAL
        ),
        Connector(
            german = "jedoch",
            english = "however",
            example = "Ich mag Kaffee. Jedoch trinke ich lieber Tee.",
            category = ConnectorCategory.ADVERBIAL
        ),
        Connector(
            german = "dafür",
            english = "instead / in return",
            example = "Ich habe keine Zeit. Dafür habe ich morgen frei.",
            category = ConnectorCategory.ADVERBIAL
        ),
        Connector(
            german = "sonst",
            english = "otherwise",
            example = "Beeil dich, sonst verpassen wir den Zug.",
            category = ConnectorCategory.ADVERBIAL
        ),
        Connector(
            german = "dann",
            english = "then",
            example = "Zuerst essen wir. Dann gehen wir spazieren.",
            category = ConnectorCategory.ADVERBIAL
        ),
        Connector(
            german = "danach",
            english = "afterwards",
            example = "Wir essen. Danach gehen wir spazieren.",
            category = ConnectorCategory.ADVERBIAL
        ),
        Connector(
            german = "inzwischen",
            english = "meanwhile",
            example = "Ich koche. Inzwischen deckt er den Tisch.",
            category = ConnectorCategory.ADVERBIAL
        )
    )

    /**
     * ============================================================
     * NOT REAL CONNECTORS
     * → No inversion, no verb movement
     * ============================================================
     */
    val nonConnectors = listOf(
        Connector(
            german = "nämlich",
            english = "namely / because",
            example = "Ich bleibe zu Hause. Es regnet nämlich.",
            category = ConnectorCategory.NON_CONNECTOR,
            notes = "⚠️ Does NOT trigger inversion or verb movement"
        )
    )
}
