package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.cache.abstraction

import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.Word

interface WordCacheDataSource {

    suspend fun insertWord(word: Word):Long

    suspend fun searchWords(query:String,
    filterAndOrder:String,
    page:Int):List<Word>

    suspend fun searchWordById(primaryKey: String):Word?

}