package com.example.makefriendandroid.fragments.friends

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.FriendRequest
import com.example.makefriendandroid.model.UserBasic
import com.example.makefriendandroid.service.FriendsService
import com.example.makefriendandroid.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FriendsViewModel : ViewModel() {
    val friendRequests = MutableLiveData<List<FriendRequest>>()
    val friends = MutableLiveData<List<UserBasic>>()
    val service = RetrofitService.get_retrofit().create(FriendsService::class.java)

    fun getFriendRequests(){
        service.getFriendRequests().enqueue(object :Callback<List<FriendRequest>>{
            override fun onFailure(call: Call<List<FriendRequest>>, t: Throwable) {
                Log.i("FriendsViewModel",t.message)
            }

            override fun onResponse(
                call: Call<List<FriendRequest>>,
                response: Response<List<FriendRequest>>
            ) {
                friendRequests.value = response.body()
            }
        })
    }
    fun getFriends(){
        service.getAllFriends().enqueue(object :Callback<List<UserBasic>>{
            override fun onFailure(call: Call<List<UserBasic>>, t: Throwable) {
                Log.i("FriendsViewModel",t.message) }

            override fun onResponse(
                call: Call<List<UserBasic>>,
                response: Response<List<UserBasic>>
            ) {
                friends.value = response.body()
            }
        })
    }
    fun acceptRequest(request: FriendRequest){
        service.acceptFriendRequest(request.id).enqueue(object :Callback<Void>{
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.i("FriendsViewModel",t.message)
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                getFriendRequests()
                getFriends()
            }
        })
    }
    fun rejectRequest(request:FriendRequest){
        service.rejectFriendRequest(request.id).enqueue(object :Callback<Void>{
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.i("FriendsViewModel",t.message)
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                getFriendRequests()
            }
        })
    }
}
