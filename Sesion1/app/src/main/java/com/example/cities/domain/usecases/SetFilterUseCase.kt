package com.example.cities.domain.usecases

import com.example.cities.domain.model.CityFilter
import com.example.cities.domain.repository.CityRepository

class SetFilterUseCase(private val cityRepository : CityRepository) {

    fun setFilter(cityFilter: CityFilter){
    return cityRepository.setFilter(cityFilter)
    }
}