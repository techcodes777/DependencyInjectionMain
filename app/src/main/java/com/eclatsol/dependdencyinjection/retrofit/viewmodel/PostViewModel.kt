package com.eclatsol.dependdencyinjection.retrofit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.eclatsol.dependdencyinjection.retrofit.model.Post
import com.eclatsol.dependdencyinjection.retrofit.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {
    //Je pan data fetch karavi shavi retrofit na through viewmodel poatani pase store karshe
    //PostViewModel ni dependency provide karavi padshe
    //ViewModel Basically external library che //Directly Inject nahi kari shakvi //Directly dependency provide nahi karavi shakishu

    //ViewModel external library che atle apne module create karvu padhe

    //ViewModel ni Dependency, module ni andar create karvani jarur nathi because by dafault apni pase ek anotation hoi che  @HiltViewModel name no annotation hoi che
//@ViewModelInject deprecated che
    //Je pan data apne flow through get karishu tene apne livedata ni andar convert karvu padshe

    //apno je flow che lifecycle aware nathi then mare tene livedata ni andar convert karvu pade che

    //Activity ma data ne use karvana shavi //Jevi apani activity behave karshe tevi j rite data pan behave karshe
    //Apani activity create thay data create thay jashe
    //Apani activity destroy thay che to data destroy thai jashe

    //Catch atle use karvi shavi apne data get karvi shavi exception throw karshe
    //Je pan data ave che tene live data ma covert karvu padshe tena use asLiveData
    val response: LiveData<List<Post>> = postRepository.getPost().catch { e ->
        Log.e("main", "${e.message}")
    }.asLiveData()
}