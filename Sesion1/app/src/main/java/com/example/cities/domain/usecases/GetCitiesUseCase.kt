package com.example.cities.domain.usecases

import com.example.cities.domain.model.City
import com.example.cities.domain.repository.CityRepository

class GetCitiesUseCase(val repository: CityRepository) {

    fun getCities(): List<City>{
        return repository.getCities()
    }
}