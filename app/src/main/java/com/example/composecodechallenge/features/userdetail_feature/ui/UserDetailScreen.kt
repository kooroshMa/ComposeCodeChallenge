package com.example.composecodechallenge.features.userdetail_feature.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import coil.compose.rememberAsyncImagePainter
import com.example.composecodechallenge.features.userdetail_feature.model.UserDetailItem
import com.example.composecodechallenge.main.ui.common.SimpleTopAppBar
import com.example.composecodechallenge.main.ui.theme.ThemePreview

@Composable
internal fun UserDetailsScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    userDetail: State<UserDetailItem>,
) {

    Scaffold(
        topBar = {
            SimpleTopAppBar(title = "", onBackClick = onBackClick)
        },
        content = {
            UserDetailScreenContent(
                imageUrl = userDetail.value.avatarUrl,
                modifier = modifier.padding(it),
            )
        }
    )
}

@Composable
internal fun UserDetailScreenContent(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = rememberAsyncImagePainter(model = imageUrl),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .clip(CircleShape)
            .then(modifier)
    )
}

@ThemePreview
@Composable
internal fun UserDetailsScreenPreview() {
    UserDetailsScreen(
        onBackClick = {},
        userDetail = mutableStateOf(UserDetailItem(""))
    )
}