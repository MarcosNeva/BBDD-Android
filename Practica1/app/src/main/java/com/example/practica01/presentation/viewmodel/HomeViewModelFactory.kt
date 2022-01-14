package com.example.practica01.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practica01.data.sharedpreferences.PracticeDataSharedPreferences
import com.example.practica01.domain.PracticeDataRepositoryImpl
import com.example.practica01.usecases.AddPracticeData
import com.example.practica01.usecases.DeletePracticeData
import com.example.practica01.usecases.GetPracticeData
import com.example.practica01.usecases.UpdatePracticeData

class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val practiceDataSharedPreferences = PracticeDataSharedPreferences(context)
        val practiceDataRepositoryImpl = PracticeDataRepositoryImpl(practiceDataSharedPreferences)
        return HomeViewModel(
            getPracticeData = GetPracticeData(practiceDataRepositoryImpl),
            addPracticeData = AddPracticeData(practiceDataRepositoryImpl),
            deletePracticeData = DeletePracticeData(practiceDataRepositoryImpl),
            updatePracticeData = UpdatePracticeData(practiceDataRepositoryImpl)
        ) as T
    }
}