package com.example.data.source.cloud

import com.example.domain.model.userdetail.UserDetailModel
import com.example.domain.model.userlist.UsersModel

class CloudMockRepository: BaseCloudRepository {
    override suspend fun getUsers(userName: String): UsersModel {
        TODO("Not yet implemented")
    }

    override suspend fun getUserDetail(userName: String): UserDetailModel {
        TODO("Not yet implemented")
    }

}