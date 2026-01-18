package com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks

import com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar.connectors.Connector

// TODO: Replace static preposition lists with dynamic data loaded from an external source (e.g., remote CSV, API, or GitHub) so that prepositions can be updated without publishing a new app.
@Suppress("SpellCheckingInspection")
object ConnectorsFallbackData {

    /**
     * Coordinating conjunctions → Hauptsatz (normal pos2 verb).
     * Conjugated verb is in pos 2. These do not alter word order.
     */
    val coordinatingConjunctions = listOf(
        Connector("aber", "but", "Ich mag Kaffee, aber ich trinke auch Tee."),
        Connector(
            "denn",
            "because/for",
            "Ich bleibe zu Hause, denn es regnet.",
            notes = "denn ≠ weil. denn → main clause (V2)\n\nweil → subordinate clause (verb-final)"
        ),
        Connector("oder", "or", "Willst du Tee oder willst du Kaffee?"),
        Connector("sondern", "but rather", "Nicht Kaffee, sondern Tee."),
        Connector("und", "and", "Ich komme und ich helfe dir."),
    )

    /**
     * Subordinating conjunctions → Nebensatz (verb-final).
     * ALWAYS send the conjugated verb to the end of the clause.
     */
    val subordinatingConjunctions = listOf(
        Connector("als", "when (past)", "Als ich jung war, spielte ich Fußball."),
        Connector("bevor", "before", "Bevor er geht, ruft er an."),
        Connector("bis", "until", "Ich warte, bis du kommst."),
        Connector("damit", "so that", "Ich spreche laut, damit du mich hörst."),
        Connector("dass", "that", "Ich denke, dass es regnet."),
        Connector("falls", "in case", "Falls du kommst, bringst du Essen mit (bleiben wir drin)."),
        Connector("nachdem", "after", "Nachdem ich gegessen habe, gehe ich (spazieren)."),
        Connector("ob", "whether/if", "Ich frage mich, ob er da ist."),
        Connector("obwohl", "although", "Obwohl ich müde bin, arbeite ich."),
        Connector("seit/seitdem", "since", "Seit ich hier wohne, bin ich glücklich."),
        Connector("während", "while/whereas", "Während ich arbeite, hört er Musik (lese er)."),
        Connector("weil", "because", "Ich bleibe zu Hause, weil es regnet."),
        Connector("wenn", "when/if", "Wenn er müde ist, er nicht zum Sport gehen."),
    )

    /**
     * Adverbial connectors → Hauptsatz (normal pos2 verb).
     * Linking adverbs that connect two main clauses. The conjugated verb remains in the second position.
     */
    val adverbialConnectors = listOf(
        Connector(
            "außerdem",
            "aside from that/besides/furthermore/moreover",
            "Ich gehe nicht einkaufen, außerdem habe ich keine Zeit."
        ),
        Connector(
            "allerdings",
            "however",
            "Ich komme mit. Allerdings bin ich etwas spät."
        ),
        Connector("dann", "then", "Zuerst essen wir, dann gehen wir spazieren."),
        Connector("danach", "afterwards", "Wir essen, danach gehen wir spazieren."),
        Connector("darum", "that's why", "Ich bin müde, darum gehe ich früh ins Bett."),
        Connector("deshalb", "therefore", "Ich habe hunger. Deshalb esse ich."),
        Connector("davor", "before that", "Wir gehen einkaufen, davor frühstücken wir."),
        Connector("jedoch", "however", "Ich mag Kaffee, jedoch trinke ich lieber Tee."),
        Connector("sonst", "otherwise", "Beeil dich, sonst verpassen wir den Zug."),
        Connector("trotzdem", "nevertheless/despite that", "Es regnet, trotzdem gehe ich mit."),
    )
}