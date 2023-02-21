package com.example.downloadmanagermaterial3.di

import com.example.downloadmanagermaterial3.database.ImageUrlDao
import com.example.downloadmanagermaterial3.repository.ImageUrlRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideImageUrlRepository(imageUrlDao: ImageUrlDao): ImageUrlRepository {
        return ImageUrlRepository(imageUrlDao)
    }

}