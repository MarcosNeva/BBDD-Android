package com.example.cities.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cities.data.repository.CITIES_PREFERENCE
import com.example.cities.data.repository.CityRepositoryImpl
import com.example.cities.domain.usecases.AddCityUseCase
import com.example.cities.domain.usecases.GetCitiesUseCase
import com.example.cities.domain.usecases.GetFilterUseCase
import com.example.cities.domain.usecases.SetFilterUseCase

class HomeViewModelFactory (val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = CityRepositoryImpl(context.getSharedPreferences(CITIES_PREFERENCE, Context.MODE_PRIVATE))
        val addCityUseCase = AddCityUseCase(repository)
        val getCitiesUseCase = GetCitiesUseCase(repository)
        val setFilterUseCase = SetFilterUseCase(repository)
        val getFilterUseCase = GetFilterUseCase(repository)
        return HomeViewModel(addCityUseCase, getCitiesUseCase, setFilterUseCase, getFilterUseCase) as T
    }
}