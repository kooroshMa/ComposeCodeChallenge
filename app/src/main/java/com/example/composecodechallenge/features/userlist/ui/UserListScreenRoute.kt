package com.example.composecodechallenge.features.userlist.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composecodechallenge.features.userlist.viewmodel.UserListViewModel

@Composable
internal fun UserListRoute(
    viewModel: UserListViewModel = hiltViewModel()
) {
    val searchQueryTextState = viewModel.searchQueryText.collectAsStateWithLifecycle()

    UserListScreen(
        searchQueryTextState = searchQueryTextState,
        onSearchQueryChange = viewModel::onSearchQueryChange,
    )
}