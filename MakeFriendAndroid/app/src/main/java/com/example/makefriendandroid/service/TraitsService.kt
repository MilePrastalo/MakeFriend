package com.example.makefriendandroid.service

import com.example.makefriendandroid.model.lists.Interests
import com.example.makefriendandroid.model.lists.Traits
import retrofit2.Call
import retrofit2.http.GET

interface TraitsService {
    @GET("api/traits")
    fun getAllTraits(): Call<Traits>

    @GET("api/interests")
    fun getAllInterests(): Call<Interests>
}