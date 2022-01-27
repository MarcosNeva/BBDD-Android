package com.example.practica01.usecases

import com.example.practica01.domain.PracticeData
import com.example.practica01.domain.PracticeRepository
import kotlinx.coroutines.flow.Flow

class GetPracticeData(private val practiceRepository: PracticeRepository) {
    fun getPracticeData(): Flow<PracticeData> {
        return practiceRepository.getPracticeData()
    }
}
