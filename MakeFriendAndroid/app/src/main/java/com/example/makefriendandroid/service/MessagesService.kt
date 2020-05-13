package com.example.makefriendandroid.service

import com.example.makefriendandroid.model.Message
import com.example.makefriendandroid.model.lists.MessageHeadList
import com.example.makefriendandroid.model.lists.Messages
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MessagesService {

    @GET("api/messages/{userId}")
    fun getMessages(@Path("userId") userId: Long): Call<MessageHeadList>

    @GET("api/messages/{userId}/{friendId}")
    fun getChatMessages(
        @Path("userId") userId: Long,
        @Path("friendId") friendId: Long
    ): Call<Messages>

    @POST("api/messages")
    fun sendChatMessage(@Body message: Message): Call<Message>

    @GET("api/messages/suggested/{userId}/{friendId}")
    fun getSuggestedMessage(
        @Path("userId") userId: Long,
        @Path("friendId") friendId: Long
    ): Call<Void>
}