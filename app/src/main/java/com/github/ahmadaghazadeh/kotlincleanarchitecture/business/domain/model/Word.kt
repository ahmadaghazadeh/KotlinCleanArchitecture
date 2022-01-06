package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Word(
    val id:String,
    val title:String,
    val text:String,
    val imageUrl:String,
    val createdAt: String
):Parcelable