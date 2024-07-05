package com.eclatsol.dependdencyinjection.di.carmanufacture

import android.util.Log
import javax.inject.Inject

class CarManufacture @Inject constructor(private val engine: Engine,private val wheel: Wheel) { //Constructor Injection kari dithu

    fun getCar(){
        Log.e("main", "Car is running")
        engine.getEngine()
        wheel.getWheel()  //Onject Create nathi karvo padto //Dagger hilt Automatically create kari de che
    }
}