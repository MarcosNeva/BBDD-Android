package com.example.practica01.domain

interface PracticeRepository {
    fun getPracticeData(): PracticeData
    fun addPracticeData(practiceData: PracticeData)
    fun deletePracticeData()
    fun updatePracticeData(practiceData: PracticeData)
}