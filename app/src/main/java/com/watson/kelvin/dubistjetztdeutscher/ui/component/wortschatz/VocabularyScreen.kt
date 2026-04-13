package com.watson.kelvin.dubistjetztdeutscher.ui.component.wortschatz

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.ui.component.common.FeatureGridItem
import com.watson.kelvin.dubistjetztdeutscher.ui.component.common.FeatureGridScreen
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Vocabulary
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.StringResource

/**
 * Main screen for the Vocabulary tab. Displays vocabulary features in a grid.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VocabularyScreen(
    modifier: Modifier = Modifier,
    onClick: (goTo: AppNavKey) -> Unit = {},
) {
    FeatureGridScreen(
        items = listOf(
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_adjectives),
                translation = stringResource(StringResource.no_translate_en_title_adjectives),
                color = Theme.vocabularyCategoryColors.adjectives,
                navKey = Vocabulary.Adjectives(),
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_connectors),
                translation = stringResource(StringResource.no_translate_en_title_connectors),
                color = Theme.vocabularyCategoryColors.connectors,
                navKey = Vocabulary.Connectors,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_possessive_articles),
                translation = stringResource(StringResource.no_translate_en_title_possessive_articles),
                color = Theme.vocabularyCategoryColors.possessiveArticles,
                navKey = Vocabulary.PossessiveArticles,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_prepositions),
                translation = stringResource(StringResource.no_translate_en_title_prepositions),
                color = Theme.vocabularyCategoryColors.prepositions,
                navKey = Vocabulary.Prepositions,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_pronouns),
                translation = stringResource(StringResource.no_translate_en_title_pronouns),
                color = Theme.vocabularyCategoryColors.pronouns,
                navKey = Vocabulary.Pronouns,
            ),
        ).sortedBy { it.label },
        modifier = modifier,
        onClick = onClick,
    )
}
