package com.example.makefriendandroid.fragments.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.FriendSuggestion
import com.example.makefriendandroid.model.ProfileDetails
import com.example.makefriendandroid.service.FriendsService
import com.example.makefriendandroid.service.RetrofitService
import com.example.makefriendandroid.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val _suggested = MutableLiveData<List<FriendSuggestion>>()
    val suggested: LiveData<List<FriendSuggestion>>
        get() = _suggested

    val name = MutableLiveData<String>()
    init {
        _suggested.value = ArrayList()
    }

    fun getSuggestedFriends() {
        val friendService: FriendsService =RetrofitService.get_retrofit().create(FriendsService::class.java)
        friendService.getSuggestedFriend().enqueue(object : Callback<List<FriendSuggestion>> {
            override fun onFailure(call: Call<List<FriendSuggestion>>, t: Throwable) {
                Log.i("HomeFail",t.message)
            }
            override fun onResponse(
                call: Call<List<FriendSuggestion>>,
                response: Response<List<FriendSuggestion>>
            ) {
                _suggested.value = response.body()
            }
        })
    }

    fun getProfileDetails(){
        val service = RetrofitService.get_retrofit().create(UserService::class.java)
        service.getProfileDetails().enqueue(object :Callback<ProfileDetails>{
            override fun onFailure(call: Call<ProfileDetails>, t: Throwable) {
                Log.i("HomeViewModel",t.message)
            }

            override fun onResponse(
                call: Call<ProfileDetails>,
                response: Response<ProfileDetails>
            ) {
                name.value = response.body()!!.firstName + " " + response.body()!!.lastName
            }

        })
    }
}
