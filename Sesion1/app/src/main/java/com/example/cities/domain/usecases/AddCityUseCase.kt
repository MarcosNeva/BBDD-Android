package com.example.cities.domain.usecases

import com.example.cities.domain.model.City
import com.example.cities.domain.repository.CityRepository

class AddCityUseCase ( val cityRepository: CityRepository) {

    fun addCity(city : City){
        cityRepository.addCity(city)
    }
}