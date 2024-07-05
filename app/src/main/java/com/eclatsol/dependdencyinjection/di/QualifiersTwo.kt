package com.eclatsol.dependdencyinjection.di

import android.content.Context
import android.util.Log
import android.widget.Toast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier

class QualifiersTwo @Inject constructor(
    @FNames private val firstName: String,
    @LNames private val lastName: String,
    @ActivityContext private val context: Context
) {
    fun getData() {
        Log.e("main", "Qualifiers is running")
        Log.e("main", "getData: $firstName,$lastName")
        Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object AppModuleQualifiers {

    @Provides
    @FNames
    fun providesFName() = "Jemis" //Compile time per value assign thay che

    @Provides
    @LNames
    fun provideLName() = "Virani"  //Runtime per value assign thay che

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FNames

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LNames


