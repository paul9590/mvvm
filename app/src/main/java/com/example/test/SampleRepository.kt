package com.example.test

class SampleRepository (
    private val sampleService: SampleService
) {
    suspend fun getUserName(): String {
        return sampleService.getUserName()
    }
}