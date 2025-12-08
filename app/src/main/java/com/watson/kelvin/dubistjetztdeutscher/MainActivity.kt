package com.watson.kelvin.dubistjetztdeutscher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.watson.kelvin.dubistjetztdeutscher.core.theme.AppTheme
import com.watson.kelvin.dubistjetztdeutscher.ui.component.app.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                App()
            }
        }
    }
}