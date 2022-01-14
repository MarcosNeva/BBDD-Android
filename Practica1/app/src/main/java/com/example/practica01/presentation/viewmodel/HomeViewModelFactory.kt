package com.example.practica01.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practica01.domain.PracticeDataRepositoryImpl
import com.example.practica01.usecases.AddPracticeData
import com.example.practica01.usecases.DeletePracticeData
import com.example.practica01.usecases.GetPracticeData
import com.example.practica01.usecases.UpdatePracticeData


class HomeViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val practiceDataRepositoryImpl = PracticeDataRepositoryImpl()
        return HomeViewModel(
            getPracticeData = GetPracticeData(practiceDataRepositoryImpl),
            addPracticeData = AddPracticeData(practiceDataRepositoryImpl),
            deletePracticeData = DeletePracticeData(practiceDataRepositoryImpl),
            updatePracticeData = UpdatePracticeData(practiceDataRepositoryImpl)
        ) as T
    }
}
