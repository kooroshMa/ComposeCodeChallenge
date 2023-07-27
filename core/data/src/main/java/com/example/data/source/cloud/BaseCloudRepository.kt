package com.example.data.source.cloud

import com.example.domain.model.userdetail.UserDetailModel
import com.example.domain.model.userlist.UsersModel

interface BaseCloudRepository {

    suspend fun getUsers(userName:String): UsersModel

    suspend fun getUserDetail(userName: String): UserDetailModel

}