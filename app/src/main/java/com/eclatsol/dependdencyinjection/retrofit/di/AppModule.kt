package com.eclatsol.dependdencyinjection.retrofit.di

import com.eclatsol.dependdencyinjection.retrofit.network.PostApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    //Base url ni dependency provide karavi padshe
    //Retrofit builder ni dependency provide karavi padshe
    //PostApiService Interface ni depedency provide karavi padhe

//    fun getBaseUrl() : String = ""

    @Provides
    @Singleton //Ek var object create kare che //Application ma badhi jagyaye available che
    fun provideRetrofitBuilder(): Retrofit =
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create())
            .build()

    //GsonConverterFactory ni jagyaye tame moshi no pan use kari shako shavo

    @Provides
    fun providesPostService(retrofit: Retrofit) : PostApiService = retrofit.create(PostApiService::class.java)
    //Retrofit dependency atle provide kari me postService ne use kari shaku
    //Daggerhilt hamesha return type check kare che
}