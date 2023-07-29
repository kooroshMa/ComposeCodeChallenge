package com.example.domain.usecase

import arrow.core.Either
import com.example.domain.mapper.ErrorMapper
import com.example.domain.model.error.Error
import com.example.domain.model.userdetail.UserDetailModel
import com.example.domain.repository.GetUserDetailRepository
import javax.inject.Inject

class GetUserDetailUseCase @Inject constructor(
    private val UserDetailRepository: GetUserDetailRepository,
    errorMapper: ErrorMapper
) : BaseUseCase(errorMapper) {

    suspend fun getUserDetail(userName: String): Either<Error, UserDetailModel> {
        return safeApiCall {
            UserDetailRepository.getUserDetail(userName)
        }
    }
}