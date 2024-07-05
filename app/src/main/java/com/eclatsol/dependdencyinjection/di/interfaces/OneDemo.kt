package com.eclatsol.dependdencyinjection.di.interfaces

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


interface OneDemo {
    fun getOneDemo()
}

class DemoOneImplementation @Inject constructor() : OneDemo {
    override fun getOneDemo() {
        Log.e("main", "My Name is Jemis")
    }
}

class MainDemo @Inject constructor(private val oneDemo: OneDemo) {
    fun getName() {
        oneDemo.getOneDemo()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class ModuleDemoOne{

   @Binds
   @Singleton  //Singleton ek scope che //Scope ghana type na hoi che //Activity Scope thai gayu
   abstract fun providesData(demoOneImplementation: DemoOneImplementation) : OneDemo

}