package com.example.cities.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cities.domain.model.City
import com.example.cities.domain.usecases.AddCityUseCase
import com.example.cities.domain.usecases.GetCitiesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.cities.presentation.viewmodel.CityState.Loading
import com.example.cities.presentation.viewmodel.CityState.Success
import com.example.cities.presentation.viewmodel.CityState.Failure
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel ( private val addCityUseCase: AddCityUseCase, private val getCitiesUseCase: GetCitiesUseCase): ViewModel() {

    private val citiesMutableStateFlow = MutableStateFlow<CityState>(Loading)
    val cityStateFlow: StateFlow<CityState> = citiesMutableStateFlow



    fun getData(){
        viewModelScope.launch {
            delay(1000)
            val newCities = mutableListOf<City>()
            citiesMutableStateFlow.emit(Success(newCities))
        }

    }



    fun addCity(city: City) {
        addCityUseCase.addCity(city)
        getData()
    }
}