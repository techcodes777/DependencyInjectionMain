package com.eclatsol.dependdencyinjection.retrofit.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("body")
    val body : String){

}