package com.example.makefriendandroid.service

import com.example.makefriendandroid.model.FriendRequest
import com.example.makefriendandroid.model.FriendSuggestion
import com.example.makefriendandroid.model.SendFriendRequest
import com.example.makefriendandroid.model.UserBasic
import retrofit2.Call
import retrofit2.http.*

interface FriendsService {
    @GET("api/friends/suggested")
    fun getSuggestedFriend(): Call<List<FriendSuggestion>>

    @GET("api/friends/all")
    fun getAllFriends(): Call<List<UserBasic>>

    @POST("api/friends")
    fun sendFriendRequest(@Body friendRequest: SendFriendRequest
    ): Call<Void>

    @POST("api/friends/accept/{requestId}")
    fun acceptFriendRequest(@Path("requestId") requestId: Long
    ): Call<Void>

    @POST("api/friends/reject/{requestId}")
    fun rejectFriendRequest( @Path("requestId") requestId: Long
    ): Call<Void>

    @GET("api/friends/requests")
    fun getFriendRequests(): Call<List<FriendRequest>>

}