package com.eclatsol.dependdencyinjection.di

import android.util.Log
import javax.inject.Inject

class LoggerService @Inject constructor(){
    fun loge(message : String){
        Log.e("main", "loge: $message")
    }
}