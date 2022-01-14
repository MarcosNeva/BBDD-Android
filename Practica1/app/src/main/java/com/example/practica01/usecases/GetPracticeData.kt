package com.example.practica01.usecases

import com.example.practica01.domain.PracticeData
import com.example.practica01.domain.PracticeRepository

class GetPracticeData(private val practiceRepository: PracticeRepository) {
    fun getPracticeData(): PracticeData {
        return practiceRepository.getPracticeData()
    }
}
