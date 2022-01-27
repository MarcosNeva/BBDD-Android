package com.example.practica01.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practica01.data.datastore.PracticeDataStore
import com.example.practica01.domain.PracticeDataRepositoryImpl
import com.example.practica01.usecases.AddPracticeData
import com.example.practica01.usecases.DeletePracticeData
import com.example.practica01.usecases.GetPracticeData
import com.example.practica01.usecases.UpdatePracticeData

class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val practiceDataStore = PracticeDataStore(context)
        val practiceDataRepositoryImpl = PracticeDataRepositoryImpl(practiceDataStore)
        return HomeViewModel(
            getPracticeData = GetPracticeData(practiceDataRepositoryImpl),
            addPracticeData = AddPracticeData(practiceDataRepositoryImpl),
            deletePracticeData = DeletePracticeData(practiceDataRepositoryImpl),
            updatePracticeData = UpdatePracticeData(practiceDataRepositoryImpl)
        ) as T
    }
}
