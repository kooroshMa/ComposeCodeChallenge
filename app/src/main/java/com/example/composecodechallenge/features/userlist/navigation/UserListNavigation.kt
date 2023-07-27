package com.example.composecodechallenge.features.userlist.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composecodechallenge.features.userlist.ui.UserListRoute

internal const val USER_ROUTE_PREFIX = "user"
internal const val USER_LIST_ROUTE = "${USER_ROUTE_PREFIX}_list_route"

fun NavGraphBuilder.userListScreen() {
    composable(route = USER_LIST_ROUTE) {
        UserListRoute()
    }
}