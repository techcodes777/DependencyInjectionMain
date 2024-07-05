package com.eclatsol.dependdencyinjection.retrofit.network

import com.eclatsol.dependdencyinjection.retrofit.model.Post
import retrofit2.http.GET

interface PostApiService {

    @GET("posts")
    suspend fun getPost() : List<Post> //As basically suspend function kahvay che //Je pan data ave che bakground ni andar work perform kare //Array che atle te list return kare che
    //Have ek class banavishu je interface ni andar getPost function ne implementation devanu kam karshe
    //getPost function ni definition provide karavi padshe te class provide karavshe
}