package com.example.downloadmanagermaterial3.download

interface Downloader {
    fun downloadFile(url: String): Long
}