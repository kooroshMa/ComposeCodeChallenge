package com.example.domain.repository

import com.example.domain.model.userdetail.UserDetailModel

interface GetUserDetailRepository {

    suspend fun getUserDetail(userName: String): UserDetailModel
}