package com.example.data.source.cloud

import com.example.data.restful.API
import com.example.domain.model.userdetail.UserDetailModel
import com.example.domain.model.userlist.UsersModel

class CloudRepository (private val api: API): BaseCloudRepository {
    override suspend fun getUsers(userName: String): UsersModel {
        return api.getUsers(userName)
    }

    override suspend fun getUserDetail(userName: String): UserDetailModel {
        return api.getUserDetails(userName)
    }

}