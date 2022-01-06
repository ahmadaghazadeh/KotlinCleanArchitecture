package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.network.abstraction

import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.Word

interface WordNetworkDataSource {
    suspend fun insertOrUpdate(word: Word)

    suspend fun insertOrUpdate(words: List<Word>)

    suspend fun delete(primaryKey: String)

    suspend fun search(word: Word):Word?

    suspend fun getAll(): List<Word>

}