package com.example.makefriendandroid.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.lists.FriendSuggestions
import com.example.makefriendandroid.service.FriendsService
import com.example.makefriendandroid.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {
    private val _suggested = MutableLiveData<FriendSuggestions>()
    val suggested: LiveData<FriendSuggestions>
        get() = _suggested
    fun HomeViewModel(){
        _suggested.value = FriendSuggestions(ArrayList())
    }

    fun getSuggestedFriends() {
          val retrofit = Retrofit.Builder()
              .baseUrl("http://10.0.2.2:8080/")
              .addConverterFactory(GsonConverterFactory.create())
              .build()
        val friendService: FriendsService =retrofit.create(FriendsService::class.java)

        friendService.getSuggestedFriend(1).enqueue(object : Callback<FriendSuggestions> {
            override fun onFailure(call: Call<FriendSuggestions>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<FriendSuggestions>,
                response: Response<FriendSuggestions>
            ) {
                _suggested.value = response.body()
            }

        })
    }
}
