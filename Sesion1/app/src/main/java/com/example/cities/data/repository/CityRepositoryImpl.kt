package com.example.cities.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.cities.domain.model.City
import com.example.cities.domain.model.CityFilter
import com.example.cities.domain.repository.CityRepository

const val CITIES_PREFERENCE = "Cities_Preferences"
const val CITY_FILTER_KEY = "CityFilterKey"

const val CITIES_DATA_STORAGE = "CITIES_DATA_STORAGE"

class CityRepositoryImpl (private val sharedPreferences: SharedPreferences): CityRepository {


    private val cities = getFakeData()

    override fun getCities(): List<City> {
        val newCities = mutableListOf<City>()
        newCities.addAll(cities)
        return newCities
    }

    override fun addCity(city: City) {
       cities.add(city)
    }

    override fun setFilter(cityFilter: CityFilter) {
        sharedPreferences.edit().putString(CITY_FILTER_KEY, cityFilter.name).apply()
    }

    override fun getCityFilter(): CityFilter {
        val filter = sharedPreferences.getString(CITY_FILTER_KEY, CityFilter.ALL_CITIES.name) ?: CityFilter.ALL_CITIES.name
        return CityFilter.valueOf(filter)
    }

    private fun getFakeData(): MutableList<City> {
        val cities = mutableListOf<City>()
        cities.add(City(1, "Zaragoza", "Zaragoza es una ciudad y un municipio de España, capital de la provincia homónima y de la comunidad autónoma de Aragón. ", 2690))
        cities.add(City(2, "Londres", "Londres es la capital y mayor ciudad de Inglaterra y del Reino Unido.",1410))
        cities.add(City(3, "Berlín", "Berlín es la capital de Alemania y uno de los dieciséis estados federados alemanes. ",1625))
        cities.add(City(4, "Santo Domingo", "Santo Domingo (oficialmente llamada Santo Domingo de Guzmán) es la capital y ciudad más poblada de la República Dominicana.",2316))
        return cities
    }

}