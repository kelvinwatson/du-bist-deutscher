package com.kelvinwatson.dubistjetztdeutscher.data

import com.kelvinwatson.dubistjetztdeutscher.data.model.GrammaticalCase
import com.kelvinwatson.dubistjetztdeutscher.data.model.Preposition
import com.kelvinwatson.dubistjetztdeutscher.data.model.PrepositionCategory

object PrepositionData {

    // ── Akkusativ (fixed) ──────────────────────────────────────────────
    private val akkusativFixed = listOf(
        Preposition("bis", "until, by, up to", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "endpoint (time/space)", exampleAkk = "Ich bleibe bis morgen."),
        Preposition("durch", "through", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "movement through", exampleAkk = "Ich gehe durch den Park."),
        Preposition("für", "for", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "purpose/benefit", exampleAkk = "Das Geschenk ist für dich."),
        Preposition("gegen", "against", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "direction/opposition", exampleAkk = "Er läuft gegen die Wand."),
        Preposition("ohne", "without", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "absence", exampleAkk = "Ich gehe ohne meinen Freund."),
        Preposition("pro", "per", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "rate", exampleAkk = "Das kostet 10 € pro Tag."),
        Preposition("um", "around, at", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "around / goal", exampleAkk = "Wir sitzen um den Tisch."),
        Preposition("wider", "against (formal)", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "against (formal)", exampleAkk = "Er handelt wider den Rat."),
    )

    // ── Wechselpräpositionen ───────────────────────────────────────────
    private val wechsel = listOf(
        Preposition("an", "at, on (vertical)", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich hänge das Bild an die Wand.", exampleDat = "Das Bild hängt an der Wand."),
        Preposition("auf", "on (horizontal), up", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich lege das Buch auf den Tisch.", exampleDat = "Das Buch liegt auf dem Tisch."),
        Preposition("entlang", "along", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "after noun → Akk / before noun → Dat", exampleAkk = "Ich gehe den Fluss entlang.", exampleDat = "Ich gehe entlang dem Fluss.", note = "Position-dependent case"),
        Preposition("hinter", "behind", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich stelle das Auto hinter das Haus.", exampleDat = "Das Auto steht hinter dem Haus."),
        Preposition("in", "in, into", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich gehe in den Raum.", exampleDat = "Ich bin in dem Raum."),
        Preposition("neben", "next to, beside", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich setze mich neben den Mann.", exampleDat = "Ich sitze neben dem Mann."),
        Preposition("über", "over, above", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich hänge die Lampe über den Tisch.", exampleDat = "Die Lampe hängt über dem Tisch."),
        Preposition("unter", "under, below", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich stelle die Tasche unter den Tisch.", exampleDat = "Die Tasche ist unter dem Tisch."),
        Preposition("vor", "in front of, before", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich gehe vor das Haus.", exampleDat = "Ich stehe vor dem Haus."),
        Preposition("zwischen", "between", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich stelle mich zwischen die Leute.", exampleDat = "Ich stehe zwischen den Leuten."),
    )

    // ── Dativ (fixed) ──────────────────────────────────────────────────
    private val dativFixed = listOf(
        Preposition("ab", "from (time)", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "time starting point", exampleDat = "Ab dem Montag arbeite ich."),
        Preposition("außer", "except, besides", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "exception", exampleDat = "Außer dem Kind ist niemand da."),
        Preposition("aus", "out of, from", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "origin (where from)", exampleDat = "Ich komme aus dem Haus."),
        Preposition("bei", "at, near, with", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "location (Wo)", exampleDat = "Ich bin bei dem Arzt."),
        Preposition("gegenüber", "opposite, across from", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "position (Wo)", exampleDat = "Die Bank ist gegenüber dem Haus."),
        Preposition("gemäß", "according to", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "rule/reference", exampleDat = "Gemäß dem Gesetz ist das erlaubt."),
        Preposition("mit", "with", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "accompaniment", exampleDat = "Ich gehe mit dem Freund."),
        Preposition("nach", "to, after", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "direction (fixed!)", exampleDat = "Ich fahre nach Berlin.", note = "Expresses direction but always Dativ"),
        Preposition("seit", "since, for (time)", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "time duration", exampleDat = "Ich wohne seit dem Jahr hier."),
        Preposition("von", "from, of", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "origin (where from)", exampleDat = "Das ist von dem Mann."),
        Preposition("zu", "to", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "direction (fixed!)", exampleDat = "Ich gehe zu dem Arzt.", note = "Expresses direction but always Dativ"),
    )

    // ── Dativ / Genitiv ────────────────────────────────────────────────
    private val dativGenitiv = listOf(
        Preposition("laut", "according to", GrammaticalCase.DATIV_GENITIV, PrepositionCategory.DATIV_GENITIV, "reference (NOT location)", exampleDat = "Laut dem Bericht stimmt das."),
        Preposition("dank", "thanks to", GrammaticalCase.DATIV_GENITIV, PrepositionCategory.DATIV_GENITIV, "cause (NOT location)", exampleDat = "Dank dem Wetter bleiben wir zu Hause."),
    )

    // ── Genitiv (fixed) ────────────────────────────────────────────────
    private val genitivFixed = listOf(
        Preposition("angesichts", "in view of", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "cause/context", exampleGen = "Angesichts des Problems handeln wir."),
        Preposition("anstatt", "instead of", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "substitution", exampleGen = "Anstatt des Autos nehme ich das Fahrrad."),
        Preposition("außerhalb", "outside of", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "outside (conceptual)", exampleGen = "Außerhalb der Stadt ist es ruhig."),
        Preposition("infolge", "as a result of", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "consequence", exampleGen = "Infolge des Unfalls ist die Straße gesperrt."),
        Preposition("innerhalb", "within", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "time/area range", exampleGen = "Ich mache das innerhalb des Jahres."),
        Preposition("inmitten", "in the middle of", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "in the middle (state)", exampleGen = "Er steht inmitten des Waldes."),
        Preposition("jenseits", "beyond", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "beyond", exampleGen = "Jenseits des Flusses liegt das Dorf."),
        Preposition("oberhalb", "above", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "above (relative)", exampleGen = "Oberhalb des Hauses ist ein Wald."),
        Preposition("seitens", "on the part of", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "from (institutional)", exampleGen = "Seitens der Firma gibt es Probleme."),
        Preposition("trotz", "despite", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "contrast", exampleGen = "Trotz des Regens gehe ich raus."),
        Preposition("unterhalb", "below", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "below", exampleGen = "Unterhalb der Brücke ist Wasser."),
        Preposition("unweit", "not far from", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "near", exampleGen = "Unweit des Sees wohne ich."),
        Preposition("während", "during", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "time span", exampleGen = "Während des Tages arbeite ich."),
        Preposition("wegen", "because of", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "cause", exampleGen = "Wegen des Wetters bleiben wir zu Hause."),
    )

    /** All prepositions grouped by category in display order. */
    val allGrouped: Map<PrepositionCategory, List<Preposition>> = mapOf(
        PrepositionCategory.AKKUSATIV_FIXED to akkusativFixed,
        PrepositionCategory.WECHSEL to wechsel,
        PrepositionCategory.DATIV_FIXED to dativFixed,
        PrepositionCategory.DATIV_GENITIV to dativGenitiv,
        PrepositionCategory.GENITIV_FIXED to genitivFixed,
    )

    /** Flat list of every preposition. */
    val all: List<Preposition> = allGrouped.values.flatten()
}

