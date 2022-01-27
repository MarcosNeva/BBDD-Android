package com.example.practica01.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica01.domain.PracticeData
import com.example.practica01.usecases.AddPracticeData
import com.example.practica01.usecases.DeletePracticeData
import com.example.practica01.usecases.GetPracticeData
import com.example.practica01.usecases.UpdatePracticeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPracticeData: GetPracticeData,
    private val addPracticeData: AddPracticeData,
    private val updatePracticeData: UpdatePracticeData,
    private val deletePracticeData: DeletePracticeData
) : ViewModel() {

    private val practiceMutableStateFlow: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Loading)
    val practiceStateFlow: StateFlow<HomeState> = practiceMutableStateFlow


    fun getData() {
        viewModelScope.launch {
            practiceMutableStateFlow.emit(HomeState.Loading)
            getPracticeData.getPracticeData().collect { practiceData ->
                practiceMutableStateFlow.emit(HomeState.Success(practiceData))
            }
        }
    }

    fun addData(practiceData: PracticeData) {
        viewModelScope.launch {
            addPracticeData.addPracticeData(practiceData)
        }
    }

    fun updateData(practiceData: PracticeData) {
        viewModelScope.launch {
            updatePracticeData.updatePracticeData(practiceData)
        }
    }

    fun deleteData() {
        viewModelScope.launch {
            deletePracticeData.deletePracticeData()
        }
    }
}