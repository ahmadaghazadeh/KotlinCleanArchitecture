package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model

import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.util.DateUtil
import java.util.*
import javax.inject.Singleton

@Singleton
class WordFactory
constructor(private val dateUtil:DateUtil){

    fun createWord(title:String,
                    text:String,
                    imageUrl:String ):Word{

        return Word(id= UUID.randomUUID().toString(),
        title=title,
        text = text,
        imageUrl = imageUrl,
        createdAt = dateUtil.getCurrentTimestamp())
    }
}
