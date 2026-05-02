package com.watson.kelvin.dubistjetztdeutscher.ui.component.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A reusable swipeable carousel that displays [AnnotatedString] items with rotating
 * text and background colors, page indicator dots, and a "See more…" bottom sheet
 * for truncated content.
 *
 * @param items Compact items displayed in the carousel cards.
 * @param expandedItems Expanded versions shown in the bottom sheet (same indices as [items]).
 * @param pagerState The [PagerState] controlling the current page.
 * @param textColors Colors that rotate across items for text.
 * @param backgroundColors Colors that rotate across items for card backgrounds.
 * @param cardHeight Fixed height for each carousel card.
 * @param maxLines Maximum visible lines before truncation.
 * @param sheetTitle Title displayed at the top of the bottom sheet.
 * @param modifier Modifier for the root layout.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipsCarousel(
    items: List<AnnotatedString>,
    expandedItems: List<AnnotatedString>,
    pagerState: PagerState,
    textColors: List<Color>,
    backgroundColors: List<Color>,
    modifier: Modifier = Modifier,
    cardHeight: Dp = 160.dp,
    maxLines: Int = 5,
    sheetTitle: String = "Tip of the Day",
) {
    var expandedItemIndex: Int? by remember { mutableStateOf(null) }
    val sheetState = rememberModalBottomSheetState()

    Column(modifier = modifier) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
        ) { page ->
            val textColor: Color = textColors[page % textColors.size]
            val backgroundColor: Color = backgroundColors[page % backgroundColors.size]
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .background(
                        color = backgroundColor,
                        shape = RoundedCornerShape(12.dp),
                    )
                    .fillMaxWidth()
                    .height(cardHeight)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                var hasOverflow: Boolean by remember { mutableStateOf(false) }
                Text(
                    text = items[page],
                    style = MaterialTheme.typography.bodyMedium,
                    color = textColor,
                    maxLines = maxLines,
                    overflow = TextOverflow.Ellipsis,
                    onTextLayout = { result ->
                        hasOverflow = result.hasVisualOverflow
                    },
                )
                if (hasOverflow) {
                    Text(
                        text = "See more…",
                        style = MaterialTheme.typography.labelSmall,
                        color = textColor.copy(alpha = 0.7f),
                        modifier = Modifier
                            .clickable { expandedItemIndex = page }
                            .padding(top = 4.dp),
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Page indicator dots
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            repeat(items.size) { index ->
                val isSelected: Boolean = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(if (isSelected) 8.dp else 6.dp)
                        .clip(CircleShape)
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                        ),
                )
            }
        }
    }

    // Bottom sheet for expanded content
    if (expandedItemIndex != null) {
        val itemIndex: Int = expandedItemIndex!!
        ModalBottomSheet(
            onDismissRequest = { expandedItemIndex = null },
            sheetState = sheetState,
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 32.dp),
            ) {
                Text(
                    text = sheetTitle,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = expandedItems[itemIndex],
                    style = MaterialTheme.typography.bodyLarge,
                    color = textColors[itemIndex % textColors.size],
                    lineHeight = 28.sp,
                )
            }
        }
    }
}

