package com.eclatsol.dependdencyinjection.di.carmanufacture

import android.util.Log
import javax.inject.Inject

class Engine @Inject constructor(){

    fun getEngine(){
        Log.e("main", "Engine is started")
    }
}