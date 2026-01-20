package com.watson.kelvin.dubistjetztdeutscher.ui.component.bottombar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.AppNavKey
import com.watson.kelvin.dubistjetztdeutscher.ui.nav.keys.bottom.BottomBarNavKeys.bottomBarKeys
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource

@Composable
fun BottomBar(
    currentTopLevel: AppNavKey,
    onClick: (AppNavKey) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBar(modifier = modifier) {
        bottomBarKeys.forEach { bottomBarRoute ->
            val isSelected = bottomBarRoute == currentTopLevel
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    onClick(bottomBarRoute)
                },
                icon = {
                    Icon(
                        imageVector = bottomBarRoute.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(bottomBarRoute.labelResource))
                },
                alwaysShowLabel = true
            )
        }
    }
}