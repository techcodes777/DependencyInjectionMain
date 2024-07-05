package com.eclatsol.dependdencyinjection.retrofit.repository

import com.eclatsol.dependdencyinjection.retrofit.model.Post
import com.eclatsol.dependdencyinjection.retrofit.network.PostServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(private val postApiServiceImp: PostServiceImp){
    //PostServiceImplementation class ne apne postrepository class ma use karvi shavi
    //Je pan data fetch karavishu serverthi bakground ni andar je pan task hashe repository class ni andar hashe

    //Repository ni andar flow ne use karish
    //Flow ni series jovani che

    //Flow kam kare che je pan data server thi fetch karavishu je handle kare asynchronous Sequence wise data ne emit karave che
    //Je pan data fetch karavi shavi te flow na through karavi shavi bakground ni andar

    fun getPost() : Flow<List<Post>> = flow {
        val response = postApiServiceImp.getPost()
        emit(response) //Aa basically asynchronuse task che //asynchronous task ne apne background ni andar lavi shavi
        //Emit name nu function hashe je sequence wise data ne emit karavshe screen per
    }.flowOn(Dispatchers.IO)//Uper je process che asynchronous che mare task ne bakground ni andar perform karvo che


    //Uper je process che asynchronous che mare task ne bakground ni andar perform karvo che
    //asynchronous no matlab e che vadhare time le koi pan task ne perform karva mate
    //That is called asynchronous process
}