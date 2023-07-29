package com.example.data.repository

import com.example.composecodechallenge.util.CoroutinesTestRule
import com.example.data.source.cloud.BaseCloudRepository
import com.example.domain.model.userlist.UsersModel
import com.example.domain.repository.GetUsersRepository
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetUserDetailRepoImplTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private val baseCloudRepository: BaseCloudRepository = mock()
    private lateinit var getUsersRepository: GetUsersRepository

    @Before
    fun setUp() {
        getUsersRepository = GetUsersRepoImpl(baseCloudRepository)
    }

    @Test
    fun `the response should be get successfully when getUsersRepository is called`()= runTest {
        // Given
        val userName="test"
        val response = UsersModel(users = listOf())
        whenever(baseCloudRepository.getUsers(userName)) doReturn response

        // When
        val result = getUsersRepository.getUsersRepository(userName)

        // Then
        assertThat(result, `is`(response))
        verify(baseCloudRepository).getUsers(userName)
    }
}
