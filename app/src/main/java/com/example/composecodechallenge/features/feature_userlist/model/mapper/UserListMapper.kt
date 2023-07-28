package com.example.composecodechallenge.features.feature_userlist.model.mapper

import com.example.composecodechallenge.features.feature_userlist.model.UserItem
import com.example.domain.model.userlist.UserModel

internal fun UserModel.toUserItem(): UserItem {
    return UserItem(
        id,
        avatarUrl.orEmpty(),
        login.orEmpty(),
    )
}