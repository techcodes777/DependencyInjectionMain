package com.eclatsol.dependdencyinjection.retrofit.network

import com.eclatsol.dependdencyinjection.retrofit.model.Post
import javax.inject.Inject

class PostServiceImp @Inject constructor(private val postApiService: PostApiService){

    suspend fun getPost() : List<Post> = postApiService.getPost()
    //PostApiInterFace ma je pan hatu teni implementation provide karavi
    //suspend function matra suspend function ne call kare che //Normal function ne call kartu nathi
    //Interface ni dependency provide karava mate hu module create karish
}