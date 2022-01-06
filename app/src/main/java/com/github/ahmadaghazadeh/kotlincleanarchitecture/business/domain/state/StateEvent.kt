package com.github.ahmadaghazadeh.kotlincleanarchitecture.business.domain.state

interface StateEvent {

    fun errorInfo(): String

    fun eventName(): String

    fun shouldDisplayProgressBar(): Boolean
}