package com.example.data.repository

import com.example.data.di.Cloud
import com.example.data.source.cloud.BaseCloudRepository
import com.example.domain.model.userdetail.UserDetailModel
import com.example.domain.repository.GetUserDetailRepository
import javax.inject.Inject

class GetUserDetailRepoImpl @Inject constructor(
    @Cloud private val baseCloudRepository: BaseCloudRepository
): GetUserDetailRepository {

    override suspend fun getUserDetail(userName: String): UserDetailModel {
        return baseCloudRepository.getUserDetail(userName)
    }
}