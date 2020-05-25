package com.example.makefriendandroid.service

import com.example.makefriendandroid.model.Login
import com.example.makefriendandroid.model.RegistrationForm
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.GET

interface AuthService {
    @POST("auth/login")
    fun login(@Body login: Login): Call<Boolean>
    @POST("auth/register")
    fun register(@Body register:RegistrationForm):Call<Boolean>
}