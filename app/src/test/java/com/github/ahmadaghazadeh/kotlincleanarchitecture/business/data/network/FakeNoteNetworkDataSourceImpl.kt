package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.network

import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.network.abstraction.WordNetworkDataSource
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.Word
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.util.DateUtil

class FakeNoteNetworkDataSourceImpl
constructor(
    private val wordsData: HashMap<String, Word>,
    private val dateUtil: DateUtil
) : WordNetworkDataSource {

    override suspend fun insertOrUpdate(word: Word) {
        wordsData.put(word.id, word)
    }

    override suspend fun delete(primaryKey: String) {
        wordsData.remove(primaryKey)
    }


    override suspend fun search(word: Word): Word? {
        return wordsData.get(word.id)
    }

    override suspend fun getAll(): List<Word> {
        return ArrayList(wordsData.values)
    }

    override suspend fun insertOrUpdate(words: List<Word>) {
        for(word in words){
            wordsData.put(word.id, word)
        }
    }
}