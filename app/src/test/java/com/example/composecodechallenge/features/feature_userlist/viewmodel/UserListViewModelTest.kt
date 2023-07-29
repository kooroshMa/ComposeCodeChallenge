package com.example.composecodechallenge.features.feature_userlist.viewmodel

import arrow.core.Either
import com.example.composecodechallenge.features.feature_userlist.model.mapper.toUserItem
import com.example.domain.model.userlist.UserModel
import com.example.domain.usecase.GetUsersUseCase
import com.example.composecodechallenge.util.CoroutinesTestRule
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class UserListViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private val getUsersUseCase: GetUsersUseCase = mock()
    private lateinit var viewModel: UserListViewModel

    @Before
    fun setUp() {
        viewModel = UserListViewModel(getUsersUseCase)
    }

    @Test
    fun `an empty list should be set when onSearchQueryChange is called with an empty argument`() =
        runTest {
            // Given
            val searchQuery = ""

            // When
            viewModel.onSearchQueryChange(searchQuery)

            // Then
            assertThat(viewModel.usersState.value.size, `is`(0))
            verify(getUsersUseCase, never()).getUsers(searchQuery)
        }

    @Test
    fun `users list should be get successfully when onSearchQueryChange is called`() = runTest {
        // Given
        val searchQuery = "test"
        val userModel = UserModel(
            id = 0,
            avatarUrl = "test",
            organizationsUrl = "1",
            type = "test",
            login = "test"
        )
        val userModelList = listOf(userModel)
        val userItemList = userModelList.map { it.toUserItem() }
        whenever(getUsersUseCase.getUsers(searchQuery)) doReturn Either.Right(userModelList)

        runBlocking {
            // When
            viewModel.onSearchQueryChange(searchQuery)
            delay(1000)

            // Then
            assertThat(viewModel.usersState.first(), `is`(userItemList))
            verify(getUsersUseCase).getUsers(searchQuery)
        }
    }
}
