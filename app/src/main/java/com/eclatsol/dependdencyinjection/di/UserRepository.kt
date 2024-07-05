package com.eclatsol.dependdencyinjection.di

import android.util.Log
import javax.inject.Inject

class UserRepository @Inject constructor(val loggerService: LoggerService){ //This is Constructor Injection
    fun saveUser(email : String,password : String){
        Log.e("main", "saveUser:  $email,$password")
        loggerService.loge("Hello World")
    }
}