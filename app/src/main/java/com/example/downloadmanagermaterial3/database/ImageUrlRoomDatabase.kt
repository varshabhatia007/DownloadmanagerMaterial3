package com.example.downloadmanagermaterial3.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(ImageUrl::class)], version = 1, exportSchema = false)
abstract class ImageUrlRoomDatabase : RoomDatabase() {

    abstract fun imageUrlDao(): ImageUrlDao

    companion object {
        @Volatile
        private var INSTANCE: ImageUrlRoomDatabase? = null

        fun getInstance(context: Context): ImageUrlRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ImageUrlRoomDatabase::class.java,
                        "imageUrl_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}