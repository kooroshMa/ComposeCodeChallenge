package com.example.composecodechallenge.features.userlist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.composecodechallenge.R
import com.example.composecodechallenge.main.ui.common.SimpleTopAppBar
import com.example.composecodechallenge.main.ui.theme.space

@Composable
internal fun UserListScreen(
    modifier: Modifier = Modifier,
    searchQueryTextState: State<String>,
    onSearchQueryChange: (String) -> Unit,
) {
    Scaffold(
        topBar = {
            SimpleTopAppBar(title = stringResource(id = R.string.top_bar_title))
        },
        content = {
            UserListScreenContent(
                modifier = modifier.padding(it),
                searchQueryTextState = searchQueryTextState,
                onSearchQueryChange = onSearchQueryChange,
            )
        }
    )
}

@Composable
fun UserListScreenContent(
    modifier: Modifier = Modifier,
    searchQueryTextState: State<String>,
    onSearchQueryChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = MaterialTheme.space.small),
    ) {
        TextField(searchQueryTextState, onSearchQueryChange)
    }

}

@Composable
internal fun TextField(
    searchQueryTextState: State<String>,
    onSearchQueryChange: (String) -> Unit
) {
    OutlinedTextField(
        value = searchQueryTextState.value,
        onValueChange = {
            onSearchQueryChange(it)
        },
        placeholder = { Text(text = stringResource(id = R.string.hint_search)) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        modifier = Modifier
            .padding(MaterialTheme.space.small)
            .fillMaxWidth()
    )
}