package com.example.practica01.domain

import com.example.practica01.data.sharedpreferences.PracticeDataSharedPreferences

class PracticeDataRepositoryImpl(private val practiceDataSharedPref: PracticeDataSharedPreferences) : PracticeRepository {
    override fun getPracticeData(): PracticeData {
        val name = practiceDataSharedPref.getPrefData()
        return PracticeData(name)
    }
    override fun addPracticeData(practiceData: PracticeData) {
        practiceDataSharedPref.addPrefData(practiceData.name)
    }
    override fun deletePracticeData() {
        practiceDataSharedPref.deletePrefData()
    }
    override fun updatePracticeData(practiceData: PracticeData) {
        practiceDataSharedPref.updatePrefData(practiceData.name)
    }
}