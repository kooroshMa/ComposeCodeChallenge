package com.example.domain.model.userlist

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName( "id")
    val id: Int,
    @SerializedName( "avatar_url")
    val avatarUrl: String? = null,
    @SerializedName( "organizations_url")
    val organizationsUrl: String? = null,
    @SerializedName( "type")
    val type: String? = null,
    @SerializedName( "login")
    val login: String? = null,
)