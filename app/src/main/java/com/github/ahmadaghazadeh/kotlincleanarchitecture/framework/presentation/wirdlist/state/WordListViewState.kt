package com.github.ahmadaghazadeh.kotlincleanarchitecture.framework.presentation.wirdlist.state

import android.os.Parcelable
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.model.Word
import com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.state.ViewState
import kotlinx.parcelize.Parcelize

@Parcelize
data class WordListViewState(

    var wordList: ArrayList<Word>? = null,
    var newWord: Word? = null, // word that can be created with fab
    var searchQuery: String? = null,
    var page: Int? = null,
    var isQueryExhausted: Boolean? = null,
    var filter: String? = null,
    var order: String? = null,
    var layoutManagerState: Parcelable? = null,
    var numWordsInCache: Int? = null

) : Parcelable, ViewState {

    @Parcelize
    data class WordPendingDelete(
        var word: Word? = null,
        var listPosition: Int? = null
    ) : Parcelable
}