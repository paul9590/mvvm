package com.example.data

import com.example.domain.SampleRepository

class SampleRepositoryImpl(
    private val sampleService: SampleService
) : SampleRepository {
    override suspend fun getUserName(): String {
        return sampleService.getUserName()
    }
}