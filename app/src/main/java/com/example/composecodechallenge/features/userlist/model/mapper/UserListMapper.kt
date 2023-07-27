package com.example.composecodechallenge.features.userlist.model.mapper

import com.example.composecodechallenge.features.userlist.model.UserListItem
import com.example.domain.model.userlist.UserModel

internal fun UserModel.toUserItem(): UserListItem {
    return UserListItem(
        id,
        avatarUrl.orEmpty(),
        login.orEmpty(),
    )
}