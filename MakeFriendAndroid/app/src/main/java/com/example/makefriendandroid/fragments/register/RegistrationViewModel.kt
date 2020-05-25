package com.example.makefriendandroid.fragments.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.RegistrationForm
import com.example.makefriendandroid.service.AppData
import com.example.makefriendandroid.service.AuthService
import com.example.makefriendandroid.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationViewModel : ViewModel() {
    val loggedIn = MutableLiveData<Boolean>()

    fun register(registerForm: RegistrationForm) {
        val authService = RetrofitService.get_retrofit().create(AuthService::class.java)
        authService.register(registerForm).enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                AppData.username = registerForm.username
                AppData.password = registerForm.password
                loggedIn.value = response.body()
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                loggedIn.value = false
            }
        })
    }
}
