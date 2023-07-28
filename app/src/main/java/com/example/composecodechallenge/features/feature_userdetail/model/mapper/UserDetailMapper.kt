package com.example.composecodechallenge.features.feature_userdetail.model.mapper

import com.example.composecodechallenge.features.feature_userdetail.model.UserDetailItem
import com.example.domain.model.userdetail.UserDetailModel

internal fun UserDetailModel.toUserDetailItem(): UserDetailItem {
    return UserDetailItem(
        avatarUrl.orEmpty()
    )
}