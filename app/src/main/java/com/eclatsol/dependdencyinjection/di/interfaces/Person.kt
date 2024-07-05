package com.eclatsol.dependdencyinjection.di.interfaces

import android.util.Log
import javax.inject.Inject

class Person @Inject constructor(){

    fun getPerson(){
        Log.e("main", "getPerson: ")
    }

}