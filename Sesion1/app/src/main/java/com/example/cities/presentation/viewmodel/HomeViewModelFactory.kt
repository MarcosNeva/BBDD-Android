package com.example.cities.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cities.data.repository.CityRepositoryImpl
import com.example.cities.domain.usecases.AddCityUseCase
import com.example.cities.domain.usecases.GetCitiesUseCase

class HomeViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = CityRepositoryImpl()
        val addCity = AddCityUseCase(repository)
        val getCitiesUseCase = GetCitiesUseCase(repository)
        return HomeViewModel(addCity, getCitiesUseCase) as T
    }
}