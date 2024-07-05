package com.eclatsol.dependdencyinjection.di.carmanufacture

import android.util.Log
import javax.inject.Inject

class Wheel @Inject constructor(){


    fun getWheel(){
        Log.e("main", "Wheel is started")
    }
}