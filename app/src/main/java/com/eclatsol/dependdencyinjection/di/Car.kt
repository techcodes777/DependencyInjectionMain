package com.eclatsol.dependdencyinjection.di

import android.util.Log
import dagger.hilt.android.WithFragmentBindings

class Car constructor(private val engine: Engine,private val wheel: Wheel){

    //Manually Dependency Create
    fun getCar(){
        engine.getEngine()
        wheel.getWheel()
        Log.e("main", "Car is running..")
    }
}


class Engine {

    fun getEngine(){
        Log.e("main", "Engine Started")
    }

}

class Wheel{

    fun getWheel(){
        Log.e("main", "Wheel Started")
    }

}