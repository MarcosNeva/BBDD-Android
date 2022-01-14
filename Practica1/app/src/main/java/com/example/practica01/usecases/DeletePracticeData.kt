package com.example.practica01.usecases

import com.example.practica01.domain.PracticeRepository

class DeletePracticeData(private val practiceRepository: PracticeRepository) {
    fun deletePracticeData() {
        return practiceRepository.deletePracticeData()
    }
}