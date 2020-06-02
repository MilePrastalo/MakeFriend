package com.example.makefriendandroid.fragments.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.Interest
import com.example.makefriendandroid.model.InterestCategory
import com.example.makefriendandroid.model.ProfileDetails
import com.example.makefriendandroid.service.RetrofitService
import com.example.makefriendandroid.service.TraitsService
import com.example.makefriendandroid.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InterestsViewModel : ViewModel() {
    val update = MutableLiveData<Boolean>()
    val savedInterests = MutableLiveData<Boolean>()
    var interestCategories: List<InterestCategory> = ArrayList<InterestCategory>()
    var userInterests: List<Interest> = ArrayList<Interest>()

    fun getInterestCategories() {
        val service = RetrofitService.get_retrofit().create(TraitsService::class.java)
        service.getInterestCategories().enqueue(object : Callback<List<InterestCategory>> {
            override fun onFailure(call: Call<List<InterestCategory>>, t: Throwable) {
                Log.i("InterestsViewModel", t.message)
            }

            override fun onResponse(
                call: Call<List<InterestCategory>>,
                response: Response<List<InterestCategory>>
            ) {
                interestCategories = response.body()!!
                update.value = true
            }

        })
    }

    fun getUserInterests() {
        val service = RetrofitService.get_retrofit().create(UserService::class.java)
        service.getUserInterests().enqueue(object : Callback<List<Interest>> {
            override fun onFailure(call: Call<List<Interest>>, t: Throwable) {
                Log.i("InterestsViewModel", t.message)
            }

            override fun onResponse(
                call: Call<List<Interest>>,
                response: Response<List<Interest>>
            ) {
                userInterests = response.body()!!
                update.value = true
            }

        })
    }

    fun saveInterests() {
        val service = RetrofitService.get_retrofit().create(UserService::class.java)
        service.setUserInterests(userInterests).enqueue(object : Callback<ProfileDetails> {
            override fun onFailure(call: Call<ProfileDetails>, t: Throwable) {
                Log.i("InterestViewModel", t.message)
            }

            override fun onResponse(
                call: Call<ProfileDetails>,
                response: Response<ProfileDetails>
            ) {
                Log.i("InterestViewModel", response.message())
            }

        })
    }

}
