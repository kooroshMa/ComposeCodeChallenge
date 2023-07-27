package com.example.data.source.cloud

import com.example.domain.model.userlist.UsersModel

class CloudMockRepository: BaseCloudRepository {
    override suspend fun getUsers(userName: String): UsersModel {
        TODO("Not yet implemented")
    }

}