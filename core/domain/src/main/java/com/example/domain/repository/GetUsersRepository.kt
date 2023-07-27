package com.example.domain.repository

import com.example.domain.model.userlist.UsersModel

interface GetUsersRepository {

    suspend fun getUsersRepository(userName: String): UsersModel

}