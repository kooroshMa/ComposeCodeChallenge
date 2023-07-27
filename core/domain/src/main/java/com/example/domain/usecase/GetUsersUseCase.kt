package com.example.domain.usecase

import arrow.core.Either
import com.example.domain.mapper.ErrorMapper
import com.example.domain.model.error.Error
import com.example.domain.model.userlist.UserModel
import com.example.domain.repository.GetUsersRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: GetUsersRepository,
    errorMapper: ErrorMapper
) : BaseUseCase(errorMapper) {

    suspend fun getUsers(userName: String): Either<Error, List<UserModel>> {
        return safeApiCall {
            repository.getUsersRepository(userName)
        }.map {it.users }
    }
}