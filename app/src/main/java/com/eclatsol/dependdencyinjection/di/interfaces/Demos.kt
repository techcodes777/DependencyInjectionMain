package com.eclatsol.dependdencyinjection.di.interfaces

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


interface DemoOne{
    fun demoOne()
}

class DemoImplementationOne @Inject constructor(): DemoOne{
    override fun demoOne() {
        Log.e("main", "demoOne is calling..")
    }
}

class MainOne @Inject constructor(private val  demoOne: DemoOne){
    fun demoOne(){
        demoOne.demoOne()
    }
}

//Interface nu app module potani rite automatically call thay jashe baseapp ma
@Module //Module anotation no use thay che module create karva
@InstallIn(SingletonComponent::class) //Installin no akhi app ma appmodule ne use kari shako
abstract class AppModule1{

    @Binds //Dependency provide karava mate
    @Singleton  //Singleton no use karvathi ek var object create thay che jo tene remove kari do darek vakhte object create kare che
    abstract fun providesOne(demoImplementationOne: DemoImplementationOne) : DemoOne

}