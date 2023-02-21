package com.example.downloadmanagermaterial3.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

@Dao
interface ImageUrlDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addImageUrl(imageUrl: ImageUrl)

    @Query("SELECT * FROM imageUrl")
    fun getAllImageUrls(): List<ImageUrl>
}