package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.interactors.wordlist

import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.cache.CacheResponseHandler
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.cache.abstraction.WordCacheDataSource
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.network.abstraction.WordNetworkDataSource
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.util.safeApiCall
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.util.safeCacheCall
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.Word
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.WordFactory
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.state.*
import com.github.ahmadaghazadeh.kotlincleanarchitecture.framework.presentation.wirdlist.state.WordListViewState
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class InsertNewWord(
    private val wordCacheDataSource: WordCacheDataSource,
    private val wordNetworkDataSource: WordNetworkDataSource,
    private val wordFactory: WordFactory
){
    fun insertNewWord(
         title:String,
         text:String,
         imageUrl:String,
         stateEvent: StateEvent
    ):Flow<DataState<WordListViewState>?> = flow{
        val newWord=wordFactory.createWord(title = title, text = text, imageUrl = imageUrl)

        val cacheResult= safeCacheCall(IO){
            wordCacheDataSource.insert(newWord)
        }

        val cacheResponse = object: CacheResponseHandler<WordListViewState, Long>(
            response = cacheResult,
            stateEvent = stateEvent
        ){
            override suspend fun handleSuccess(resultObj: Long): DataState<WordListViewState>? {
                return if(resultObj > 0){
                    val viewState =
                        WordListViewState(
                            newWord = newWord
                        )
                    DataState.data(
                        response = Response(
                            message = INSERT_WORD_SUCCESS,
                            uiComponentType = UIComponentType.Toast(),
                            messageType = MessageType.Success()
                        ),
                        data = viewState,
                        stateEvent = stateEvent
                    )
                }
                else{
                    DataState.data(
                        response = Response(
                            message = INSERT_WORD_FAILED,
                            uiComponentType = UIComponentType.Toast(),
                            messageType = MessageType.Error()
                        ),
                        data = null,
                        stateEvent = stateEvent
                    )
                }
            }
        }.getResult()

        emit(cacheResponse)

        updateNetwork(cacheResponse?.stateMessage?.response?.message,newWord)
    }

    private suspend fun updateNetwork(cacheResponse: String?, newWord: Word) {
        if(cacheResponse.equals(INSERT_WORD_SUCCESS)){
            safeApiCall(IO){
                wordNetworkDataSource.insertOrUpdate(newWord)
            }
        }
    }

    companion object{
        const val INSERT_WORD_SUCCESS="Successfully inserted new word"
        const val INSERT_WORD_FAILED="Successfully inserted new word"
    }
}