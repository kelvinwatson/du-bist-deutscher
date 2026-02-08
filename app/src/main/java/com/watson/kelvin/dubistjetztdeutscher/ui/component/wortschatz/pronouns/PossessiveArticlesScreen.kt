package com.watson.kelvin.dubistjetztdeutscher.ui.component.wortschatz.pronouns

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.watson.kelvin.dubistjetztdeutscher.R
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz.PronounsFallbackData
import javax.annotation.processing.Generated

/**
 * Screen displaying possessive articles in a table format.
 * Shows all genders and plural forms for each person with all cases combined.
 * Fixed left column shows gender labels, horizontally scrollable columns for person values.
 */
@Composable
internal fun PossessiveArticlesScreen(
    modifier: Modifier = Modifier,
) {
    val data = PronounsFallbackData.possessiveMatrix
    val genderLabels = listOf(
        stringResource(R.string.no_translate_gender_masculine),
        stringResource(R.string.no_translate_gender_neuter),
        stringResource(R.string.no_translate_gender_feminine),
        stringResource(R.string.no_translate_gender_plural),
    )
    val genderColors = listOf(
        Theme.possessiveArticleColors.masculine,
        Theme.possessiveArticleColors.neuter,
        Theme.possessiveArticleColors.feminine,
        Theme.possessiveArticleColors.plural,
    )

    val scrollState = rememberScrollState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(Theme.dimens.screenPadding),
    ) {
        item {
            Text(
                text = stringResource(R.string.no_translate_title_possessive_articles),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = Theme.dimens.sectionSpacing),
            )
        }

        item {
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .horizontalScroll(scrollState),
            ) {
                Box(
                    modifier = Modifier
                        .width(Theme.dimens.pronounHeaderWidth)
                        .height(Theme.dimens.pronounRowHeight)
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = stringResource(R.string.no_translate_header_person),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                    )
                }
                data.forEach { possessive ->
                    Box(
                        modifier = Modifier
                            .width(Theme.dimens.pronounPossessiveWidth)
                            .height(Theme.dimens.pronounRowHeight)
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = possessive.person,
                            fontWeight = FontWeight.Bold,
                            fontSize = 9.sp,
                        )
                    }
                }
            }
        }

        itemsIndexed(genderLabels) { genderIndex, genderLabel ->
            Row(
                modifier = Modifier.horizontalScroll(scrollState),
            ) {
                Box(
                    modifier = Modifier
                        .width(Theme.dimens.pronounHeaderWidth)
                        .height(Theme.dimens.pronounRowHeight)
                        .background(genderColors[genderIndex]),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = genderLabel,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }

                data.forEach { possessive ->
                    val genderValue = when (genderIndex) {
                        0 -> possessive.masculine
                        1 -> possessive.neuter
                        2 -> possessive.feminine
                        else -> possessive.plural
                    }

                    Box(
                        modifier = Modifier
                            .width(Theme.dimens.pronounPossessiveWidth)
                            .height(Theme.dimens.pronounRowHeight)
                            .background(genderColors[genderIndex]),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = genderValue,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                }
            }
        }
    }
}

@[Preview Generated Composable]
internal fun PossessiveArticlesScreenPreview2() {
    Theme {
        PossessiveArticlesScreen()
    }
}