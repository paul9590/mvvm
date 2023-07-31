package com.example.test

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
        return SampleRepository(sampleService)
    }

    @Provides
    fun provideSampleUseCase(sampleRepository: SampleRepository): SampleUseCase {
        return SampleUseCase(sampleRepository)
    }
}
