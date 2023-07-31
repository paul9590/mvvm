package com.example.test

class SampleRepository constructor(
    private val sampleService: SampleService
) {
    suspend fun getUserName(): String {
        return sampleService.getUserName()
    }
}