package com.example.downloadmanagermaterial3.repository

import androidx.lifecycle.MutableLiveData
import com.example.downloadmanagermaterial3.database.ImageUrl
import com.example.downloadmanagermaterial3.database.ImageUrlDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageUrlRepository(private val imageUrlDao: ImageUrlDao) {

    val allImageUrls = MutableLiveData<List<ImageUrl>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addImageUrl(newImageUrl: ImageUrl) {
        coroutineScope.launch(Dispatchers.IO) {
            imageUrlDao.addImageUrl(newImageUrl)
        }
    }

    fun getAllImageUrls() {
        coroutineScope.launch(Dispatchers.IO) {
            allImageUrls.postValue(imageUrlDao.getAllImageUrls())
        }
    }
}