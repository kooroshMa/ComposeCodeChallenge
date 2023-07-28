package com.example.composecodechallenge.features.feature_userlist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composecodechallenge.features.feature_userdetail.navigation.USER_NAME_ARG_SUFFIX
import com.example.composecodechallenge.features.feature_userdetail.navigation.navigateToUserDetails
import com.example.composecodechallenge.features.feature_userlist.ui.UserListRoute

internal const val USER_ROUTE_PREFIX = "user"
internal const val USER_LIST_ROUTE = "${USER_ROUTE_PREFIX}_list_route$USER_NAME_ARG_SUFFIX"

fun NavGraphBuilder.userListScreen(navController: NavController) {
    composable(route = USER_LIST_ROUTE) {
        UserListRoute(navigateToUserDetails = navController::navigateToUserDetails)
    }
}