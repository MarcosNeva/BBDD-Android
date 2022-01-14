package com.example.cities.domain.repository

import com.example.cities.domain.model.City

interface CityRepository {

    fun getCities():List<City>

    fun addCity(city:City)

}