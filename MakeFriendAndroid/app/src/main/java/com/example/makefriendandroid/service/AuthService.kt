package com.example.makefriendandroid.service

import com.example.makefriendandroid.model.Login
import com.example.makefriendandroid.model.LoginResponse
import com.example.makefriendandroid.model.RegistrationForm
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Body

interface AuthService {
    @POST("auth/login")
    fun login(@Body login: Login): Call<LoginResponse>

    @POST("auth/register")
    fun register(@Body register:RegistrationForm):Call<LoginResponse>
}