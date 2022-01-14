package com.example.cities.domain.repository

import com.example.cities.domain.model.City
import com.example.cities.domain.model.CityFilter

interface CityRepository {

    fun getCities():List<City>

    fun addCity(city:City)

    fun setFilter (cityFilter: CityFilter)

    fun getCityFilter ():CityFilter

}