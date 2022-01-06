package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.cache.implementation

import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.cache.abstraction.WordCacheDataSource
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.Word
import com.github.ahmadaghazadeh.kotlincleanarchitecture.framework.datasource.cache.abstraction.WordDaoService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WordCacheDataSourceImpl
@Inject
constructor(
    private val wordDaoService: WordDaoService
):WordCacheDataSource{
    override suspend fun insert(word: Word)=wordDaoService.insertWord(word)

    override suspend fun search(query: String, filterAndOrder: String, page: Int)= wordDaoService.searchWords(query,filterAndOrder,page)

    override suspend fun searchById(primaryKey: String) = wordDaoService.searchWordById(primaryKey)

    override suspend fun delete(primaryKey: String)= wordDaoService.deleteWord(primaryKey)
    override suspend fun delete(words: List<Word>)= wordDaoService.deleteWords(words)

    override suspend fun getAll()= wordDaoService.getAllWords()

    override suspend fun getNum()= wordDaoService.getNumWords()

}