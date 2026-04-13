package com.kelvinwatson.dubistjetztdeutscher.data

import com.kelvinwatson.dubistjetztdeutscher.data.model.GrammaticalCase
import com.kelvinwatson.dubistjetztdeutscher.data.model.Preposition
import com.kelvinwatson.dubistjetztdeutscher.data.model.PrepositionCategory

object PrepositionData {

    // ── Akkusativ (fixed) ──────────────────────────────────────────────
    private val akkusativFixed = listOf(
        Preposition("bis", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "endpoint (time/space)", exampleAkk = "Ich bleibe bis morgen."),
        Preposition("durch", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "movement through", exampleAkk = "Ich gehe durch den Park."),
        Preposition("für", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "purpose/benefit", exampleAkk = "Das Geschenk ist für dich."),
        Preposition("gegen", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "direction/opposition", exampleAkk = "Er läuft gegen die Wand."),
        Preposition("ohne", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "absence", exampleAkk = "Ich gehe ohne meinen Freund."),
        Preposition("pro", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "rate", exampleAkk = "Das kostet 10 € pro Tag."),
        Preposition("um", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "around / goal", exampleAkk = "Wir sitzen um den Tisch."),
        Preposition("wider", GrammaticalCase.AKKUSATIV, PrepositionCategory.AKKUSATIV_FIXED, "against (formal)", exampleAkk = "Er handelt wider den Rat."),
    )

    // ── Wechselpräpositionen ───────────────────────────────────────────
    private val wechsel = listOf(
        Preposition("an", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich hänge das Bild an die Wand.", exampleDat = "Das Bild hängt an der Wand."),
        Preposition("auf", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich lege das Buch auf den Tisch.", exampleDat = "Das Buch liegt auf dem Tisch."),
        Preposition("entlang", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "after noun → Akk / before noun → Dat", exampleAkk = "Ich gehe den Fluss entlang.", exampleDat = "Ich gehe entlang dem Fluss.", note = "Position-dependent case"),
        Preposition("hinter", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich stelle das Auto hinter das Haus.", exampleDat = "Das Auto steht hinter dem Haus."),
        Preposition("in", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich gehe in den Raum.", exampleDat = "Ich bin in dem Raum."),
        Preposition("neben", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich setze mich neben den Mann.", exampleDat = "Ich sitze neben dem Mann."),
        Preposition("über", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich hänge die Lampe über den Tisch.", exampleDat = "Die Lampe hängt über dem Tisch."),
        Preposition("unter", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich stelle die Tasche unter den Tisch.", exampleDat = "Die Tasche ist unter dem Tisch."),
        Preposition("vor", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich gehe vor das Haus.", exampleDat = "Ich stehe vor dem Haus."),
        Preposition("zwischen", GrammaticalCase.WECHSEL, PrepositionCategory.WECHSEL, "Wohin → Akk / Wo → Dat", exampleAkk = "Ich stelle mich zwischen die Leute.", exampleDat = "Ich stehe zwischen den Leuten."),
    )

    // ── Dativ (fixed) ──────────────────────────────────────────────────
    private val dativFixed = listOf(
        Preposition("ab", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "time starting point", exampleDat = "Ab dem Montag arbeite ich."),
        Preposition("außer", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "exception", exampleDat = "Außer dem Kind ist niemand da."),
        Preposition("aus", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "origin (where from)", exampleDat = "Ich komme aus dem Haus."),
        Preposition("bei", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "location (Wo)", exampleDat = "Ich bin bei dem Arzt."),
        Preposition("gegenüber", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "position (Wo)", exampleDat = "Die Bank ist gegenüber dem Haus."),
        Preposition("gemäß", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "rule/reference", exampleDat = "Gemäß dem Gesetz ist das erlaubt."),
        Preposition("mit", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "accompaniment", exampleDat = "Ich gehe mit dem Freund."),
        Preposition("nach", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "direction (fixed!)", exampleDat = "Ich fahre nach Berlin.", note = "Expresses direction but always Dativ"),
        Preposition("seit", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "time duration", exampleDat = "Ich wohne seit dem Jahr hier."),
        Preposition("von", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "origin (where from)", exampleDat = "Das ist von dem Mann."),
        Preposition("zu", GrammaticalCase.DATIV, PrepositionCategory.DATIV_FIXED, "direction (fixed!)", exampleDat = "Ich gehe zu dem Arzt.", note = "Expresses direction but always Dativ"),
    )

    // ── Dativ / Genitiv ────────────────────────────────────────────────
    private val dativGenitiv = listOf(
        Preposition("laut", GrammaticalCase.DATIV_GENITIV, PrepositionCategory.DATIV_GENITIV, "reference (NOT location)", exampleDat = "Laut dem Bericht stimmt das."),
        Preposition("dank", GrammaticalCase.DATIV_GENITIV, PrepositionCategory.DATIV_GENITIV, "cause (NOT location)", exampleDat = "Dank dem Wetter bleiben wir zu Hause."),
    )

    // ── Genitiv (fixed) ────────────────────────────────────────────────
    private val genitivFixed = listOf(
        Preposition("angesichts", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "cause/context", exampleGen = "Angesichts des Problems handeln wir."),
        Preposition("anstatt", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "substitution", exampleGen = "Anstatt des Autos nehme ich das Fahrrad."),
        Preposition("außerhalb", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "outside (conceptual)", exampleGen = "Außerhalb der Stadt ist es ruhig."),
        Preposition("infolge", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "consequence", exampleGen = "Infolge des Unfalls ist die Straße gesperrt."),
        Preposition("innerhalb", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "time/area range", exampleGen = "Ich mache das innerhalb des Jahres."),
        Preposition("inmitten", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "in the middle (state)", exampleGen = "Er steht inmitten des Waldes."),
        Preposition("jenseits", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "beyond", exampleGen = "Jenseits des Flusses liegt das Dorf."),
        Preposition("oberhalb", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "above (relative)", exampleGen = "Oberhalb des Hauses ist ein Wald."),
        Preposition("seitens", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "from (institutional)", exampleGen = "Seitens der Firma gibt es Probleme."),
        Preposition("trotz", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "contrast", exampleGen = "Trotz des Regens gehe ich raus."),
        Preposition("unterhalb", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "below", exampleGen = "Unterhalb der Brücke ist Wasser."),
        Preposition("unweit", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "near", exampleGen = "Unweit des Sees wohne ich."),
        Preposition("während", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "time span", exampleGen = "Während des Tages arbeite ich."),
        Preposition("wegen", GrammaticalCase.GENITIV, PrepositionCategory.GENITIV_FIXED, "cause", exampleGen = "Wegen des Wetters bleiben wir zu Hause."),
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

