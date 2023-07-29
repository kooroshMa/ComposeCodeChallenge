package com.example.composecodechallenge.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.composecodechallenge.main.ui.theme.ItollTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItollTheme {
                @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
                ItollApp(
                    windowSizeClass = calculateWindowSizeClass(
                        this
                    )
                )
            }
        }
    }
}