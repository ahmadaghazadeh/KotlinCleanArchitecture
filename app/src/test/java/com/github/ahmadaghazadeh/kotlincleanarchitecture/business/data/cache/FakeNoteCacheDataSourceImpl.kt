package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.cache

import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.cache.abstraction.WordCacheDataSource
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.Word
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.util.DateUtil
import com.github.ahmadaghazadeh.kotlincleanarchitecture.framework.datasource.database.WORD_PAGINATION_PAGE_SIZE

const val FORCE_DELETE_WORD_EXCEPTION = "FORCE_DELETE_Word_EXCEPTION"
const val FORCE_DELETES_WORD_EXCEPTION = "FORCE_DELETES_Word_EXCEPTION"
const val FORCE_UPDATE_WORD_EXCEPTION = "FORCE_UPDATE_Word_EXCEPTION"
const val FORCE_NEW_Word_EXCEPTION = "FORCE_NEW_Word_EXCEPTION"
const val FORCE_SEARCH_WORDS_EXCEPTION = "FORCE_SEARCH_WordS_EXCEPTION"
const val FORCE_GENERAL_FAILURE = "FORCE_GENERAL_FAILURE"

class FakeWordCacheDataSourceImpl
constructor(
    private val wordsData: HashMap<String, Word>,
    private val dateUtil: DateUtil
): WordCacheDataSource {

    override suspend fun insert(word: Word): Long {
        if(word.id.equals(FORCE_NEW_Word_EXCEPTION)){
            throw Exception("Something went wrong inserting the Word.")
        }
        if(word.id.equals(FORCE_GENERAL_FAILURE)){
            return -1 // fail
        }
        wordsData.put(word.id, word)
        return 1 // success
    }

    override suspend fun search(query: String, filterAndOrder: String, page: Int): List<Word> {
        if(query.equals(FORCE_SEARCH_WORDS_EXCEPTION)){
            throw Exception("Something went searching the cache for notes.")
        }
        val results: ArrayList<Word> = ArrayList()
        for(word in wordsData.values){
            if(word.title.contains(query)){
                results.add(word)
            }
            else if(word.text.contains(query)){
                results.add(word)
            }
            if(results.size > (page * WORD_PAGINATION_PAGE_SIZE)){
                break
            }
        }
        return results
    }

    override suspend fun searchById(primaryKey: String): Word? {
        return wordsData.get(primaryKey)
    }

    override suspend fun delete(primaryKey: String): Int {
        if(primaryKey.equals(FORCE_DELETE_WORD_EXCEPTION)){
            throw Exception("Something went wrong deleting the note.")
        }
        else if(primaryKey.equals(FORCE_DELETES_WORD_EXCEPTION)){
            throw Exception("Something went wrong deleting the note.")
        }
        return wordsData.remove(primaryKey)?.let {
            1 // return 1 for success
        }?: - 1 // -1 for failure
    }

    override suspend fun delete(words: List<Word>): Int {
        var failOrSuccess = 1
        for(note in words){
            if(wordsData.remove(note.id) == null){
                failOrSuccess = -1 // mark for failure
            }
        }
        return failOrSuccess
    }

    override suspend fun getAll(): List<Word> {
        return ArrayList(wordsData.values)
    }

    override suspend fun getNum(): Int {
        return wordsData.size
    }
}