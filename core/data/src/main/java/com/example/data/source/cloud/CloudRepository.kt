package com.example.data.source.cloud

import com.example.data.restful.API
import com.example.domain.model.userlist.UsersModel

class CloudRepository (private val api: API): BaseCloudRepository {
    override suspend fun getUsers(userName: String): UsersModel {
        return api.getUsers(userName)
    }

}