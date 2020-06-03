package com.example.makefriendandroid.service

import com.example.makefriendandroid.model.Message
import com.example.makefriendandroid.model.MessageHead
import com.example.makefriendandroid.model.SuggestedMessage
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MessagesService {

    @GET("api/messages/")
    fun getMessages(): Call<List<MessageHead>>

    @GET("api/messages/{friendUsername}")
    fun getChatMessages(
        @Path("friendUsername") friendUsername: String
    ): Call<List<Message>>

    @POST("api/messages")
    fun sendChatMessage(@Body message: Message): Call<Message>

    @GET("api/messages/suggested/{friendUsername}")
    fun getSuggestedMessage(
        @Path("friendUsername") friendUsername: String
    ): Call<SuggestedMessage>
}