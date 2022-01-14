package com.example.practica01.presentation.viewmodel

import com.example.practica01.domain.PracticeData

sealed class HomeState {
    object Loading : HomeState()
    data class Success(val practiceData: PracticeData) : HomeState()
    data class Failure(val exception: Throwable) : HomeState()

}
