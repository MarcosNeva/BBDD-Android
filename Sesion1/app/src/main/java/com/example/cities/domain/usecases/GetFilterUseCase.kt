package com.example.cities.domain.usecases

import com.example.cities.domain.model.CityFilter
import com.example.cities.domain.repository.CityRepository

class GetFilterUseCase(private val cityRepository: CityRepository) {

    fun getFilter():CityFilter{
        return cityRepository.getCityFilter()
    }
}