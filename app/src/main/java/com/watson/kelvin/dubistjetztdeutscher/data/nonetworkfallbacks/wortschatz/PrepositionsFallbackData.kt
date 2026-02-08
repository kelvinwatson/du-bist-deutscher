package com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz

import com.watson.kelvin.dubistjetztdeutscher.ui.component.wortschatz.prepositions.Preposition

object PrepositionsFallbackData {

    /**
     * Accusative prepositions → direct object (Akkusativ)
     */
    val accusativePrepositions = listOf(
        Preposition("bis", "until, up to, by", "Ich gehe bis die Ecke."),
        Preposition("bis an", "right up to (a border or edge)", "Ich fahre bis an den Strand."),
        Preposition("bis auf", "except for / down to", "Bis auf einen Fehler war alles richtig."),
        Preposition("bis in", "into (time/direction)", "Wir haben bis in die Nacht gefeiert."),
        Preposition("bis über", "beyond / over", "Das Wasser ist bis über die Knie gestiegen."),
        Preposition(
            "bis unter",
            "up to underneath / as low as",
            "Der Schnee ist bis unter das Fenster gegangen."
        ),
        Preposition("durch", "through", "Wir gehen durch den Park."),
        Preposition("entlang", "along", "Wir spazieren den Fluss entlang."), // new
        Preposition("für", "for", "Das Geschenk ist für den Lehrer."),
        Preposition("gegen", "against", "Ich nehme Medizin gegen den Schnupfen."),
        Preposition("ins", "in the (maskulin/neuter)", "Wir fahren ins Büro."),
        Preposition("ohne", "without", "Ich gehe ohne den Freund."),
        Preposition("pro", "per", "Ich zahle fünf Euro pro Person."), // new
        Preposition("um", "around, at (time)", "Wir sitzen um den Tisch."),
    )

    /**
     * Dative prepositions → indirect object (Dativ)
     */
    val dativePrepositions = listOf(
        Preposition("ab", "from (without range)", null),
        Preposition(
            "am",
            "on (static location/temporal/event)",
            "Am Dienstag kann ich leider nicht."
        ),
        Preposition("aus", "out of, from", "Ich komme aus dem Haus."),
        Preposition("außer", "except for", "Alle kommen außer dem Lehrer."), // new
        Preposition("bei", "at, with", "Ich bin bei dem Lehrer."),
        Preposition("bis zu", "up to / as far as / until", "Ich gehe bis zu der Schule."),
        Preposition("gegenüber", "opposite", "Das Café ist dem Bahnhof gegenüber."),
        Preposition("im", "in the ([dat] maskulin/neuter)", null),
        Preposition("mit", "with", "Ich gehe mit dem Freund."),
        Preposition("nach", "to, after", "Wir fahren nach der Schule."),
        Preposition("seit", "since, for (time)", "Ich lerne Deutsch seit einem Jahr."),
        Preposition("von", "from (with range), of", "Das Geschenk ist von dem Freund."),
        Preposition("von dem", "from the", null),
        Preposition("zu", "to", "Ich gehe zu meinen Eltern."),
        Preposition("zufolge", "according to", "Dem Gesetz zufolge ist das erlaubt."), // new
        Preposition("zum", "to a/the ([mask, neut])", "Treffen wir uns zum Kaffee?"),
        Preposition("zur", "to a/the ([fem])", "Ich gehe zur Schule."),
    )

    /**
     * Two-way (Wechsel) prepositions → accusative (movement), dative (location)
     */
    val twoWayPrepositions = listOf(
        Preposition(
            "am",
            "on (static location/temporal/event)",
            "Dat: Am Dienstag kann ich leider nicht."
        ),
        Preposition(
            "an",
            "at, on (vertical surface)",
            "Akk: Ich hänge das Bild an die Wand. / Dat: Das Bild hängt an der Wand."
        ),
        Preposition(
            "auf",
            "on (horizontal surface), up",
            "Akk: Ich lege das Buch auf den Tisch. / Dat: Das Buch liegt auf dem Tisch."
        ),
        Preposition("entlang", "along", "Wir gehen den Weg entlang."), // new
        Preposition("hinter", "behind", "Akk [movement]: Dat [static location/temporal/event]:"),
        Preposition("in", "in, into", "Akk: Ich gehe in das Haus. / Dat: Ich bin in dem Haus."),
        Preposition("ins", "in the ([akk] neuter)", null),
        Preposition(
            "neben",
            "next to",
            "Akk: Ich setze mich neben den Mann. / Dat: Ich setze neben dem Mann."
        ),
        Preposition(
            "über",
            "over, above",
            "Akk: Ich hänge die Lampe über den Tisch. / Dat: Die Lampe hängt über dem Tisch."
        ),
        Preposition(
            "unter",
            "under",
            "Akk: Ich lege die Katze unter den Tisch. / Dat: Die Katze liegt unter dem Tisch."
        ),
        Preposition(
            "vor",
            "in front of",
            "Akk: Ich gehe vor das Haus. / Dat: Ich stehe vor dem Haus."
        ),
        Preposition(
            "zwischen",
            "in between",
            "Akk: Ich gehe zwischen die Häuser. / Dat: Ich stehe zwischen den Häusern."
        )
    )

    /**
     * Genitive prepositions → possessive/genitive case (Genitive)
     */
    val genitivePrepositions = listOf(
        Preposition("anstatt", "instead of", "Anstatt des Autos nehme ich das Fahrrad."), // new
        Preposition("außerhalb", "outside", "Außerhalb der Stadt ist es ruhig."),
        Preposition(
            "innerhalb",
            "inside/within",
            "Innerhalb einer Woche bekommst du eine Antwort."
        ),
        Preposition(
            "mithilfe",
            "with the help of",
            "Mithilfe des Lehrers habe ich alles verstanden."
        ), // new
        Preposition("statt", "instead of", "Statt des Autos nehme ich das Fahrrad."),
        Preposition("trotz", "despite", "Trotz des schlechten Wetters gehen wir spazieren."),
        Preposition("während", "during", "Während des Essens telefoniere ich nicht."),
        Preposition("wegen", "because of", "Wegen des Regens bleiben wir zu Hause."),
        Preposition(
            "zugunsten",
            "in favor of",
            "Das Geld wird zugunsten der Kinder gesammelt."
        ), // new
    )
}