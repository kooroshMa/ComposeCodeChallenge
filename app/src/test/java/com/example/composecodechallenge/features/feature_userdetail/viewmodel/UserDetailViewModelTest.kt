package com.example.composecodechallenge.features.feature_userdetail.viewmodel

import androidx.lifecycle.SavedStateHandle
import arrow.core.Either
import com.example.composecodechallenge.features.feature_userdetail.model.mapper.toUserDetailItem
import com.example.domain.model.userdetail.UserDetailModel
import com.example.domain.usecase.GetUserDetailUseCase
import com.example.composecodechallenge.util.CoroutinesTestRule
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class UserDetailViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private val getUserDetailUseCase: GetUserDetailUseCase = mock()
    private val savedStateHandle: SavedStateHandle = mock()
    private val testUserDetailModel = UserDetailModel()
    private lateinit var viewModel: UserDetailViewModel

    @Before
    fun setUp() = runTest {
        whenever(savedStateHandle.get<String>(anyString())) doReturn "test"
        whenever(getUserDetailUseCase.getUserDetail(any())) doReturn Either.Right(
            testUserDetailModel
        )
        viewModel = UserDetailViewModel(getUserDetailUseCase, savedStateHandle)
    }

    @Test
    fun `user detail should be get successfully right after view model construction`() = runTest {
        // Given
        val userDetailItem = testUserDetailModel.toUserDetailItem()
        // Then
        assertThat(viewModel.userDetail.value, `is`(userDetailItem))
    }
}
