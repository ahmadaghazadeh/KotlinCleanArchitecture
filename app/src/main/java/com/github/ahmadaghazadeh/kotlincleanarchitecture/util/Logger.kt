package com.github.ahmadaghazadeh.kotlincleanarchitecture.util

import android.util.Log
import com.github.ahmadaghazadeh.kotlincleanarchitecture.BuildConfig.DEBUG
import com.github.ahmadaghazadeh.kotlincleanarchitecture.util.Constants.TAG
import com.google.firebase.crashlytics.FirebaseCrashlytics

var isUnitTest = false

fun printLogD(className: String?, message: String ) {
    if (DEBUG && !isUnitTest) {
        Log.d(TAG, "$className: $message")
    }
    else if(DEBUG && isUnitTest){
        println("$className: $message")
    }
}

/*
    Priorities: Log.DEBUG, Log. etc....
 */
fun cLog(msg: String?){
    msg?.let {
        if(!DEBUG){
            FirebaseCrashlytics.getInstance().log(it)
        }
    }

}