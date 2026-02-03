package com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks

import com.watson.kelvin.dubistjetztdeutscher.data.connectors.Connector
import com.watson.kelvin.dubistjetztdeutscher.data.connectors.ConnectorCategory

object ConnectorsFallbackData {

    /**
     * COORDINATING CONJUNCTIONS → Hauptsatz + Hauptsatz → Verb stays in position 2 (V2)
     */
    val coordinatingConjunctions = listOf(
        Connector(
            german = "aber",
            english = "but",
            example = "Ich mag Kaffee, aber ich trinke auch Tee.",
            category = ConnectorCategory.COORDINATING
        ),
        Connector(
            german = "bzw.",
            english = "or rather / respectively",
            example = "Wir treffen uns am Montag bzw. Dienstag.",
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
            german = "oder",
            english = "or",
            example = "Willst du Tee oder willst du Kaffee?",
            category = ConnectorCategory.COORDINATING
        ),
        Connector(
            german = "sondern",
            english = "but rather",
            example = "Nicht Kaffee, sondern Tee.",
            category = ConnectorCategory.COORDINATING
        ),
        Connector(
            german = "und",
            english = "and",
            example = "Ich komme und ich helfe dir.",
            category = ConnectorCategory.COORDINATING
        )
    )

    /**
     * SUBORDINATING CONJUNCTIONS → Nebensatz → verb at the end
     */
    val subordinatingConjunctions = listOf(
        Connector("als", "when (past)", "Als ich jung war, spielte ich Fußball.", ConnectorCategory.SUBORDINATING),
        Connector("bevor", "before", "Bevor er geht, ruft er an.", ConnectorCategory.SUBORDINATING),
        Connector("bis", "until", "Ich warte, bis du kommst.", ConnectorCategory.SUBORDINATING),
        Connector("da", "because (formal)", "Da es regnet, bleibe ich zu Hause.", ConnectorCategory.SUBORDINATING),
        Connector("damit", "so that", "Ich spreche laut, damit du mich hörst.", ConnectorCategory.SUBORDINATING, "⚠️ Do not confuse with dazu / dafür (adverbial, V2)"),
        Connector("dass", "that", "Ich denke, dass es regnet.", ConnectorCategory.SUBORDINATING),
        Connector("falls", "in case", "Falls du kommst, bringst du Essen mit.", ConnectorCategory.SUBORDINATING),
        Connector("indem", "by doing", "Er lernt Deutsch, indem er viel liest.", ConnectorCategory.SUBORDINATING),
        Connector("nachdem", "after", "Nachdem ich gegessen habe, gehe ich spazieren.", ConnectorCategory.SUBORDINATING),
        Connector("ob", "whether / if", "Ich frage mich, ob er da ist.", ConnectorCategory.SUBORDINATING),
        Connector("obgleich", "although / even though", "Obgleich ich müde bin, arbeite ich weiter.", ConnectorCategory.SUBORDINATING), // new
        Connector("obwohl", "although", "Obwohl ich müde bin, arbeite ich.", ConnectorCategory.SUBORDINATING),
        Connector("seit / seitdem", "since", "Seit ich hier wohne, bin ich glücklich.", ConnectorCategory.SUBORDINATING),
        Connector("sobald", "as soon as", "Sobald ich fertig bin, rufe ich dich an.", ConnectorCategory.SUBORDINATING), // new
        Connector("solange", "as long as", "Solange du lernst, helfe ich dir.", ConnectorCategory.SUBORDINATING), // new
        Connector("während", "while / whereas", "Während ich arbeite, hört er Musik.", ConnectorCategory.SUBORDINATING),
        Connector("wenn", "when / if", "Wenn er müde ist, geht er nicht zum Sport.", ConnectorCategory.SUBORDINATING),
        Connector("weil", "because", "Ich bleibe zu Hause, weil es regnet.", ConnectorCategory.SUBORDINATING)
    )

    /**
     * ADVERBIAL CONNECTORS → Hauptsatz → Verb in 2nd position
     */
    val adverbialConnectors = listOf(
        Connector("allerdings", "however", "Ich mag Kaffee. Allerdings trinke ich lieber Tee.", ConnectorCategory.ADVERBIAL), // new
        Connector("außerdem", "furthermore", "Ich gehe nicht einkaufen. Außerdem habe ich keine Zeit.", ConnectorCategory.ADVERBIAL),
        Connector("anschließend", "subsequently", "Wir essen. Anschließend gehen wir spazieren.", ConnectorCategory.ADVERBIAL), // new
        Connector("daher", "therefore", "Es regnet. Daher bleiben wir zu Hause.", ConnectorCategory.ADVERBIAL),
        Connector("danach", "afterwards", "Wir essen. Danach gehen wir spazieren.", ConnectorCategory.ADVERBIAL),
        Connector("dann", "then", "Zuerst essen wir. Dann gehen wir spazieren.", ConnectorCategory.ADVERBIAL),
        Connector("darüber hinaus", "moreover", "Er ist klug. Darüber hinaus ist er freundlich.", ConnectorCategory.ADVERBIAL), // new
        Connector("darum", "that's why", "Ich bin müde. Darum gehe ich früh ins Bett.", ConnectorCategory.ADVERBIAL),
        Connector("dazu", "in addition / while doing so", "Er kocht gern. Dazu hört er Musik.", ConnectorCategory.ADVERBIAL),
        Connector("dafür", "instead / in return", "Ich habe keine Zeit. Dafür habe ich morgen frei.", ConnectorCategory.ADVERBIAL),
        Connector("deshalb", "therefore", "Ich habe Hunger. Deshalb esse ich.", ConnectorCategory.ADVERBIAL),
        Connector("folglich", "consequently", "Es regnet, folglich bleiben wir zu Hause.", ConnectorCategory.ADVERBIAL), // new
        Connector("inzwischen", "meanwhile", "Ich koche. Inzwischen deckt er den Tisch.", ConnectorCategory.ADVERBIAL),
        Connector("jedoch", "however", "Ich mag Kaffee. Jedoch trinke ich lieber Tee.", ConnectorCategory.ADVERBIAL),
        Connector("sonst", "otherwise", "Beeil dich, sonst verpassen wir den Zug.", ConnectorCategory.ADVERBIAL),
        Connector("trotzdem", "nevertheless", "Es regnet. Trotzdem gehe ich raus.", ConnectorCategory.ADVERBIAL)
    )

    /**
     * NOT REAL CONNECTORS → No inversion, no verb movement
     */
    val nonConnectors = listOf(
        Connector("nämlich", "namely / because", "Ich bleibe zu Hause. Es regnet nämlich.", ConnectorCategory.NON_CONNECTOR, "⚠️ Does NOT trigger inversion or verb movement")
    )
}