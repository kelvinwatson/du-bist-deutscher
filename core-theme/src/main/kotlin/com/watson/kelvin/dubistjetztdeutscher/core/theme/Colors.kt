@file:Suppress("ObjectPropertyName", "ConstPropertyName")

package com.watson.kelvin.dubistjetztdeutscher.core.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow

val LocalColors = staticCompositionLocalOf<Colors> {
    error("No AppColors provided")
}

/**
 * Core color constants used throughout the app.
 * All HEX color values are defined here.
 * These should not be consumed directly - always use semantically named colors.
 */
object CoreColorResources {
    const val aqua: Int = 0xFF00FFFF.toInt()
    const val blue300: Int = 0xFF64B5F6.toInt()
    const val blue600: Int = 0xFF1565C0.toInt()
    const val blue700: Int = 0xFF1976D2.toInt()
    const val cyan300: Int = 0xFF4DD0E1.toInt()
    const val darkGray: Int = 0xFF1A1A1A.toInt()
    const val deepOrange300: Int = 0xFFFF8A65.toInt()
    const val deepPurple300: Int = 0xFF9575CD.toInt()
    const val green300: Int = 0xFF81C784.toInt()
    const val green700: Int = 0xFF388E3C.toInt()
    const val green800: Int = 0xFF81C784.toInt()
    const val greenBright: Int = 0xFF00FF04.toInt()
    const val indigo300: Int = 0xFF7986CB.toInt()
    const val lime300: Int = 0xFFDCE775.toInt()
    const val orange: Int = 0xFFFFA800.toInt()
    const val orange300: Int = 0xFFFFB74D.toInt()
    const val orange900: Int = 0xFFE65100.toInt()
    const val pink: Int = 0xFFFF5CE9.toInt()
    const val pink300: Int = 0xFFF06292.toInt()
    const val pink700: Int = 0xFFC2185B.toInt()
    const val purple: Int = 0xFFb65Cff.toInt()
    const val purple300: Int = 0xFFB39DDB.toInt()
    const val red300: Int = 0xFFE57373.toInt()
    const val red700: Int = 0xFFD32F2F.toInt()
    const val teal300: Int = 0xFF4DB6AC.toInt()
    const val yellow300: Int = 0xFFFFF176.toInt()
}

enum class PrepositionColorKey {
    Akkusativ, Dativ, Wechsel, Genitive, ;

    companion object {
        /**
         * Extension function for PrepositionColorKey to get the color from AppPrepositionColors
         */
        fun PrepositionColorKey.toColor(colors: PrepositionColors): Color = when (this) {
            Akkusativ -> colors.akkusativ
            Dativ -> colors.dativ
            Wechsel -> colors.wechsel
            Genitive -> colors.genitive
        }
    }
}


object CaseColorResources {
    const val Akkusativ: Int = CoreColorResources.pink
    const val Dativ: Int = CoreColorResources.greenBright
    const val Genitive: Int = CoreColorResources.purple
    const val Nominativ: Int = CoreColorResources.aqua
}

object ConnectorColorResources {
    const val Adverbial: Int = CoreColorResources.green700
    const val Coordinating: Int = CoreColorResources.blue700
    const val Subordinating: Int = CoreColorResources.red700
}

object PossessiveArticleColorResources {
    const val Feminine: Int = CoreColorResources.pink700
    const val Masculine: Int = CoreColorResources.blue600
    const val Neuter: Int = CoreColorResources.green700
    const val Plural: Int = CoreColorResources.orange900
}

object PrepositionColorResources {
    const val Akkusativ: Int = CoreColorResources.pink
    const val Dativ: Int = CoreColorResources.greenBright
    const val Genitive: Int = CoreColorResources.purple
    const val Wechsel: Int = CoreColorResources.orange
}

object AdjectiveCategoryColorResources {
    const val Age: Int = CoreColorResources.blue300
    const val Color: Int = CoreColorResources.pink300
    const val Difficulty: Int = CoreColorResources.orange300
    const val Emotion: Int = CoreColorResources.yellow300
    const val Material: Int = CoreColorResources.teal300
    const val Opinion: Int = CoreColorResources.purple300
    const val Personality: Int = CoreColorResources.indigo300
    const val Position: Int = CoreColorResources.cyan300
    const val Quality: Int = CoreColorResources.green300
    const val QuantityCountable: Int = CoreColorResources.lime300
    const val QuantityNonCountable: Int = CoreColorResources.deepOrange300
    const val Shape: Int = CoreColorResources.deepPurple300
    const val Size: Int = CoreColorResources.red300
    const val State: Int = CoreColorResources.green800
    const val Taste: Int = CoreColorResources.pink300
    const val Temperature: Int = CoreColorResources.blue300
}

object AdjectiveEndingColorResources {
    const val Nominativ: Int = CoreColorResources.blue700
    const val Akkusativ: Int = CoreColorResources.pink700
    const val Dativ: Int = CoreColorResources.green700
}

object GrammarColorResources {
    const val Adverbs: Int = CoreColorResources.purple300
    const val TableHeader: Int = CoreColorResources.darkGray
}

object GrammarCategoryColorResources {
    const val Prepositions: Int = CoreColorResources.pink300
    const val Connectors: Int = CoreColorResources.blue700
    const val Adjectives: Int = CoreColorResources.green300
    const val Pronouns: Int = CoreColorResources.purple300
    const val PossessiveArticles: Int = CoreColorResources.orange900
    // Add more as needed
}

class PrepositionColors(
    val akkusativ: Color,
    val dativ: Color,
    val genitive: Color,
    val wechsel: Color,
)

class CaseColors(
    val akkusativ: Color,
    val dativ: Color,
    val genitive: Color,
    val nominativ: Color,
)

class ConnectorColors(
    val adverbial: Color,
    val coordinating: Color,
    val subordinating: Color,
)

class CoreColors(
    val aqua: Color,
    val blue300: Color,
    val blue600: Color,
    val blue700: Color,
    val cyan300: Color,
    val darkGray: Color,
    val deepOrange300: Color,
    val deepPurple300: Color,
    val green300: Color,
    val green700: Color,
    val green800: Color,
    val greenBright: Color,
    val indigo300: Color,
    val lime300: Color,
    val orange: Color,
    val orange300: Color,
    val orange900: Color,
    val pink: Color,
    val pink300: Color,
    val pink700: Color,
    val purple: Color,
    val purple300: Color,
    val red300: Color,
    val red700: Color,
    val teal300: Color,
    val yellow300: Color,
)

class PossessiveArticleColors(
    val feminine: Color,
    val masculine: Color,
    val neuter: Color,
    val plural: Color,
)

class AdjectiveCategoryColors(
    val age: Color,
    val color: Color,
    val difficulty: Color,
    val emotion: Color,
    val material: Color,
    val opinion: Color,
    val personality: Color,
    val position: Color,
    val quality: Color,
    val quantityCountable: Color,
    val quantityNonCountable: Color,
    val shape: Color,
    val size: Color,
    val state: Color,
    val taste: Color,
    val temperature: Color,
)

data class AdjectiveEndingColors(
    val nominativ: Color,
    val akkusativ: Color,
    val dativ: Color,
)

class GrammarColors(
    val adverbs: Color,
    val tableHeader: Color,
)

class GrammarCategoryColors(
    val prepositions: Color,
    val connectors: Color,
    val adjectives: Color,
    val pronouns: Color,
    val possessiveArticles: Color,
)

internal val appMaterialBasedColorScheme = darkColorScheme(
    primary = Black,
    secondary = Gray,
    onPrimary = Yellow,
    onSecondary = White,
)

object Colors {
    val prepositionColors = PrepositionColors(
        akkusativ = Color(PrepositionColorResources.Akkusativ),
        dativ = Color(PrepositionColorResources.Dativ),
        genitive = Color(PrepositionColorResources.Genitive),
        wechsel = Color(PrepositionColorResources.Wechsel),
    )
    val caseColors = CaseColors(
        akkusativ = Color(CaseColorResources.Akkusativ),
        dativ = Color(CaseColorResources.Dativ),
        genitive = Color(CaseColorResources.Genitive),
        nominativ = Color(CaseColorResources.Nominativ),
    )
    val connectorColors = ConnectorColors(
        adverbial = Color(ConnectorColorResources.Adverbial),
        coordinating = Color(ConnectorColorResources.Coordinating),
        subordinating = Color(ConnectorColorResources.Subordinating),
    )
    val coreColors = CoreColors(
        aqua = Color(CoreColorResources.aqua),
        blue300 = Color(CoreColorResources.blue300),
        blue600 = Color(CoreColorResources.blue600),
        blue700 = Color(CoreColorResources.blue700),
        cyan300 = Color(CoreColorResources.cyan300),
        darkGray = Color(CoreColorResources.darkGray),
        deepOrange300 = Color(CoreColorResources.deepOrange300),
        deepPurple300 = Color(CoreColorResources.deepPurple300),
        green300 = Color(CoreColorResources.green300),
        green700 = Color(CoreColorResources.green700),
        green800 = Color(CoreColorResources.green800),
        greenBright = Color(CoreColorResources.greenBright),
        indigo300 = Color(CoreColorResources.indigo300),
        lime300 = Color(CoreColorResources.lime300),
        orange = Color(CoreColorResources.orange),
        orange300 = Color(CoreColorResources.orange300),
        orange900 = Color(CoreColorResources.orange900),
        pink = Color(CoreColorResources.pink),
        pink300 = Color(CoreColorResources.pink300),
        pink700 = Color(CoreColorResources.pink700),
        purple = Color(CoreColorResources.purple),
        purple300 = Color(CoreColorResources.purple300),
        red300 = Color(CoreColorResources.red300),
        red700 = Color(CoreColorResources.red700),
        teal300 = Color(CoreColorResources.teal300),
        yellow300 = Color(CoreColorResources.yellow300),
    )
    val possessiveArticleColors = PossessiveArticleColors(
        masculine = Color(PossessiveArticleColorResources.Masculine),
        neuter = Color(PossessiveArticleColorResources.Neuter),
        feminine = Color(PossessiveArticleColorResources.Feminine),
        plural = Color(PossessiveArticleColorResources.Plural),
    )
    val adjectiveCategoryColors = AdjectiveCategoryColors(
        age = Color(AdjectiveCategoryColorResources.Age),
        color = Color(AdjectiveCategoryColorResources.Color),
        difficulty = Color(AdjectiveCategoryColorResources.Difficulty),
        emotion = Color(AdjectiveCategoryColorResources.Emotion),
        material = Color(AdjectiveCategoryColorResources.Material),
        opinion = Color(AdjectiveCategoryColorResources.Opinion),
        personality = Color(AdjectiveCategoryColorResources.Personality),
        position = Color(AdjectiveCategoryColorResources.Position),
        quality = Color(AdjectiveCategoryColorResources.Quality),
        quantityCountable = Color(AdjectiveCategoryColorResources.QuantityCountable),
        quantityNonCountable = Color(AdjectiveCategoryColorResources.QuantityNonCountable),
        shape = Color(AdjectiveCategoryColorResources.Shape),
        size = Color(AdjectiveCategoryColorResources.Size),
        state = Color(AdjectiveCategoryColorResources.State),
        taste = Color(AdjectiveCategoryColorResources.Taste),
        temperature = Color(AdjectiveCategoryColorResources.Temperature),
    )
    val adjectiveEndingColors = AdjectiveEndingColors(
        nominativ = Color(AdjectiveEndingColorResources.Nominativ),
        akkusativ = Color(AdjectiveEndingColorResources.Akkusativ),
        dativ = Color(AdjectiveEndingColorResources.Dativ),
    )
    val grammarColors = GrammarColors(
        adverbs = Color(GrammarColorResources.Adverbs),
        tableHeader = Color(GrammarColorResources.TableHeader),
    )
    val grammarCategoryColors = GrammarCategoryColors(
        prepositions = Color(GrammarCategoryColorResources.Prepositions),
        connectors = Color(GrammarCategoryColorResources.Connectors),
        adjectives = Color(GrammarCategoryColorResources.Adjectives),
        pronouns = Color(GrammarCategoryColorResources.Pronouns),
        possessiveArticles = Color(GrammarCategoryColorResources.PossessiveArticles),
    )
    val vocabularyCategoryColors = VocabularyCategoryColors(
        adjectives = Color(VocabularyCategoryColorResources.Adjectives),
        connectors = Color(VocabularyCategoryColorResources.Connectors),
        possessiveArticles = Color(VocabularyCategoryColorResources.PossessiveArticles),
        pronouns = Color(VocabularyCategoryColorResources.Pronouns),
    )
}

object VocabularyCategoryColorResources {
    const val Adjectives: Int = CoreColorResources.green300
    const val Connectors: Int = CoreColorResources.blue700
    const val PossessiveArticles: Int = CoreColorResources.orange900
    const val Pronouns: Int = CoreColorResources.purple300
}

class VocabularyCategoryColors(
    val adjectives: Color,
    val connectors: Color,
    val possessiveArticles: Color,
    val pronouns: Color,
)
