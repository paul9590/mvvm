package com.example.domain

class SampleUseCase(
    private val sampleRepository: SampleRepository
) {

    suspend fun getUserName(): String {
        return sampleRepository.getUserName()
    }
}