package com.example.makefriendandroid.service

import com.example.makefriendandroid.model.Interest
import com.example.makefriendandroid.model.ProfileDetails
import com.example.makefriendandroid.model.Trait
import com.example.makefriendandroid.model.UserTrait
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("api/profile")
    fun getProfileDetails(): Call<ProfileDetails>

    @POST("api/profile")
    fun setProfileDetails(@Body profileDetails: ProfileDetails): Call<ProfileDetails>

    @GET("api/profile/interests")
    fun getUserInterests(): Call<List<Interest>>

    @POST("api/profile/interests")
    fun setUserInterests(@Body userInterests: List<Interest>): Call<ProfileDetails>

    @GET("api/profile/traits")
    fun getTraits(): Call<List<UserTrait>>

    @POST("api/profile/traits")
    fun setTraits(@Body traits: List<UserTrait>): Call<ProfileDetails>
}