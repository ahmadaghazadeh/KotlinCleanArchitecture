package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.network.implementation

import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.network.abstraction.WordNetworkDataSource
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.Word
import com.github.ahmadaghazadeh.kotlincleanarchitecture.framework.datasource.network.WordFirestoreService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WordNetworkDataSourceImpl

@Inject
constructor(private  val  wordFirestoreService: WordFirestoreService): WordNetworkDataSource {
    override suspend fun insertOrUpdate(word: Word)=wordFirestoreService.insertOrUpdate(word)

    override suspend fun insertOrUpdate(words: List<Word>) =wordFirestoreService.insertOrUpdate(words)

    override suspend fun delete(primaryKey: String) =wordFirestoreService.delete(primaryKey)

    override suspend fun search(word: Word) =wordFirestoreService.search(word)

    override suspend fun getAll() =wordFirestoreService.getAll()

}

