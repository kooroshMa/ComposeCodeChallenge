package com.example.composecodechallenge.features.feature_userlist.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composecodechallenge.features.feature_userlist.viewmodel.UserListViewModel

@Composable
internal fun UserListRoute(
    viewModel: UserListViewModel = hiltViewModel(),
    navigateToUserDetails: (String) -> Unit,
) {
    val searchQueryTextState = viewModel.searchQueryText.collectAsStateWithLifecycle()
    val users = viewModel.usersState.collectAsStateWithLifecycle()

    UserListScreen(
        searchQueryTextState = searchQueryTextState,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        users = users,
        navigateToUserDetails = navigateToUserDetails,
    )
}