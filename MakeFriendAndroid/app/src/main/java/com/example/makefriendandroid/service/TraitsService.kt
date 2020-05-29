package com.example.makefriendandroid.service

import com.example.makefriendandroid.model.Interest
import com.example.makefriendandroid.model.InterestCategory
import com.example.makefriendandroid.model.Trait
import retrofit2.Call
import retrofit2.http.GET

interface TraitsService {
    @GET("api/traits")
    fun getAllTraits(): Call<List<Trait>>

    @GET("api/interests")
    fun getInterestCategories(): Call<List<InterestCategory>>
}