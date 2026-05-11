package com.watson.kelvin.dubistjetztdeutscher.ui.component.lernen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.ui.component.common.FeatureGridItem
import com.watson.kelvin.dubistjetztdeutscher.ui.component.common.FeatureGridScreen
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Lernen
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.StringResource

/**
 * Unified screen for the Lernen (Learn) tab.
 * Combines all grammar and vocabulary features in a single grid.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LernenScreen(
    onClick: (goTo: AppNavKey) -> Unit,
    modifier: Modifier = Modifier,
) {
    FeatureGridScreen(
        items = listOf(
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_adjectives),
                translation = stringResource(StringResource.no_translate_en_title_adjectives),
                color = Theme.vocabularyCategoryColors.adjectives,
                navKey = Lernen.Adjectives(),
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_adjective_endings),
                translation = stringResource(StringResource.no_translate_en_title_adjective_endings),
                color = Theme.caseColors.nominativ,
                navKey = Lernen.AdjectiveEndings,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_connectors),
                translation = stringResource(StringResource.no_translate_en_title_connectors),
                color = Theme.vocabularyCategoryColors.connectors,
                navKey = Lernen.Connectors,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_passive),
                translation = stringResource(StringResource.no_translate_en_title_passive),
                color = Theme.grammarColors.adverbs,
                navKey = Lernen.Passive,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_possessive_articles),
                translation = stringResource(StringResource.no_translate_en_title_possessive_articles),
                color = Theme.vocabularyCategoryColors.possessiveArticles,
                navKey = Lernen.PossessiveArticles,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_prepositions),
                translation = stringResource(StringResource.no_translate_en_title_prepositions),
                color = Theme.vocabularyCategoryColors.prepositions,
                navKey = Lernen.Prepositions,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_pronouns),
                translation = stringResource(StringResource.no_translate_en_title_pronouns),
                color = Theme.vocabularyCategoryColors.pronouns,
                navKey = Lernen.Pronouns,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_expressions),
                translation = stringResource(StringResource.no_translate_en_title_expressions),
                color = Theme.connectorColors.subordinating,
                navKey = Lernen.Expressions,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_adverbs),
                translation = stringResource(StringResource.adverbs),
                color = Theme.grammarColors.adverbs,
                navKey = Lernen.AdjectiveEndings, // TODO: Replace with correct navKey for adverbs
            ),
        ).sortedBy { it.label },
        modifier = modifier,
        onClick = onClick,
    )
}

