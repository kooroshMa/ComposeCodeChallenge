package com.example.domain.model.userlist

import com.google.gson.annotations.SerializedName

data class UsersModel(
    @SerializedName("total_count")
    val totalCount: Int? = null,
    @SerializedName("incomplete_results")
    val incompleteResult: Boolean? = null,
    @SerializedName("items")
    val users: List<UserModel>,
)