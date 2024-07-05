package com.eclatsol.dependdencyinjection.di.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eclatsol.dependdencyinjection.R
import com.eclatsol.dependdencyinjection.di.UserRepository
import com.eclatsol.dependdencyinjection.di.annotation.FireBaseQualifiers
import com.eclatsol.dependdencyinjection.di.interfaces.UserRepositoryInterFace
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainFragment : Fragment() {

    //Fragment ma pan AndroidEntryPoint annotation no use karvo pade
    //MainActivity ma pan AndroidEntryPoint annotation lagavu pade tame activity ma inject use nathi karta to pan
    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    //@Named("firebase") //Missing binding ni error avshe ama
    @FireBaseQualifiers
    lateinit var userRepositoryInterFace: UserRepositoryInterFace

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        userRepository.saveUser("fragment@gmail.com","123456")
        userRepositoryInterFace.saveUser("userinterface@gmail.com","12345678")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}