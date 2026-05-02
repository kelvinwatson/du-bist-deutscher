package com.watson.kelvin.dubistjetztdeutscher.data

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

/**
 * Pre-built tips displayed on the Overview screen carousel.
 * German text is bolded; English text is regular weight.
 *
 * TODO: When dynamic/remote tips are implemented, this object becomes the no-network fallback.
 *  At that point, introduce a TipsRepository + OverviewViewModel to expose tips as a StateFlow,
 *  initialized with [all] as the default value.
 */
object Tips {

    private val bold = SpanStyle(fontWeight = FontWeight.Bold)

    val all: List<AnnotatedString> = listOf(
        buildAnnotatedString {
            append("👋 Welcome! We're going to learn German together. This is your reference companion for grammar and vocabulary.")
        },
        buildAnnotatedString {
            append("🔤 German has three genders — ")
            withStyle(bold) { append("der") }
            append(" (masculine), ")
            withStyle(bold) { append("das") }
            append(" (neuter) and ")
            withStyle(bold) { append("die") }
            append(" (feminine). Always learn the article with the noun!")
        },
        buildAnnotatedString {
            append("↔\uFE0F ")
            withStyle(bold) { append("Wechselpräpositionen") }
            append(" use ")
            withStyle(bold) { append("Akkusativ") }
            append(" for movement (")
            withStyle(bold) { append("Wohin?") }
            append(") and ")
            withStyle(bold) { append("Dativ") }
            append(" for location (")
            withStyle(bold) { append("Wo?") }
            append(").")
        },
        buildAnnotatedString {
            append("🧭 ")
            withStyle(bold) { append("Wohin?") }
            append(" → Akk: '")
            withStyle(bold) { append("Ich gehe in den Park.") }
            append("' '")
            withStyle(bold) { append("Ich lege das Buch auf den Tisch.") }
            append("' ")
            withStyle(bold) { append("Wo?") }
            append(" → Dat: '")
            withStyle(bold) { append("Ich bin in dem Park.") }
            append("' '")
            withStyle(bold) { append("Das Buch liegt auf dem Tisch.") }
            append("' Ask yourself: am I moving there, or already there?")
        },
        buildAnnotatedString {
            append("📝 In subordinate clauses (")
            withStyle(bold) { append("weil, dass, ob, wenn, als, obwohl") }
            append("…), the conjugated verb goes to the end — e.g. '")
            withStyle(bold) { append("Ich bleibe zu Hause, weil ich krank bin.") }
            append("'")
        },
        buildAnnotatedString {
            append("🎨 Adjective endings depend on the article type, gender, case, and number. Check the ")
            withStyle(bold) { append("Adjektivendungen") }
            append(" screen!")
        },
        buildAnnotatedString {
            append("⏳ Use '")
            withStyle(bold) { append("seit + Dativ") }
            append("' for durations still ongoing — e.g. '")
            withStyle(bold) { append("Ich lerne seit einem Jahr Deutsch.") }
            append("' If it's finished, use a past tense with '")
            withStyle(bold) { append("lang") }
            append("' or a time expression instead — e.g. '")
            withStyle(bold) { append("Ich habe zwei Jahre in Berlin gewohnt.") }
            append("'")
        },
        buildAnnotatedString {
            append("\uD83D\uDDE3\uFE0F Don't be afraid to ask people to slow down! Try: \"")
            withStyle(bold) { append("Es tut mir leid, ich lerne noch Deutsch. Könnten Sie bitte etwas langsamer sprechen?") }
            append("\" — most people will happily help.")
        },
        buildAnnotatedString {
            append("\uD83D\uDE4F Thank people for their patience: \"")
            withStyle(bold) { append("Vielen Dank im Voraus für Ihr Verständnis und Ihre Geduld.") }
            append("\" or simply \"")
            withStyle(bold) { append("Sie sind sehr geduldig, vielen Dank dafür.") }
            append("\"")
        },
    )

    /**
     * Expanded versions of tips for the bottom sheet, with examples on separate lines.
     */
    val expanded: List<AnnotatedString> = listOf(
        // 0 — Welcome
        all[0],
        // 1 — Genders
        buildAnnotatedString {
            append("🔤 German has three genders:\n\n")
            withStyle(bold) { append("der") }
            append(" — masculine\n")
            withStyle(bold) { append("das") }
            append(" — neuter\n")
            withStyle(bold) { append("die") }
            append(" — feminine\n\n")
            append("Always learn the article with the noun!")
        },
        // 2 — Wechselpräpositionen intro
        buildAnnotatedString {
            append("↔\uFE0F ")
            withStyle(bold) { append("Wechselpräpositionen") }
            append("\n\n")
            append("Movement (")
            withStyle(bold) { append("Wohin?") }
            append(") → ")
            withStyle(bold) { append("Akkusativ") }
            append("\n")
            append("Location (")
            withStyle(bold) { append("Wo?") }
            append(") → ")
            withStyle(bold) { append("Dativ") }
        },
        // 3 — Wohin/Wo examples
        buildAnnotatedString {
            append("🧭 ")
            withStyle(bold) { append("Wohin?") }
            append(" → Akkusativ (movement):\n\n")
            withStyle(bold) { append("  Ich gehe in den Park.") }
            append("\n")
            withStyle(bold) { append("  Ich lege das Buch auf den Tisch.") }
            append("\n\n")
            withStyle(bold) { append("Wo?") }
            append(" → Dativ (location):\n\n")
            withStyle(bold) { append("  Ich bin in dem Park.") }
            append("\n")
            withStyle(bold) { append("  Das Buch liegt auf dem Tisch.") }
            append("\n\n")
            append("Ask yourself: am I moving there, or already there?")
        },
        // 4 — Subordinate clauses
        buildAnnotatedString {
            append("📝 Subordinate clauses\n\n")
            append("With connectors like ")
            withStyle(bold) { append("weil, dass, ob, wenn, als, obwohl") }
            append("… the conjugated verb goes to the end.\n\n")
            append("Example:\n")
            withStyle(bold) { append("  Ich bleibe zu Hause, weil ich krank bin.") }
        },
        // 5 — Adjective endings
        buildAnnotatedString {
            append("🎨 Adjective endings\n\n")
            append("They depend on:\n")
            append("  • Article type\n")
            append("  • Gender\n")
            append("  • Case\n")
            append("  • Number\n\n")
            append("Check the ")
            withStyle(bold) { append("Adjektivendungen") }
            append(" screen!")
        },
        // 6 — seit + Dativ
        buildAnnotatedString {
            append("⏳ ")
            withStyle(bold) { append("seit + Dativ") }
            append("\n\n")
            append("Still ongoing:\n")
            withStyle(bold) { append("  Ich lerne seit einem Jahr Deutsch.") }
            append("\n\n")
            append("Already finished (use past tense):\n")
            withStyle(bold) { append("  Ich habe zwei Jahre in Berlin gewohnt.") }
        },
        // 7 — Ask to slow down
        buildAnnotatedString {
            append("\uD83D\uDDE3\uFE0F Don't be afraid to ask people to slow down!\n\n")
            append("Try:\n")
            withStyle(bold) { append("  \"Es tut mir leid, ich lerne noch Deutsch.\n  Könnten Sie bitte etwas langsamer sprechen?\"") }
            append("\n\n")
            append("Most people will happily help.")
        },
        // 8 — Thank for patience
        buildAnnotatedString {
            append("\uD83D\uDE4F Thank people for their patience:\n\n")
            withStyle(bold) { append("  \"Vielen Dank im Voraus für Ihr Verständnis\n  und Ihre Geduld.\"") }
            append("\n\nor simply:\n\n")
            withStyle(bold) { append("  \"Sie sind sehr geduldig, vielen Dank dafür.\"") }
        },
    )
}

