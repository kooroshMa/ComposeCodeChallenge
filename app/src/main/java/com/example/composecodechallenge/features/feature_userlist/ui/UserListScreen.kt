package com.example.composecodechallenge.features.feature_userlist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import coil.compose.rememberAsyncImagePainter
import com.example.composecodechallenge.R
import com.example.composecodechallenge.features.feature_userlist.model.UserItem
import com.example.composecodechallenge.main.ui.common.SimpleTopAppBar
import com.example.composecodechallenge.main.ui.theme.ThemePreview
import com.example.composecodechallenge.main.ui.theme.space

@Composable
internal fun UserListScreen(
    modifier: Modifier = Modifier,
    searchQueryTextState: State<String?>,
    onSearchQueryChange: (String) -> Unit,
    users: State<List<UserItem>>,
    navigateToUserDetails: (String) -> Unit,
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
                users = users,
                navigateToUserDetails,
            )
        }
    )
}

@Composable
fun UserListScreenContent(
    modifier: Modifier = Modifier,
    searchQueryTextState: State<String?>,
    onSearchQueryChange: (String) -> Unit,
    users: State<List<UserItem>>,
    navigateToUserDetails: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = MaterialTheme.space.small),
    ) {
        TextField(searchQueryTextState, onSearchQueryChange)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .testTag("list_item"),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.space.sMedium),

            ) {
            items(users.value, key = {
                it.id
            }) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            navigateToUserDetails.invoke(it.userName)
                        },
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Spacer(Modifier.width(MaterialTheme.space.small))

                        Image(
                            painter = rememberAsyncImagePainter(model = it.avatarUrl),
                            contentDescription = it.userName,
                            modifier = Modifier
                                .size(MaterialTheme.space.xLarge)
                                .clip(CircleShape)
                        )

                        Spacer(Modifier.width(MaterialTheme.space.small))

                        Text(
                            text = it.userName,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(vertical = MaterialTheme.space.medium)
                        )
                    }
                }

            }
        }
    }

}

@Composable
internal fun TextField(
    searchQueryTextState: State<String?>,
    onSearchQueryChange: (String) -> Unit
) {
    OutlinedTextField(
        value = searchQueryTextState.value.orEmpty(),
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
            .testTag("search_users")
    )
}

@ThemePreview
@Composable
internal fun UserListPreview() {
    UserListScreen(
        searchQueryTextState = mutableStateOf("Search..."),
        onSearchQueryChange = {},
        users = mutableStateOf(emptyList()),
        navigateToUserDetails = {}
    )
}