package com.example.domain.usecase

import arrow.core.Either
import com.example.domain.mapper.ErrorMapper
import com.example.domain.model.error.Error
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseUseCase(private val errorMapper: ErrorMapper) {

    protected suspend fun <T : Any> safeApiCall(call: suspend () -> T): Either<Error, T> {
        return withContext(Dispatchers.IO) {
            getResult(call)
        }
    }

    private suspend fun <T : Any> getResult(call: suspend () -> T): Either<Error, T> {
        return try {
            Either.Right(call.invoke())
        } catch (t: Throwable) {
            Either.Left(errorMapper.getError(t))
        }
    }
}