package com.example.makefriendandroid.fragments.login

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.Login
import com.example.makefriendandroid.service.AppData
import com.example.makefriendandroid.service.AuthService
import com.example.makefriendandroid.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    val loggedIn = MutableLiveData<Boolean>()
    val networkError = MutableLiveData<Boolean>()
    init {
    }

    fun login(username: String, password: String) {
        val loginData = Login(username, password)
        val authService: AuthService =
            RetrofitService.get_retrofit().create(AuthService::class.java)
        authService.login(loginData).enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                AppData.username = username
                AppData.password = password
                loggedIn.value = response.body()!!
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                networkError.value = true;
            }
        })
    }
}
