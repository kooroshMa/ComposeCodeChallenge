package com.example.composecodechallenge.main.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import com.example.composecodechallenge.main.navigation.ItollNavHost

@Composable
fun ItollApp(
    windowSizeClass: WindowSizeClass,
    appState: ItollAppState = rememberItollAppState(
        windowSizeClass = windowSizeClass
    ),
) {
    ItollNavHost(
        navController = appState.navController,
        onBackClick = appState::onBackClick
    )
}