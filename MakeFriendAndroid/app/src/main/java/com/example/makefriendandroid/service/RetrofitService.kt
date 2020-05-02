package com.example.makefriendandroid.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object {
        private var retrofit: Retrofit? = null
        private var path: String = "http://localhost:8080"
        fun get_retrofit(): Retrofit {
            if (RetrofitService.retrofit == null) {
                RetrofitService.retrofit = Retrofit.Builder()
                    .baseUrl(RetrofitService.path)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return RetrofitService.retrofit!!
        }
    }


}