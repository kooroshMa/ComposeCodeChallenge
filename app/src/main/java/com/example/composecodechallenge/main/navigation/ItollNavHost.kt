package com.example.composecodechallenge.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composecodechallenge.features.feature_userdetail.navigation.userDetailGraph
import com.example.composecodechallenge.features.feature_userlist.navigation.USER_LIST_ROUTE
import com.example.composecodechallenge.features.feature_userlist.navigation.userListScreen

/**
 * Top-level navigation graph. Navigation is organized as explained at
 * https://d.android.com/jetpack/compose/nav-adaptive
 *
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ItollNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = USER_LIST_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.semantics {
            testTagsAsResourceId = true
        }.then(modifier)
    ) {
        userListScreen(navController)
        userDetailGraph(navController)
    }
}