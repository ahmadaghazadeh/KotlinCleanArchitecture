package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.cache.abstraction

import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.Word

interface WordCacheDataSource {

    suspend fun insert(word: Word):Long

    suspend fun search(query:String,
                       filterAndOrder:String,
                       page:Int):List<Word>

    suspend fun searchById(primaryKey: String):Word?

    suspend fun delete(primaryKey: String):Int

    suspend fun delete(words: List<Word>):Int

    suspend fun getAll():List<Word>

    suspend fun getNum():Int

}