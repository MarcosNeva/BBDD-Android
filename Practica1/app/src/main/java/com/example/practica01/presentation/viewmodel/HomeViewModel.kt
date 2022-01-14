package com.example.practica01.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica01.domain.PracticeData
import com.example.practica01.presentation.view.HomeState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {
    private val practiceMutableStateFlow: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState.Loading)
    val practiceStateFlow: StateFlow<HomeState> = practiceMutableStateFlow
    fun getData() {
        viewModelScope.launch {
            delay(3000) //Simulating network request
            val practiceData = PracticeData("Practice 01 done successfully!")
            practiceMutableStateFlow.emit(HomeState.Success(practiceData))
        }
    }
}