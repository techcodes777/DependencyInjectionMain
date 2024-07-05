package com.eclatsol.dependdencyinjection.di

import android.util.Log
import javax.inject.Inject

                                  //var ram = Ram() //var hardDisk = HardDisk() //constrcuter ni andar mene instance crate karlu che //Object automatically create thai jashe
class Computer @Inject constructor(private val ram : Ram,private val hardDisk: HardDisk){


    //Framework no use karvi shavi //Dagger hilt no use karvi shavi //Library-Dependency no use kari shavi

    fun getComputer(){
        ram.getRam()
        hardDisk.getHardDisk()
        Log.e("main", "getComputer: ")
    }
}

//val computer = Computer()  //Aa rite no object behind seen dagger hilt kari de che
//Dependency, Object ne crate karvi shavi tene apne external source ma provide karvi shavi

class Ram @Inject constructor(){

    fun getRam(){
        Log.e("main", "getRam: ")
    }
}

class HardDisk @Inject constructor(){

    fun getHardDisk(){
        Log.e("main", "getHardDisk: ")
    }
}