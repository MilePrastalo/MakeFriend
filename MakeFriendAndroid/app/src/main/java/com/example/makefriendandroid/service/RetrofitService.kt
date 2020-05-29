package com.example.makefriendandroid.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object {
        private var retrofit: Retrofit? = null
        fun get_retrofit(): Retrofit {
            if (retrofit == null) {
                val okHttp = OkHttpClient.Builder().addInterceptor(SupportInterceptor())
                retrofit = Retrofit.Builder()
                    .baseUrl("http://192.168.1.15:8080/")
                    //.baseUrl("http://10.0.2.2:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttp.build())
                    .build()
            }
            return retrofit!!
        }
    }


}