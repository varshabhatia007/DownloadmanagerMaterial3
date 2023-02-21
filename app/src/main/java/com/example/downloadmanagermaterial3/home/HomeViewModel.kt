package com.example.downloadmanagermaterial3.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.downloadmanagermaterial3.database.ImageUrl
import com.example.downloadmanagermaterial3.repository.ImageUrlRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val imageUrlRepository: ImageUrlRepository) :
    ViewModel() {

    val imageUrlList: LiveData<List<ImageUrl>> = imageUrlRepository.allImageUrls

    fun getAllImageUrls() {
        imageUrlRepository.getAllImageUrls()
    }

    fun addImageUrl(imageUrl: ImageUrl) {
        imageUrlRepository.addImageUrl(imageUrl)
        getAllImageUrls()
    }
}