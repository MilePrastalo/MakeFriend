package com.example.makefriendandroid.service

import okhttp3.Interceptor
import okhttp3.Response

class SupportInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request?.newBuilder()
            ?.addHeader("Authorization", AppData.getAuthorization())
            ?.build()
        return chain.proceed(request)
    }
}