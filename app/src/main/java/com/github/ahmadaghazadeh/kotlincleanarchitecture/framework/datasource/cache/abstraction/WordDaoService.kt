package com.github.ahmadaghazadeh.kotlincleanarchitecture.framework.datasource.cache.abstraction

import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.Word
import com.github.ahmadaghazadeh.kotlincleanarchitecture.framework.datasource.database.WORD_PAGINATION_PAGE_SIZE

interface WordDaoService {
    suspend fun insertWord(word: Word):Long

    suspend fun searchWords(query:String,
                            filterAndOrder:String,
                            page:Int):List<Word>


    suspend fun deleteWord(
        primaryKey: String
    ):Int

    suspend fun deleteWords(
        words: List<Word>
    ):Int

    suspend fun getAllWords():List<Word>

    suspend fun getNumWords():Int


    suspend fun searchWordOrderByDateDESC(
        query: String,
        page: Int,
        pageSize:Int=WORD_PAGINATION_PAGE_SIZE
    ):List<Word>

    suspend fun searchWordOrderByDateASC(
        query: String,
        page: Int,
        pageSize:Int=WORD_PAGINATION_PAGE_SIZE
    ):List<Word>


    suspend fun searchWordOrderByTitleDESC(
        query: String,
        page: Int,
        pageSize:Int=WORD_PAGINATION_PAGE_SIZE
    ):List<Word>

    suspend fun searchWordOrderByTitleASC(
        query: String,
        page: Int,
        pageSize:Int=WORD_PAGINATION_PAGE_SIZE
    ):List<Word>

    suspend fun searchWordById(primaryKey: String): Word?

    suspend fun returnOrderedQuery(
        query: String,
        filterAndOrder: String,
        page: Int
    ):List<Word>
}