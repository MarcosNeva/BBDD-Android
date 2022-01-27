package com.example.practica01.usecases

import com.example.practica01.domain.PracticeData
import com.example.practica01.domain.PracticeRepository

class UpdatePracticeData(private val practiceRepository: PracticeRepository) {
    suspend fun updatePracticeData(practiceData: PracticeData) {
        return practiceRepository.updatePracticeData(practiceData)
    }
}
