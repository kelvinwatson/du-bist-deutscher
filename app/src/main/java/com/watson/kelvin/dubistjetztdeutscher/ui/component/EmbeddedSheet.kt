package com.watson.kelvin.dubistjetztdeutscher.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.embedded.EmbeddedModeNavKey

/**
 * Generic sheet component.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmbeddedSheet(
    key: EmbeddedModeNavKey,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Surface(modifier = modifier, content = content)
}