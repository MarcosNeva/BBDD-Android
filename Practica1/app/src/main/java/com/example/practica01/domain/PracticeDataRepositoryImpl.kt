package com.example.practica01.domain

class PracticeDataRepositoryImpl : PracticeRepository {
    override fun getPracticeData(): PracticeData {
        return PracticeData("Práctica 03")
    }
    override fun addPracticeData(practiceData: PracticeData) {
    }
    override fun deletePracticeData() {
    }
    override fun updatePracticeData(practiceData: PracticeData) {
    }
}