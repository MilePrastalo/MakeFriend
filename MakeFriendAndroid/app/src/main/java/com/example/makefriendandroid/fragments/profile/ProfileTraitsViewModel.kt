package com.example.makefriendandroid.fragments.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.ProfileDetails
import com.example.makefriendandroid.model.Trait
import com.example.makefriendandroid.model.UserTrait
import com.example.makefriendandroid.service.RetrofitService
import com.example.makefriendandroid.service.TraitsService
import com.example.makefriendandroid.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileTraitsViewModel : ViewModel() {
    val userTraits = MutableLiveData<List<UserTrait>>()
    val traits = MutableLiveData<List<Trait>>()

    init {
        userTraits.value = ArrayList()
        traits.value = ArrayList()
    }

    fun saveTraits() {
        val service = RetrofitService.get_retrofit().create(UserService::class.java)
        service.setTraits(userTraits.value!!).enqueue(object: Callback<ProfileDetails>{
            override fun onFailure(call: Call<ProfileDetails>, t: Throwable) {
                Log.i("ProfileTraitsViewModel",t.message)
            }

            override fun onResponse(
                call: Call<ProfileDetails>,
                response: Response<ProfileDetails>
            ) {
                Log.i("ProfileTraitsViewModel",response.message())
            }

        } )
    }

    fun getAllTraits() {
        val service = RetrofitService.get_retrofit().create(TraitsService::class.java)
        service.getAllTraits().enqueue(object : Callback<List<Trait>> {
            override fun onFailure(call: Call<List<Trait>>, t: Throwable) {
                Log.i("ProfileTraitsViewModel", t.message)
            }

            override fun onResponse(call: Call<List<Trait>>, response: Response<List<Trait>>) {
                traits.value = response.body()!!
            }
        })
    }

    fun getUserTraits() {
        val service = RetrofitService.get_retrofit().create(UserService::class.java)
        service.getTraits().enqueue(object : Callback<List<UserTrait>> {
            override fun onFailure(call: Call<List<UserTrait>>, t: Throwable) {
                Log.i("ProfileTraitsViewModel", t.message)
            }

            override fun onResponse(
                call: Call<List<UserTrait>>,
                response: Response<List<UserTrait>>
            ) {
                userTraits.value = response.body()!!
            }
        })
    }
}
