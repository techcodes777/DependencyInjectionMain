package com.eclatsol.dependdencyinjection.di.interfaces

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


interface DemoTwo {
    fun demoTwo()
}

class DemoTwoImplementation @Inject constructor(): DemoTwo {
    override fun demoTwo() {
        Log.e("main", "demoTwo is Running")
    }
}

class MainTwo @Inject constructor(private val demoTwo: DemoTwo){
     fun mainTwo(){
         demoTwo.demoTwo()
     }
}

//Jyare provide anoatation no use karvi to abstract class and abstract function ni jarur nathi hoti simple class object class Companion object

//Interface nu app module potani rite automatically call thay jashe baseapp ma //Base app ma object create karvani jarur nathi
@Module
@InstallIn(SingletonComponent::class)
object AppModule2 {
    @Provides
    @Singleton fun providesDemoTwo() : DemoTwo = DemoTwoImplementation()
}
