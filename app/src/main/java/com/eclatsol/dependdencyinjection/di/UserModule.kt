package com.eclatsol.dependdencyinjection.di

import com.eclatsol.dependdencyinjection.di.annotation.FireBaseQualifiers
import com.eclatsol.dependdencyinjection.di.interfaces.FireBaseRepository
import com.eclatsol.dependdencyinjection.di.interfaces.SqlRepository
import com.eclatsol.dependdencyinjection.di.interfaces.UserRepositoryInterFace
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
class UserModule {


    //@Named("firebase") //Missing binding error avi shake name ma bhul kari to firebase ni jagyaye firebases kari dithi //Default annotation che
    @FireBaseQualifiers
    @Provides
    fun providesUserRepository() : UserRepositoryInterFace{
        return FireBaseRepository()
    }

    @Named("sql")
    @Provides
    fun provideUserSqlRepository(sqlRepository: SqlRepository) : UserRepositoryInterFace{
        return sqlRepository
    }

//    @Binds
//    abstract fun bindUserRepository(sqlRepository: SqlRepository) : UserRepositoryInterFace
    //Bind annotation use karvi to apne abstract keyword no use karvo pade

    //Logic execute nathi thatu abstract function ma

    //Multiple implementation che tya same type na qualifiers no use thay che name qualifiers,custom qualifiers
}