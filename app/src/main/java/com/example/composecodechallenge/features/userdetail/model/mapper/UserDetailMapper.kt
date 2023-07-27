package com.example.composecodechallenge.features.userdetail.model.mapper

import com.example.composecodechallenge.features.userdetail.model.UserDetailItem
import com.example.domain.model.userdetail.UserDetailModel

internal fun UserDetailModel.toUserDetailItem(): UserDetailItem {
    return UserDetailItem(
        avatarUrl.orEmpty()
    )
}