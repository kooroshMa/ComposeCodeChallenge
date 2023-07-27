package com.example.composecodechallenge.features.userdetail_feature.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecodechallenge.features.userdetail_feature.model.UserDetailItem
import com.example.composecodechallenge.features.userdetail_feature.model.mapper.toUserDetailItem
import com.example.domain.model.error.Error
import com.example.domain.model.userdetail.UserDetailModel
import com.example.domain.usecase.UserDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userDetailUseCase: UserDetailUseCase,
) :
    ViewModel() {

    private val _userDetail = MutableStateFlow(UserDetailItem(""))
    val userDetail = _userDetail.asStateFlow()

    private fun getUserDetail(userName: String) {
        viewModelScope.launch {
            userDetailUseCase.getUserDetail(userName).fold(
                ifRight = ::onSuccessResponse,
                ifLeft = ::onErrorResponse
            )
        }
    }

    private fun onErrorResponse(error: Error) {
        Log.i("error", error.toString())
    }

    private fun onSuccessResponse(questionList: UserDetailModel) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _userDetail.value = questionList.toUserDetailItem()
            }
        }
    }

}