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
import com.watson.kelvin.dubistjetztdeutscher.data.nonetworkfallbacks.wortschatz.Gender
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
    val scrollState = rememberScrollState()

    val data = PronounsFallbackData.possessiveMatrix
    val genders = Gender.entries
    val genderColors = listOf(
        Theme.possessiveArticleColors.masculine,
        Theme.possessiveArticleColors.neuter,
        Theme.possessiveArticleColors.feminine,
        Theme.possessiveArticleColors.plural,
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = Theme.dimens.screenPadding,
                top = Theme.dimens.screenPadding,
                bottom = Theme.dimens.screenPadding,
            ),
    ) {
        // Header row with sticky Person column
        item {
            Row {
                // Sticky header cell
                Box(
                    modifier = Modifier
                        .width(Theme.dimens.pronounHeaderWidth)
                        .height(Theme.dimens.pronounRowHeight)
                        .background(Theme.grammarColors.tableHeader),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = stringResource(R.string.no_translate_header_person),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSecondary,
                    )
                }

                // Scrollable person labels
                Row(
                    modifier = Modifier.horizontalScroll(scrollState),
                ) {
                    data.forEach { possessive ->
                        Box(
                            modifier = Modifier
                                .width(Theme.dimens.pronounPossessiveWidth)
                                .height(Theme.dimens.pronounRowHeight)
                                .background(Theme.grammarColors.tableHeader),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = possessive.person,
                                fontWeight = FontWeight.Bold,
                                fontSize = 9.sp,
                                color = MaterialTheme.colorScheme.onSecondary,
                            )
                        }
                    }
                }
            }
        }

        // Data rows grouped by gender with sticky first column
        itemsIndexed(genders) { genderIndex, gender ->
            Row {
                // Sticky gender label cell
                Box(
                    modifier = Modifier
                        .width(Theme.dimens.pronounHeaderWidth)
                        .height(Theme.dimens.pronounRowHeight)
                        .background(genderColors[genderIndex]),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = stringResource(gender.abbreviationResId),
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSecondary,
                    )
                }

                // Scrollable gender data cells (uses same scrollState as header)
                Row(
                    modifier = Modifier.horizontalScroll(scrollState),
                ) {
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
                            )
                        }
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