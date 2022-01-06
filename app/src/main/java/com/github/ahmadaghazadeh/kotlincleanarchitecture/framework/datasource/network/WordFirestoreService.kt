package com.github.ahmadaghazadeh.kotlincleanarchitecture.framework.datasource.network

import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.Word

interface WordFirestoreService{
    suspend fun insertOrUpdate(word: Word)

    suspend fun insertOrUpdate(words: List<Word>)

    suspend fun delete(primaryKey: String)

    suspend fun search(word: Word)

    suspend fun getAll(): List<Word>
}