package com.example.data.repository

import com.example.data.di.Cloud
import com.example.data.source.cloud.BaseCloudRepository
import com.example.domain.model.userlist.UsersModel
import com.example.domain.repository.GetUsersRepository
import javax.inject.Inject

class GetUsersRepoImpl @Inject constructor(
    @Cloud private val baseCloudRepository: BaseCloudRepository): GetUsersRepository {

    override suspend fun getUsersRepository(userName: String): UsersModel {
        return baseCloudRepository.getUsers(userName)
    }
}