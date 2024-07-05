package com.eclatsol.dependdencyinjection.di.qualifiers

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier

class QualifiersMain @Inject constructor(
    @FName private val fName: String,
    @LName private val lName: String
) {
    fun getName() {
        Log.e("main", "Qualifiers : My name is $fName $lName")
    }
}

@Module
@InstallIn(SingletonComponent::class)
object QualifiersModule {

    @Provides
    @FName
    fun getFName() = "Jemis"

    @Provides
    @LName
    fun getLName() = "Virani"
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LName