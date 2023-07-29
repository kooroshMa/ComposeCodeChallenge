package com.example.domain.model.userdetail

import com.google.gson.annotations.SerializedName

data class UserDetailModel(
    @SerializedName( "id")
    val id: Int? = null,
    @SerializedName( "avatar_url")
    val avatarUrl: String? = null,
    @SerializedName( "followers_url")
    val followersUrl: String? = null,
    @SerializedName( "following_url")
    val followingUrl: String? = null,
    @SerializedName( "gravatar_id")
    val gravatarId: String? = null,
)