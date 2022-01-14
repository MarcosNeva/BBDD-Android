package com.example.practica01.usecases

import com.example.practica01.domain.PracticeData
import com.example.practica01.domain.PracticeRepository

class AddPracticeData(private val practiceRepository: PracticeRepository) {
    fun addPracticeData(practiceData: PracticeData) {
        return practiceRepository.addPracticeData(practiceData)
    }
}