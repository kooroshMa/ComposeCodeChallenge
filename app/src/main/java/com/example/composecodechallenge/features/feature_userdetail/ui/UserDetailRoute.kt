package com.example.composecodechallenge.features.feature_userdetail.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composecodechallenge.features.feature_userdetail.viewmodel.UserDetailViewModel

@Composable
internal fun UserListRoute(
    viewModel: UserDetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {

    val userDetail = viewModel.userDetail.collectAsStateWithLifecycle()

    UserDetailsScreen(
        userDetail = userDetail,
        onBackClick = onBackClick
    )
}