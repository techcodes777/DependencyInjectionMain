package com.eclatsol.dependdencyinjection.di.interfaces

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

interface ProvidesInterface {
    fun provideMain()
}

class ProvideInterFaceImplementation @Inject constructor(private val name : String): ProvidesInterface {
    override fun provideMain() {
        Log.e("main", "Provide annotation is called")
    }
}

class MainProvide @Inject constructor(private val providesInterface: ProvidesInterface){
    fun getProvideInterface(){
        providesInterface.provideMain()
    }
}

@Module
@InstallIn(SingletonComponent::class)
class ModuleProvide{

    @Provides
    @Singleton
    fun getName() : String = "Jemis"
    @Provides
    @Singleton
    fun provideInterFace(name : String) : ProvidesInterface = ProvideInterFaceImplementation(name) //Provide function basically one line function
    //Syntax
    //[fun function nu name,Interface nu name je return kare che,= Implementation class no object]
    //By
    //By default dependency provides nahi kari shako apne module create karvu padshe
    //provideInterFace function interface ni dependency provides karave che

    //Dageer-hilt ne kai rite khbar pade che ke kaya interface ni dependency provides karavi shavi
    //To khabar pade che dagger-hilt ne provideInterFace function ma apeli interface ni return type

    //String basically external class che //In-built class che
    //Pote class create karvi shavi te che user define class @Inject anotation no use karine
}