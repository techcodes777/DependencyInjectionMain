package com.eclatsol.dependdencyinjection.di.interfaces

import android.util.Log
import javax.inject.Inject

interface UserRepositoryInterFace {
    fun saveUser(email: String, password: String)
}

class SqlRepository @Inject constructor() : UserRepositoryInterFace {
    override fun saveUser(email: String, password: String) {
        Log.e("main", "User save in Db $email,$password")
    }
}

class FireBaseRepository  : UserRepositoryInterFace {
    override fun saveUser(email: String, password: String) {
        Log.e("main", "User save in FireBase: $email,$password")
    }

    //Binds Annotation vala function abstract hoi che implementation ni jarur nathi
}