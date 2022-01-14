package com.example.practica01.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica01.domain.PracticeData
import com.example.practica01.usecases.AddPracticeData
import com.example.practica01.usecases.DeletePracticeData
import com.example.practica01.usecases.GetPracticeData
import com.example.practica01.usecases.UpdatePracticeData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPracticeData: GetPracticeData,
    private val addPracticeData: AddPracticeData,
    private val updatePracticeData: UpdatePracticeData,
    private val deletePracticeData: DeletePracticeData
) : ViewModel() {
    private val practiceMutableStateFlow: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState.Loading)
    val practiceStateFlow: StateFlow<HomeState> = practiceMutableStateFlow
    fun getData() {
        viewModelScope.launch {
            delay(3000) //Simulating network request
            val practiceData = getPracticeData.getPracticeData()
            practiceMutableStateFlow.emit(HomeState.Success(practiceData))
        }
    }
    fun addData(practiceData: PracticeData) {
        addPracticeData.addPracticeData(practiceData)
    }
    fun updateData(practiceData: PracticeData) {
        updatePracticeData.updatePracticeData(practiceData)
    }
    fun deleteData() {
        deletePracticeData.deletePracticeData()
    }
}