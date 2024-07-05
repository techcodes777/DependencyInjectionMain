package com.eclatsol.dependdencyinjection.retrofit.container

import android.app.Application
import com.eclatsol.dependdencyinjection.di.Car
import com.eclatsol.dependdencyinjection.di.Engine
import com.eclatsol.dependdencyinjection.di.UserRepository
import com.eclatsol.dependdencyinjection.di.Wheel
import com.eclatsol.dependdencyinjection.di.interfaces.AppModule
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

//Dagger hit container banava mate anotation no use karvo pade che
//Container jetli pan dependency(object) hashe te apni pase rakhshe

@HiltAndroidApp
class BaseApp : Application() { //External Source

    //Manually Dependency Injection
    var car = Car(Engine(), Wheel()) //Intance ne direct create karta nathi external class ni andar create karvi shavi then pasi te class(Activity)ma provide kare che


    //FrameWork DaggerHilt //Dependency //Library che
    //val computer = Computer() //Behind the seen object create kari ne ape che

    //val computer = Computer()
    // java.lang.StackOverflowError: stack size 8MB Problem aa error tyare ave che jyare be var object create thata hoi framework

    //Interface ma baseapp per depend nathi revu padtu  //Tena mate module create karvi shavi then moduel depend karvi shavi baseapp ma
    val main = AppModule.main

    //Interface nu app module potani rite automatically call thay jashe baseapp ma

    @Inject //This is Filed Injection //Filed Define kari che
    lateinit var userRepository: UserRepository  //Class ma pan use kari shako
    override fun onCreate() {
        super.onCreate()
        userRepository.saveUser("hello@gmail.com","123456")
    }
}

//Dependency,Object provide karavi shavi te base app ni pase hoi che