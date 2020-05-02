package com.example.makefriendandroid.fragments.register

import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.LoginResponse
import com.example.makefriendandroid.model.RegistrationForm
import com.example.makefriendandroid.service.AuthService
import com.example.makefriendandroid.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationViewModel : ViewModel() {
    fun register(registerForm:RegistrationForm){
        val authService = RetrofitService.get_retrofit().create(AuthService::class.java)
        authService.register(registerForm).enqueue(object :Callback<LoginResponse>{
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                TODO("Not yet implemented")
            }

        })
    }
}
