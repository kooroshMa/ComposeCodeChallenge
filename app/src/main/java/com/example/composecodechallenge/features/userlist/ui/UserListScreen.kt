package com.example.composecodechallenge.features.userlist.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.composecodechallenge.R
import com.example.composecodechallenge.main.ui.common.SimpleTopAppBar

@Composable
internal fun UserListScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            SimpleTopAppBar(title = stringResource(id = R.string.top_bar_title))
        },
        content = {
            UserListScreenContent(modifier = modifier.padding(it))
        }
    )
}

@Composable
fun UserListScreenContent(modifier: Modifier = Modifier) {

}