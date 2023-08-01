package com.example.domain

interface SampleRepository {
    suspend fun getUserName(): String
}