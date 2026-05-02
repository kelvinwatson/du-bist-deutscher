package com.watson.kelvin.dubistjetztdeutscher.data

/**
 * Conversational phrases for expressing feelings, opinions, agreement, and disagreement in German.
 *
 * TODO: When dynamic/remote data is implemented, this object becomes the no-network fallback.
 */
object ExpressionsPhraseData {

    /**
     * A phrase entry with a German expression, its English translation, and an optional usage note.
     * [expanded] contains additional examples/context shown in a bottom sheet when tapped.
     */
    data class Phrase(
        val german: String,
        val english: String,
        val note: String? = null,
        val expanded: List<Phrase>? = null,
    )

    /**
     * A section grouping related phrases under a heading.
     */
    data class Section(
        val title: String,
        val subtitle: String? = null,
        val phrases: List<Phrase>,
    )

    val sections: List<Section> = listOf(
        Section(
            title = "fühlen — to feel / to touch",
            subtitle = "Physical sensation or touch (no 'sich')",
            phrases = listOf(
                Phrase("Ich fühle den Tisch.", "I feel the table.", note = "Akkusativ — physically touching"),
                Phrase("Ich fühle den Wind.", "I feel the wind."),
                Phrase("Ich fühle seinen Puls.", "I feel his pulse."),
                Phrase("Fühl mal!", "Feel this!", note = "Imperative"),
            ),
        ),
        Section(
            title = "sich fühlen — to feel (emotion/state)",
            subtitle = "How you feel internally (reflexive)",
            phrases = listOf(
                Phrase(
                    german = "Ich fühle mich gut.",
                    english = "I feel good.",
                    expanded = listOf(
                        Phrase("Ich fühle mich nicht so gut.", "I don't feel so good."),
                        Phrase("Ich fühle mich müde.", "I feel tired."),
                        Phrase("Ich fühle mich komisch.", "I feel strange."),
                        Phrase("Ich fühle mich einsam.", "I feel lonely."),
                        Phrase("Ich fühle mich wohl.", "I feel comfortable/at ease."),
                        Phrase("Ich fühle mich unwohl.", "I feel uncomfortable."),
                        Phrase("Manchmal fühle ich mich dumm.", "Sometimes I feel stupid."),
                        Phrase("Er fühlt sich krank.", "He feels sick.", note = "sich → sich for er/sie/es"),
                    ),
                ),
                Phrase(
                    german = "Ich habe mich lebendig gefühlt.",
                    english = "I felt alive.",
                    note = "Perfekt — 'sich fühlen' in past tense",
                    expanded = listOf(
                        Phrase("Bei der Arbeit mit den Bienen habe ich mich so lebendig gefühlt.", "Working with the bees, I felt so alive."),
                    ),
                ),
            ),
        ),
        Section(
            title = "sich anfühlen — to feel like (description)",
            subtitle = "How something feels to the touch or seems (separable verb)",
            phrases = listOf(
                Phrase(
                    german = "Das fühlt sich gut an.",
                    english = "That feels good.",
                    expanded = listOf(
                        Phrase("Das fühlt sich richtig an.", "That feels right."),
                        Phrase("Das fühlt sich komisch an.", "That feels strange."),
                        Phrase("Das fühlt sich kalt an.", "That feels cold."),
                        Phrase("Das fühlt sich weich an.", "That feels soft."),
                        Phrase("Das fühlt sich falsch an.", "That feels wrong."),
                        Phrase("Es fühlt sich an wie Seide.", "It feels like silk."),
                    ),
                ),
                Phrase(
                    german = "Und das fühlt sich gut an.",
                    english = "And that feels good.",
                    note = "From textbook — confirming a positive outcome",
                ),
            ),
        ),
        Section(
            title = "Mir geht es… — How I'm doing",
            subtitle = "Dativ construction — common in everyday conversation",
            phrases = listOf(
                Phrase(
                    german = "Mir geht es gut.",
                    english = "I'm doing well.",
                    note = "Dativ — 'mir'",
                    expanded = listOf(
                        Phrase("Mir geht es schlecht.", "I'm doing badly."),
                        Phrase("Mir geht es besser.", "I'm doing better."),
                        Phrase("Mir geht es nicht so gut.", "I'm not doing so well."),
                    ),
                ),
                Phrase("Wie geht es Ihnen?", "How are you?", note = "Formal"),
                Phrase("Wie geht es dir?", "How are you?", note = "Informal"),
            ),
        ),
        Section(
            title = "Ich bin… — Describing your state",
            subtitle = "Adjective after 'sein'",
            phrases = listOf(
                Phrase(
                    german = "Ich bin müde / gestresst / nervös.",
                    english = "I am tired / stressed / nervous.",
                    expanded = listOf(
                        Phrase("Ich bin traurig.", "I am sad."),
                        Phrase("Ich bin wütend.", "I am angry."),
                        Phrase("Ich bin überrascht.", "I am surprised."),
                        Phrase("Ich bin enttäuscht.", "I am disappointed."),
                    ),
                ),
            ),
        ),
        Section(
            title = "Zufriedenheit / Begeisterung ausdrücken",
            subtitle = "Expressing satisfaction and enthusiasm",
            phrases = listOf(
                Phrase(
                    german = "Die Arbeit hat mir wirklich gut gefallen.",
                    english = "I really liked the work.",
                    note = "gefallen (pleased) — Perfekt + Dativ",
                    expanded = listOf(
                        Phrase("Ich bin zufrieden.", "I am satisfied."),
                        Phrase("Ich bin sehr zufrieden damit.", "I'm very satisfied with it."),
                        Phrase("Das hat mir sehr gut gefallen.", "I liked that very much."),
                    ),
                ),
                Phrase(
                    german = "Da hab' ich gemerkt: Genau das macht mir Spaß.",
                    english = "That's when I noticed: that's exactly what's fun for me.",
                    note = "'merken' = to notice; 'Spaß machen' = to be fun",
                ),
                Phrase(
                    german = "Ich hab' alles richtig gemacht!",
                    english = "I did everything right!",
                ),
                Phrase(
                    german = "Ich bin begeistert!",
                    english = "I am thrilled!",
                    expanded = listOf(
                        Phrase("Das ist toll!", "That's great!"),
                        Phrase("Das ist wunderbar!", "That's wonderful!"),
                        Phrase("Das freut mich!", "That makes me happy!", note = "Akkusativ — 'mich'"),
                        Phrase("Das finde ich super!", "I think that's awesome!"),
                        Phrase("Klasse!", "Brilliant!", note = "Colloquial"),
                    ),
                ),
                Phrase("Sie schätzen es, wenn die Ausländer deutsch sprechen.", "They appreciate it when foreigners speak German."),
                Phrase("Sie merken, dass mein Deutsch besser wird.", "They notice that my German is getting better.", note = "'merken' = to notice"),
                Phrase("Sie lachen mit mir.", "They laugh with me.", note = "Friendly — laughing together"),
            ),
        ),
        Section(
            title = "Unzufriedenheit ausdrücken",
            subtitle = "Expressing dissatisfaction",
            phrases = listOf(
                Phrase(
                    german = "Ich hab' mich gefragt: Willst du das wirklich immer so machen?",
                    english = "I asked myself: Do you really always want to do it this way?",
                    note = "sich fragen — to ask oneself",
                ),
                Phrase(
                    german = "Es hat mir irgendetwas gefehlt.",
                    english = "Something was missing for me.",
                    note = "fehlen + Dativ — 'mir hat etwas gefehlt'",
                ),
                Phrase(
                    german = "Richtig glücklich war ich mit meiner Arbeit nicht.",
                    english = "I wasn't really happy with my work.",
                    note = "Inverted word order for emphasis",
                ),
                Phrase(
                    german = "Mir war klar: Ich muss mich beruflich verändern.",
                    english = "It was clear to me: I have to change professionally.",
                    note = "sich verändern — to change (oneself)",
                ),
                Phrase(
                    german = "Das ärgert mich.",
                    english = "That annoys me.",
                    expanded = listOf(
                        Phrase("Ich bin unzufrieden.", "I am dissatisfied."),
                        Phrase("Ich bin nicht zufrieden damit.", "I'm not satisfied with it."),
                        Phrase("Das gefällt mir nicht.", "I don't like that.", note = "Dativ — 'mir'"),
                        Phrase("Das enttäuscht mich.", "That disappoints me."),
                        Phrase("Das stört mich.", "That bothers me."),
                        Phrase("Das geht so nicht.", "That's not acceptable.", note = "Colloquial"),
                        Phrase("Das hätte besser sein können.", "That could have been better.", note = "Konjunktiv II"),
                    ),
                ),
                Phrase("Es dauert sehr lange.", "It takes a very long time."),
                Phrase("Ich muss geduldig sein.", "I have to be patient."),
                Phrase("Sie lachen mich aus.", "They laugh at me.", note = "Böse — 'auslachen' = to mock"),
            ),
        ),
        Section(
            title = "Expressing opinions",
            subtitle = "Ich finde… / Ich denke… / Meiner Meinung nach…",
            phrases = listOf(
                Phrase(
                    german = "Ich finde das gut.",
                    english = "I think that's good.",
                    note = "'finden' is casual",
                    expanded = listOf(
                        Phrase("Ich finde das schlecht.", "I think that's bad."),
                        Phrase("Ich finde das interessant.", "I find that interesting."),
                        Phrase("Ich finde das langweilig.", "I find that boring."),
                    ),
                ),
                Phrase("Ich denke, dass…", "I think that…", note = "Subordinate clause — verb at end"),
                Phrase("Ich glaube, dass…", "I believe that…"),
                Phrase("Meiner Meinung nach…", "In my opinion…", note = "Dativ — 'meiner Meinung'"),
                Phrase("Ich bin der Meinung, dass…", "I am of the opinion that…"),
                Phrase("Ehrlich gesagt…", "To be honest…"),
                Phrase("Ich verstehe ihn besser.", "I understand him better.", note = "Akkusativ — 'ihn'"),
                Phrase("Ich verstehe mehr Wörter als früher.", "I understand more words than before."),
                Phrase(
                    german = "Das ist ja spannend!",
                    english = "That's really interesting/exciting!",
                    note = "⚠️ spannend ≠ entspannend",
                    expanded = listOf(
                        Phrase("spannend", "interesting / exciting / gripping", note = "Like a thriller — keeps you on edge"),
                        Phrase("entspannend", "relaxing / calming", note = "The opposite feeling — winding down"),
                        Phrase("Das Buch ist sehr spannend.", "The book is very gripping."),
                        Phrase("Ein Bad ist sehr entspannend.", "A bath is very relaxing."),
                    ),
                ),
            ),
        ),
        Section(
            title = "Agreeing",
            subtitle = "Zustimmung",
            phrases = listOf(
                Phrase(
                    german = "Ja, genau!",
                    english = "Yes, exactly!",
                    expanded = listOf(
                        Phrase("Stimmt!", "That's right!"),
                        Phrase("Das stimmt.", "That's correct."),
                        Phrase("Einverstanden!", "Agreed!"),
                        Phrase("Auf jeden Fall!", "Absolutely! / Definitely!"),
                        Phrase("Das finde ich auch.", "I think so too."),
                    ),
                ),
                Phrase("Da hast du recht.", "You're right about that.", note = "Informal 'du'"),
                Phrase("Da haben Sie recht.", "You're right about that.", note = "Formal 'Sie'"),
                Phrase("Ich bin ganz deiner Meinung.", "I completely agree with you.", note = "Informal"),
                Phrase("Das sehe ich genauso.", "I see it exactly the same way."),
            ),
        ),
        Section(
            title = "Disagreeing",
            subtitle = "Widerspruch",
            phrases = listOf(
                Phrase(
                    german = "Das sehe ich anders.",
                    english = "I see it differently.",
                    expanded = listOf(
                        Phrase("Da bin ich anderer Meinung.", "I'm of a different opinion on that."),
                        Phrase("Das stimmt nicht.", "That's not correct."),
                        Phrase("Ich bin nicht einverstanden.", "I don't agree."),
                        Phrase("Das glaube ich nicht.", "I don't believe that."),
                        Phrase("Nein, das finde ich nicht.", "No, I don't think so."),
                    ),
                ),
                Phrase("Da muss ich widersprechen.", "I have to disagree on that.", note = "Polite/formal"),
                Phrase("Ja, aber…", "Yes, but…", note = "Softening a disagreement"),
                Phrase("Das mag sein, aber…", "That may be, but…"),
            ),
        ),
        Section(
            title = "Expressing likes and dislikes",
            subtitle = "Mögen / Gefallen / Spaß",
            phrases = listOf(
                Phrase(
                    german = "Das gefällt mir.",
                    english = "I like that.",
                    note = "Dativ — 'mir'",
                    expanded = listOf(
                        Phrase("Das gefällt mir nicht.", "I don't like that."),
                        Phrase("Das gefällt mir sehr gut.", "I like that very much."),
                        Phrase("Ich mag das.", "I like that.", note = "'mögen' — more casual"),
                        Phrase("Ich mag das nicht.", "I don't like that."),
                        Phrase("Ich finde das toll.", "I think that's great."),
                        Phrase("Ich finde das schrecklich.", "I think that's terrible."),
                    ),
                ),
                Phrase(
                    german = "Das macht mir Spaß.",
                    english = "That's fun for me.",
                    note = "Dativ — 'mir'",
                    expanded = listOf(
                        Phrase("Das macht mir keinen Spaß.", "That's no fun for me."),
                        Phrase("Manchmal macht es Spaß.", "Sometimes it's fun."),
                        Phrase("Es ist nur Spaß.", "It's just a joke / just for fun."),
                    ),
                ),
                Phrase("Es ist sehr komisch.", "It's very funny/strange."),
            ),
        ),
        Section(
            title = "Expressing uncertainty",
            subtitle = "Unsicherheit",
            phrases = listOf(
                Phrase(
                    german = "Ich bin mir nicht sicher.",
                    english = "I'm not sure.",
                    expanded = listOf(
                        Phrase("Ich weiß nicht.", "I don't know."),
                        Phrase("Vielleicht.", "Maybe."),
                        Phrase("Es kommt darauf an.", "It depends."),
                        Phrase("Kann sein.", "Could be."),
                        Phrase("Das weiß ich leider nicht.", "Unfortunately, I don't know that."),
                    ),
                ),
            ),
        ),
        Section(
            title = "Alltag — Everyday situations",
            subtitle = "Useful phrases for daily life",
            phrases = listOf(
                Phrase(
                    german = "Heute habe ich das Kabelinternet eingerichtet.",
                    english = "Today I set up the cable internet.",
                    note = "einrichten — separable verb",
                    expanded = listOf(
                        Phrase("Vielleicht ist es kaputt.", "Maybe it's broken."),
                        Phrase("Deswegen habe ich den Anbieter angerufen.", "That's why I called the provider.", note = "anrufen — separable verb"),
                        Phrase("Ich habe die Mitarbeiterin vom Kundenservice gefragt.", "I asked the customer service employee."),
                        Phrase("Ich warte auf die Antwort des Chatbot.", "I'm waiting for the chatbot's reply.", note = "warten auf + Akk"),
                    ),
                ),
                Phrase("Einige Kolleginnen sprechen nicht Englisch.", "Some (female) colleagues don't speak English."),
                Phrase("Ich sehe jeden Tag die gleichen Mitarbeiter.", "I see the same colleagues every day."),
            ),
        ),
        Section(
            title = "Reaktionen — Reactions",
            subtitle = "Short responses in conversation",
            phrases = listOf(
                Phrase(
                    german = "Echt?",
                    english = "Really?",
                    note = "Surprise / disbelief",
                    expanded = listOf(
                        Phrase("Echt jetzt?", "For real?", note = "Stronger disbelief"),
                        Phrase("Im Ernst?", "Seriously?"),
                        Phrase("Wirklich?", "Really?", note = "Slightly more formal than 'Echt?'"),
                    ),
                ),
                Phrase("Ach so!", "Oh, I see!", note = "Understanding something new"),
                Phrase("Ach was!", "No way! / Oh come on!", note = "Surprise or dismissal"),
                Phrase("Na ja…", "Well…", note = "Hesitation or mild disagreement"),
                Phrase("Genau!", "Exactly!"),
                Phrase("Krass!", "Wow! / Crazy!", note = "Colloquial — strong reaction"),
                Phrase("Wahnsinn!", "Incredible! / Insane!", note = "Amazement"),
                Phrase("Schade!", "What a shame! / Too bad!"),
                Phrase("Toll!", "Great! / Awesome!"),
                Phrase("Wie bitte?", "Pardon? / Sorry, what?", note = "Didn't hear or can't believe it"),
                Phrase("Keine Ahnung.", "No idea."),
                Phrase("Na klar!", "Of course!"),
                Phrase("Egal.", "Whatever. / It doesn't matter."),
                Phrase("Gott sei Dank!", "Thank God!"),
                Phrase("Oh nein!", "Oh no!"),
                Phrase("Tja…", "Well… / Oh well…", note = "Resignation — nothing to be done"),
            ),
        ),
        Section(
            title = "Nützliche Füllwörter",
            subtitle = "Useful fillers — words that connect your thoughts",
            phrases = listOf(
                Phrase("Ehrlich gesagt…", "To be honest…"),
                Phrase("Sonst noch etwas?", "Anything else?", note = "Common in shops/restaurants"),
                Phrase("Sonstiges", "Miscellaneous", note = "Noun — used in forms, menus"),
                Phrase("…als früher / als sonst", "…than before / than usual", note = "Comparison with 'als'"),
                Phrase("Deswegen…", "That's why… / Therefore…"),
                Phrase("Manchmal…", "Sometimes…"),
            ),
        ),
        Section(
            title = "sich umziehen — Changing clothes",
            subtitle = "Reflexive separable verb",
            phrases = listOf(
                Phrase(
                    german = "Ich muss mich umziehen.",
                    english = "I have to change (clothes).",
                    note = "sich umziehen — reflexive + separable",
                    expanded = listOf(
                        Phrase("die Umkleide", "the changing room", note = "Short form"),
                        Phrase("der Umkleideraum", "the changing room", note = "Full form"),
                        Phrase("die Umkleidung", "the act of changing / changing area"),
                    ),
                ),
            ),
        ),
    )
}
