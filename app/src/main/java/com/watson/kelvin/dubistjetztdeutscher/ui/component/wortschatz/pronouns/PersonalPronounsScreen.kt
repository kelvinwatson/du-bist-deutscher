package com.watson.kelvin.dubistjetztdeutscher.ui.component.wortschatz.pronouns

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.watson.kelvin.dubistjetztdeutscher.R
import com.watson.kelvin.dubistjetztdeutscher.core.theme.Theme
import javax.annotation.processing.Generated

/**
 * Screen displaying personal pronouns in a table format with all cases.
 * Fixed left column shows case labels, horizontally scrollable columns for persons.
 */
@Composable
internal fun PersonalPronounsScreen(
    modifier: Modifier = Modifier,
    viewModel: PersonalPronounsViewModel = viewModel(),
) {
    val scrollState = rememberScrollState()

    val caseLabels = listOf(
        stringResource(R.string.no_translate_case_nominative),
        stringResource(R.string.no_translate_tab_accusative),
        stringResource(R.string.no_translate_tab_dative),
    )
    val caseColors = listOf(
        Theme.possessiveArticleColors.masculine,
        Theme.possessiveArticleColors.neuter,
        Theme.possessiveArticleColors.feminine,
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = Theme.dimens.screenPadding,
                top = Theme.dimens.screenPadding,
                bottom = Theme.dimens.screenPadding,
            ),
    ) {
        // Header row with sticky "Case" column
        Row {
            // Sticky header cell
            Box(
                modifier = Modifier
                    .width(90.dp)
                    .height(50.dp)
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
                viewModel.matrixData.forEach { pronoun ->
                    Box(
                        modifier = Modifier
                            .width(110.dp)
                            .height(50.dp)
                            .background(Theme.grammarColors.tableHeader),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = pronoun.person,
                            fontWeight = FontWeight.Bold,
                            fontSize = 8.sp,
                            color = MaterialTheme.colorScheme.onSecondary,
                        )
                    }
                }
            }
        }

        // Data rows grouped by case with sticky first column
        caseLabels.forEachIndexed { caseIndex, caseLabel ->
            Row {
                // Sticky case label cell
                Box(
                    modifier = Modifier
                        .width(90.dp)
                        .height(50.dp)
                        .background(
                            viewModel.getCaseColor(
                                caseIndex,
                                caseColors,
                                Theme.possessiveArticleColors.masculine,
                            )
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = caseLabel,
                        fontWeight = FontWeight.Bold,
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSecondary,
                    )
                }

                // Scrollable pronoun data cells (uses same scrollState as header)
                Row(
                    modifier = Modifier.horizontalScroll(scrollState),
                ) {
                    viewModel.matrixData.forEach { pronoun ->
                        Box(
                            modifier = Modifier
                                .width(110.dp)
                                .height(50.dp)
                                .background(
                                    viewModel.getCaseColor(
                                        caseIndex,
                                        caseColors,
                                        Theme.possessiveArticleColors.masculine,
                                    )
                                ),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = viewModel.getCaseValue(pronoun, caseIndex),
                                fontSize = 12.sp,
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
internal fun PersonalPronounsScreenPreview() {
    Theme {
        PersonalPronounsScreen()
    }
}

