package com.watson.kelvin.dubistjetztdeutscher.ui.component.grammar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.ui.component.common.FeatureGridItem
import com.watson.kelvin.dubistjetztdeutscher.ui.component.common.FeatureGridScreen
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Grammar
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.Vocabulary
import com.watson.kelvin.dubistjetztdeutscher.ui.resource.StringResource

@OptIn(ExperimentalMaterial3Api::class) // TopAppBar
@Composable
fun GrammarScreen(
    onClick: (goTo: AppNavKey) -> Unit,
    modifier: Modifier = Modifier,
) {
    FeatureGridScreen(
        items = listOf(
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_adjective_endings),
                translation = stringResource(StringResource.no_translate_en_title_adjective_endings),
                color = Theme.caseColors.nominativ,
                navKey = Grammar.AdjectiveEndings,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_connectors),
                translation = stringResource(StringResource.no_translate_en_title_connectors),
                color = Theme.connectorColors.coordinating,
                navKey = Vocabulary.Connectors,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_prepositions),
                translation = stringResource(StringResource.prepositions),
                color = Theme.prepositionColors.akkusativ,
                navKey = Vocabulary.Prepositions,
            ),
            FeatureGridItem(
                label = stringResource(StringResource.no_translate_title_adverbs),
                translation = stringResource(StringResource.adverbs),
                color = Theme.grammarColors.adverbs,
                navKey = Grammar.AdjectiveEndings, // TODO: Replace with correct navKey for adverbs
            ),
        ),
        modifier = modifier,
        onClick = onClick,
    )
}
