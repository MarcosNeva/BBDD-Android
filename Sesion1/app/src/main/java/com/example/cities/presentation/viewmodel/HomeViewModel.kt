package com.example.cities.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cities.domain.model.City
import com.example.cities.domain.model.CityFilter
import com.example.cities.domain.usecases.AddCityUseCase
import com.example.cities.domain.usecases.GetCitiesUseCase
import com.example.cities.domain.usecases.GetFilterUseCase
import com.example.cities.domain.usecases.SetFilterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.cities.presentation.viewmodel.CityState.Loading
import com.example.cities.presentation.viewmodel.CityState.Success
import com.example.cities.presentation.viewmodel.CityState.Failure
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel (

    private val addCityUseCase: AddCityUseCase,
    private val getCitiesUseCase: GetCitiesUseCase,
    private val setFilterUseCase: SetFilterUseCase,
    private val getFilterUseCase: GetFilterUseCase
    ): ViewModel() {

    private val citiesMutableStateFlow = MutableStateFlow<CityState>(Loading)
    val cityStateFlow: StateFlow<CityState> = citiesMutableStateFlow

    private val filterCityMutableStateFlow =  MutableStateFlow<CityFilter>(CityFilter.ALL_CITIES)
    val filterCityState: StateFlow<CityFilter> = filterCityMutableStateFlow

    fun getData(){
        viewModelScope.launch {
            //delay(1000)
            val newCities = getCitiesUseCase.getCities()
            citiesMutableStateFlow.emit(Success(newCities))
        }
    }

    fun addCity(city: City) {
        addCityUseCase.addCity(city)
        getData()
    }

    fun setFilter(cityFilter :CityFilter){

        setFilterUseCase.setFilter(cityFilter)
        getData()
        getFilter()
    }

    fun getFilter(){
        viewModelScope.launch {
            val filter = getFilterUseCase.getFilter()
            filterCityMutableStateFlow.emit(filter)
        }
    }
}