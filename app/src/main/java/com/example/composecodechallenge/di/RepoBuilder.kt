package com.example.composecodechallenge.di

import com.example.data.repository.GetUserDetailRepoImpl
import com.example.data.repository.GetUsersRepoImpl
import com.example.domain.repository.GetUserDetailRepository
import com.example.domain.repository.GetUsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBuilder {

    @Binds
    abstract fun bindUserRepo(userRepoImpl: GetUsersRepoImpl): GetUsersRepository

    @Binds
    abstract fun bindUserDetailRepo(userDetailRepoImpl: GetUserDetailRepoImpl): GetUserDetailRepository

}