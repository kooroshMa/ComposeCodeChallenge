package com.example.composecodechallenge.features.feature_userlist.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecodechallenge.features.feature_userlist.model.UserItem
import com.example.composecodechallenge.features.feature_userlist.model.mapper.toUserItem
import com.example.domain.model.error.Error
import com.example.domain.model.userlist.UserModel
import com.example.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel(){

    private val _usersState = MutableStateFlow(emptyList<UserItem>())
    val usersState = _usersState.asStateFlow()

    private val _searchQueryText = MutableStateFlow<String?>(null)
    val searchQueryText = _searchQueryText.asStateFlow()

    private var searchJob: Job? = null

    init {
        startToCollectSearchQueries()
    }

    private fun startToCollectSearchQueries() {
        searchQueryText
            .filterNotNull()
            .debounce(QUERY_DEBOUNCE_IN_MILLIS)
            .onEach(::getUsers)
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    fun onSearchQueryChange(query: String) {
        _searchQueryText.value = query
    }

    private fun getUsers(query: String) {
        searchJob?.cancel()

        if (query.isBlank()) {
            _usersState.value = emptyList()
            return
        }

        searchJob = viewModelScope.launch {
             getUsersUseCase.getUsers(query).fold(
                ifRight = ::onSuccessResponse,
                ifLeft = ::onErrorResponse
            )
        }
    }

    private fun onSuccessResponse(users: List<UserModel>) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                _usersState.value = users.map { it.toUserItem() }
            }
        }
    }

    private fun onErrorResponse(error: Error) {
        Log.i("error", error.toString())
    }

    private companion object {
        private const val QUERY_DEBOUNCE_IN_MILLIS = 500L
    }
}