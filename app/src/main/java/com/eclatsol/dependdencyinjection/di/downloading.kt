package com.eclatsol.dependdencyinjection.di

import android.util.Log

/*
      HttpClient,
      Executor
      Request
      Download
 */

class downloading {
}

class HttpClient {

}

class Executor {

}

class Request constructor(private val httpClient: HttpClient, private val executor: Executor) {

    fun getRequest() {
        Log.e("main", "file downloading")
    }
}

class Download constructor(private val request: Request) {
    fun getDownload() {
        request.getRequest()
    }
}

object DownloaderFactory {
    fun create(): Download {  //This is external source //External Class
        val httpClient = HttpClient()
        val executor = Executor()
        val request = Request(httpClient, executor)
        return Download(request)
    }
}