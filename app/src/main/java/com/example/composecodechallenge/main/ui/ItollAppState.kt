package com.example.composecodechallenge.main.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberItollAppState(
    windowSizeClass: WindowSizeClass,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): ItollAppState {
    return remember(navController, coroutineScope, windowSizeClass) {
        ItollAppState(navController)
    }
}

@Stable
class ItollAppState(val navController: NavHostController) {

    fun onBackClick() {
        navController.navigateUp()
    }
}