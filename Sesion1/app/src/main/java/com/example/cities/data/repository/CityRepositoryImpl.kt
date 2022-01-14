package com.example.cities.data.repository

import com.example.cities.domain.model.City
import com.example.cities.domain.repository.CityRepository

class CityRepositoryImpl: CityRepository {


    override fun getCities(): List<City> {
        TODO("Not yet implemented")
    }

    override fun addCity(city: City) {
       // cities.
    }

    fun getFakeData() :List <City>{
        val cities = mutableListOf<City>()

        cities.add(City(id=1, name = "Zaragoza", description ="Guay!"))
        cities.add(City(id=1, name = "Logroño", description ="Guay!"))
        cities.add(City(id=1, name = "Madrid", description ="Guay!"))

        return cities
    }
}