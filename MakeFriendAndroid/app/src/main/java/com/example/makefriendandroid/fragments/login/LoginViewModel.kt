package com.example.makefriendandroid.fragments.login

import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.Login
import com.example.makefriendandroid.model.LoginResponse
import com.example.makefriendandroid.service.AuthService
import com.example.makefriendandroid.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    fun login(username: String, password: String) {
        val loginData = Login(username, password)
        val authService: AuthService =
            RetrofitService.get_retrofit().create(AuthService::class.java)
        val response = authService.login(loginData).enqueue(object :Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
