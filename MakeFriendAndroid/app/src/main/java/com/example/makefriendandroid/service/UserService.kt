package com.example.makefriendandroid.service

import com.example.makefriendandroid.model.ProfileDetails
import com.example.makefriendandroid.model.lists.Traits
import com.example.makefriendandroid.model.lists.UserInterests
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {
    @GET("api/profile/{userId}")
    fun getProfileDetails(@Path("userId") userId: Long): Call<ProfileDetails>

    @POST("api/profile/")
    fun setProfileDetails(@Body profileDetails: ProfileDetails): Call<ProfileDetails>

    @GET("api/profile/{userId}/interests")
    fun getUserInterests(@Path("userId") userId: Long): Call<UserInterests>

    @POST("api/profile/{userId}/interests")
    fun setUserInterests(
        @Path("userId") userId: Long,
        @Body userInterests: UserInterests
    ): Call<ProfileDetails>

    @GET("api/profile/{userId}/traits")
    fun getTraits(@Path("userId") userId: Long): Call<Traits>

    @POST("api/profile/{userId}/traits")
    fun setTraits(@Path("userId") userId: Long, @Body traits: Traits): Call<ProfileDetails>
}