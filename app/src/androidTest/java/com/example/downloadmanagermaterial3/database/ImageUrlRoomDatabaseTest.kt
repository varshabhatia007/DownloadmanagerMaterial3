package com.example.downloadmanagermaterial3.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ImageUrlRoomDatabaseTest : TestCase() {
    private lateinit var db: ImageUrlRoomDatabase
    private lateinit var dao: ImageUrlDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, ImageUrlRoomDatabase::class.java).build()
        dao = db.imageUrlDao()
    }

    @Test
    fun writeAndReadImageUrlData() = runBlocking {
        val imageUrlData = ImageUrl("https://url.com", 1)
        dao.addImageUrl(imageUrlData)
        val imageUrlAllData = dao.getAllImageUrls()
        assertTrue(imageUrlAllData.contains(imageUrlData))
    }

    @After
    fun closeDb() {
        db.close()
    }
}