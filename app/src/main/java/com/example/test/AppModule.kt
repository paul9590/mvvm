package com.example.test

import com.example.data.SampleRepositoryImpl
import com.example.data.SampleService
import com.example.domain.SampleRepository
import com.example.domain.SampleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSampleService(): SampleService {
        return SampleService()
    }

    @Provides
    fun provideSampleRepository(sampleService: SampleService): SampleRepository {
        return SampleRepositoryImpl(sampleService)
    }

    @Provides
    fun provideSampleUseCase(sampleRepository: SampleRepository): SampleUseCase {
        return SampleUseCase(sampleRepository)
    }
}
