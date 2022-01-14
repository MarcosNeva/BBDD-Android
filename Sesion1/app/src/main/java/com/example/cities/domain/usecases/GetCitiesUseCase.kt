package com.example.cities.domain.usecases

import com.example.cities.domain.model.City
import com.example.cities.domain.model.CityFilter
import com.example.cities.domain.repository.CityRepository

class GetCitiesUseCase(val repository: CityRepository) {

    fun getCities(): List<City>{

        val cities = repository.getCities()
        val filter = repository.getCityFilter()
        return when(filter){
            CityFilter.ALL_CITIES -> cities
            CityFilter.SUNNY_CITIES -> cities.filter { city -> city.sunshineHours > 1800 }
            CityFilter.CLOUDY_CITIES -> cities.filter { city -> city.sunshineHours < 1801}

        }
    }
}