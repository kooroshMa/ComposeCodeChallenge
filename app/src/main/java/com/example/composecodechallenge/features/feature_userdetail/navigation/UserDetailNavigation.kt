package com.example.composecodechallenge.features.feature_userdetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composecodechallenge.features.feature_userdetail.ui.UserListRoute
import com.example.composecodechallenge.features.feature_userlist.navigation.USER_ROUTE_PREFIX

private const val USER_DETAILS_ROUTE = "$USER_ROUTE_PREFIX/detail"
const val USER_NAME = "userName"
const val USER_NAME_ARG_SUFFIX = "/{$USER_NAME}"
const val DEFAULT_VALUE = "Koorosh"

internal fun NavController.navigateToUserDetails(
    searchQuery: String,
    navOptions: NavOptions? = null
) {
    navigate(route = "$USER_DETAILS_ROUTE/$searchQuery", navOptions = navOptions)
}

fun NavGraphBuilder.userDetailsScreen(
    navController: NavController,
) {
    composable(route = USER_DETAILS_ROUTE + USER_NAME_ARG_SUFFIX,
        arguments = listOf(navArgument(USER_NAME) {
            type = NavType.StringType
            defaultValue = DEFAULT_VALUE
        })
    ) {
        UserListRoute(
            onBackClick = navController::popBackStack,
        )
    }
}