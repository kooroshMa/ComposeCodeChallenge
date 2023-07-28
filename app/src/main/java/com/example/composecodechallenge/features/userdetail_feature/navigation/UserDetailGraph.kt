package com.example.composecodechallenge.features.userdetail_feature.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.composecodechallenge.features.userlist_feature.navigation.USER_ROUTE_PREFIX

const val USER_GRAPH_ROUTE_PATTERN = "user_graph"

fun NavGraphBuilder.userDetailGraph(
    navController: NavHostController
) {
    navigation(
        route = USER_GRAPH_ROUTE_PATTERN,
        startDestination = USER_ROUTE_PREFIX,
    ) {
        userDetailsScreen(navController)
    }
}