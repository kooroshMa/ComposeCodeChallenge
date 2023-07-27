package com.example.composecodechallenge.features.userlist.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecodechallenge.features.userlist.model.UserListItem
import com.example.domain.model.error.Error
import com.example.domain.model.userlist.UserModel
import com.example.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel(){

    private val _users = MutableStateFlow(emptyList<UserListItem>())
    val users = _users.asStateFlow()

    private fun getUsers(query: String) {

         viewModelScope.launch {
             getUsersUseCase.getUsers(query).fold(
                ifRight = ::onSuccessResponse,
                ifLeft = ::onErrorResponse
            )
        }
    }

    private fun onSuccessResponse(users: List<UserModel>) {

    }

    private fun onErrorResponse(error: Error) {
        Log.i("error", error.toString())
    }

}