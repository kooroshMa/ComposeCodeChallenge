package com.example.data.source.cloud

import com.example.domain.model.userlist.UsersModel

interface BaseCloudRepository {

    suspend fun getUsers(userName:String): UsersModel

}