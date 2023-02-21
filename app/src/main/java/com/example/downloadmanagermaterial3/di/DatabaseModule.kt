package com.example.downloadmanagermaterial3.di

import android.content.Context
import androidx.room.Room
import com.example.downloadmanagermaterial3.R
import com.example.downloadmanagermaterial3.database.ImageUrlDao
import com.example.downloadmanagermaterial3.database.ImageUrlRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object DatabaseModule {

    @Provides
    fun provideImageUrlDao(appDatabase: ImageUrlRoomDatabase): ImageUrlDao {
        return appDatabase.imageUrlDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): ImageUrlRoomDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ImageUrlRoomDatabase::class.java,
            "${context.getString(R.string.app_name)}.db"
        ).build()
    }

}