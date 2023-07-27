package com.example.data.restful

import com.example.domain.model.userlist.UsersModel
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("/search/users")
    suspend fun getUsers(@Query("q") username: String): UsersModel

}