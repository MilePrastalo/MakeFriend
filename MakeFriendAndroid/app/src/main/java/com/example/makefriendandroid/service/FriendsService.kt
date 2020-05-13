package com.example.makefriendandroid.service

import com.example.makefriendandroid.model.FriendRequest
import com.example.makefriendandroid.model.lists.FriendRequests
import com.example.makefriendandroid.model.lists.UsersBasic
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FriendsService {
    @GET("api/friends/suggested/{userId}")
    fun getSuggestedFriend(@Path("userId") userId: Long): Call<Void>

    @GET("api/friends/all/{userId}")
    fun getAllFriends(@Path("userId") userId: Long): Call<UsersBasic>

    @POST("api/friends")
    fun sendFriendRequest(@Body friendRequest: FriendRequest): Call<Void>

    @POST("api/friends/accept/{requestId}")
    fun acceptFriendRequest(@Path("requestId") requestId: Long): Call<Void>

    @POST("api/friends/reject/{requestId}")
    fun rejectFriendRequest(@Path("requestId") requestId: Long): Call<Void>

    @GET("api/friends/requests/{userId}")
    fun getFriendRequests(@Path("userId") userId: Long): Call<FriendRequests>

}