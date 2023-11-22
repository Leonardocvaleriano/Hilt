package com.codeplace.daggerhilt.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeplace.daggerhilt.domain.repository.ProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: ProjectRepository): ViewModel(){

    var isLoading by mutableStateOf(HomeState())
        private set

    init {
        turnLoadTrue()
    }

    private fun turnLoadTrue() {
        viewModelScope.launch {
            repository.doNetworkCall()

            delay(3000)
            isLoading = HomeState(
                isLoading = true
            )
        }

    }

}