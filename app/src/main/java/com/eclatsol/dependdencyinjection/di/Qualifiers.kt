package com.eclatsol.dependdencyinjection.di

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.eclatsol.dependdencyinjection.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier

//Test class ni andar as a parameter fname and lname apsss karu shu //Bane string che
//Bane String Class che Dependency provide karavi padshe
//Bane string ni Dependency prvide karava jashu ne to dagger hilt confuse thai jashe
//String ni depedpemcy provide karavi padshe
//String external class che apne to create nathi karo class //External class che to provide anotation no use thay che
//Module create karvu padshe tya aa bane depdency provide karavi shakvi with the help of provide anotation

//Dagger ni pase by deafult Qualifires hoi che //Two Qualifiers hoi che dagger pase
//First : ActivityContext
//Second : ApplicationContext
//Context dependency provide karavi che to module na java anoatatin ne call kari do
//ActivityContext no matlab activity sudhi valid che
//ApplicationContext no matlab akhi app ma context no use kari shakvi

//RoomData,Retrofit,FireBase ma different different implement mate Qualifiers no use karvo padshe
class Test @Inject constructor(
    @FName val fName: String,
    @LName val lName: String,
    @ActivityContext
    val context: Context //ActivityContext no matlab activity(MainActivity,Other Activity) sudhi valid che
) { //Different tag  atle pass karela comiplle time error no ave

    fun getNames() {
        Log.e("main", "$fName ,$lName")
        Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object Modules {

    @Provides
    @FName
    fun providesFName() = MainActivity.FName
    //fun providesFName() = "Jemis" //Compile value assign karavi
    //Bane Function String ne return kare che //Jyare hu run karish hilt compiletime error
    //Tame Bane function ni andar string return karavo shavo Tame em nahi kari shako
    //Different different implementation provide karavu padshe
    //Tena mate Qualifires no use karvo pade che
    //Qualifire bane different tage provide karave che Unique name provide karave che
    //Hilt identify kari le che firstname kayu che lastname kayu che
    //Qualifiers create karva mate anotation class lakvu padshe
    @Provides
    @LName  //Aa rite Qualifiers ne tame use kari shako shavo //Different Difeerent tage mali gaya che
    fun provideLName() = MainActivity.LName //Runtime per value assign karishako
//    fun provideLName() = "Virani" //Compile value assign karavi
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LName //Qualifiers create kari dithu

//Same class ni different different implementation provide karavi padshe
class Qualifiers {

}