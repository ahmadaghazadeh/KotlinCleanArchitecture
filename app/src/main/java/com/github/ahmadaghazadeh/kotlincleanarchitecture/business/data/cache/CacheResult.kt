package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.data.cache

sealed class CacheResult <out T>{
    data class Success<out T>(val value :T) :CacheResult<T>()

    data class GenericError(val errorMessage:String?=null):CacheResult<Nothing>()
}