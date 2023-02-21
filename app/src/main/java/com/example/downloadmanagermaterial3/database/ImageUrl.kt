package com.example.downloadmanagermaterial3.database

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "imageUrl")
data class ImageUrl(
    @ColumnInfo(name = "url")
    var imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    var id: Int = 0
) : Parcelable