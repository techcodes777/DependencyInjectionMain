package com.eclatsol.dependdencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.eclatsol.dependdencyinjection.di.Computer
import com.eclatsol.dependdencyinjection.di.QualifiersTwo
import com.eclatsol.dependdencyinjection.di.Test
import com.eclatsol.dependdencyinjection.di.carmanufacture.CarManufacture
import com.eclatsol.dependdencyinjection.di.interfaces.MainDemo
import com.eclatsol.dependdencyinjection.di.interfaces.MainOne
import com.eclatsol.dependdencyinjection.di.interfaces.Person
import com.eclatsol.dependdencyinjection.di.interfaces.UserRepositoryInterFace
import com.eclatsol.dependdencyinjection.di.qualifiers.QualifiersMain
import com.eclatsol.dependdencyinjection.retrofit.container.BaseApp
import com.eclatsol.dependdencyinjection.retrofit.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //Manually Dependency Injection
//    private lateinit var baseApp: BaseApp
//    private val download  = DownloaderFactory.create()

    @Inject
    lateinit var computer: Computer //Constructor Invokation ni jarur batji Object Define Karvani jarur nathi automatically create kari de di(DagerHilt)

    @Inject
    lateinit var mainOne: MainOne //mainone ni dependency pele thi provide kareli che to apne object create nahi karishu

    @Inject
    lateinit var test: Test

    @Inject
    lateinit var qualifiersTwo: QualifiersTwo

    @Inject
    lateinit var person: Person

    @Inject
    lateinit var carManufacture: CarManufacture

    @Inject
    lateinit var mainDemo : MainDemo

    @Inject
    lateinit var qualifiersMain: QualifiersMain

//    @Inject
//    lateinit var userRepositoryInterFace: UserRepositoryInterFace // Tame use nahi kari shako kem ke fragment component sudhi valid che compile time error apshe

    private val postViewModel : PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        userRepositoryInterFace.saveUser("Hello","5")

        //LiveData ne observe karshe
        postViewModel.response.observe(this, Observer {response->
            Log.e("main", "${response[0].body}")
        })

        computer.getComputer()
        mainOne.demoOne()
        person.getPerson()
        carManufacture.getCar()
        mainDemo.getName()
        qualifiersMain.getName()

        //Manual Dependency Create kari dithi
//        baseApp = BaseApp() //This is external source //External Class
//        baseApp.car.getCar()
//        download.getDownload()

        // Main(ImplementOne()).main() //DI no use karelo nathi //Tame directly pass kaelu//Di ma another source per depend rahe che
        //ImplementOne Name no class te pass karvo pade kem ke interface object create nathi kartu
        //Interface ni implementation class ma karvi shavi
        //ImplementOne parent class che //Child Interface che child ne problem ave to parent handel kare che
        BaseApp().main.main()
        test.getNames()
        qualifiersTwo.getData()

        //@Provides
        //Module container hoi che//Code apdo nathi own anthi karta teni depedency provide karavi shavi
        //Interface ni dependency provide karave cehe

        //Module crate karva mate class create karo,object create karo //Companion object pan create kari shako shavo

        //@ApplicationComponent laku ne to te akhi application ma valid rahe che
        //ActivityComponent laku to single activity mate manage rahshe  
    }

    companion object{
        val FName = "Jemis"
        val LName = "Virani"
    }

    //Dagger Hilt //Anotation
    //Class = @Inject

    //Interface = @Module,@Binds,@Provides

    //@InstallIn(SingletonComponent::class)

    //External DI = @Modules,@Provides

    //Class
    //Class mate dependency provide karvi hoi to @Inject anotation no use karvo pade che

    //Interface
    //Interface constructor contains nathi kartu tena mate pela module create karvi shavi tema apne @Binds,@Provide anotation no use karvi shavi
    //Bind ni sathe apne Module ne use kari shavi to abstract class create karvo pade
    //@InstallIn(SingletonComponent::class) no matlab e che ke module ne hu akhi app ma use kari shaku shu
    //Module ni je pan dependency hashe tene hu akhi app ma use kari shakish
    //@Singleton anotation no matlab e che ke depedency provide karavo shavo tenu ek single instance create thashe
    //@Singleton anotation ne jo remove kari desho ne to signletone nahi bane dar vakte object create karshe
    //@Bind anotation na through tame dependency provide karavo shavo to module ne abstract function ne pan abstract karvu pashe
    //With the help of bind anotation
    //Provide anotation na through dependency provide karavu shavu interface ni
    //Provide anotation ma abstract class and abstract function ni jarur padti nathi
    //Object ,Simple class create kari shakvi ,Companion object create kari shakvi

    //@Module
    //@InstallIn(SingletonComponent::class)
    //Class ni uper avshe

    //Class ni andar avshe
    //@Provides
    //@Singleton anotation

    //AppModule automatically potani rite call thay jashe base app ma Base app ni andar potani reate create thay che

    //Most of cases ma bind anotation ne use karvi shavi //Behind the seen less code generate kare che
    //Provide anotation ma behind the seen vadhare code generate kare che
    //Provide anotation external dependency mate hoi che Retrofit,RoomDataBase,FireBase//Other source ni dependency hoi che

    //Apni pase ghana component hoi che activity component // fragment component che

    //External DI
    //External dependency injection no matlab e thay ke retrofit ni dependency provide karvi che //RoomDataBase ni dependency provide karvi che
    //Modules create karvu padshe //Provide name na anotation through dependency perform kari shakvi


    //Cheezy Code
    //Apani pase interface,abstract class ,Third Party Classes che tene apne use kari shakvi tenu access apni pase nathi
    //Third party classes che tano hu object create kari shaku shu tema hu chnages kari shaqkto nathi
    //Data store karavon che firebase,Third party service ma store karavu che tena mate interface define karvi shavi
    //Db ma store karvu che SqlRepository no use
    //Firebase ma store karvu che to firebase repository no use kari shakvi
    //Retrofit,Database no object che to application ma bade valid hoi to singleton component ne use karish
    //Activity mate component. Fragment mate component che
    //Different level na component che vadhare dependency provide karave che
    //Hilt ni pase Bag of object che  - component che
    //Je pan level ni dependency hashe te component per jashu tena through object ne access kari shaku


    //Application andar activity , activity ni andar fragment che aa rite apni pase component nu structure hoi che
    //Module e batave che particular dependency ne kevi rite create kari shakvi
    //Module ne component ni sathe jodi devanu
    //Aa module che to te application component ni sathe kam karshe
    //Aa Module che te activity component ni sathe kam karshe
    //Aa Module che te fragment component ni sathe kam karshe
    //Te dependency che teno  area(Scope) che fragment ni andar che
    //Teno scope fragment ma che to fragment componet use kari installIn Annotation ni andar
    //RoomDatabase,Retrofit no object hoi to singleton component no use karish //Application leve per install thase
}