package com.example.makefriendandroid.fragments.messages

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.Message
import com.example.makefriendandroid.model.SuggestedMessage
import com.example.makefriendandroid.service.AppData
import com.example.makefriendandroid.service.MessagesService
import com.example.makefriendandroid.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import java.util.function.LongFunction

class ChatViewModel : ViewModel() {
    val service = RetrofitService.get_retrofit().create(MessagesService::class.java)
    val messages = MutableLiveData<List<Message>>()
    val suggestedMessage = MutableLiveData<String>()
    var friendUsername: String = ""

    init {
        suggestedMessage.value = ""
    }

    fun getMessages() {
        service.getChatMessages(friendUsername).enqueue(object : Callback<List<Message>> {
            override fun onFailure(call: Call<List<Message>>, t: Throwable) {
                Log.i("ChatViewModel", t.message)
            }

            override fun onResponse(call: Call<List<Message>>, response: Response<List<Message>>) {
                messages.value = response.body()
                if (messages.value?.size == 0) {
                    getSuggestedMessage()
                }
            }
        })
    }

    fun getSuggestedMessage() {
        service.getSuggestedMessage(friendUsername).enqueue(object : Callback<SuggestedMessage> {
            override fun onFailure(call: Call<SuggestedMessage>, t: Throwable) {
                Log.i("SuggestedMessage", t.message)
            }

            override fun onResponse(
                call: Call<SuggestedMessage>,
                response: Response<SuggestedMessage>
            ) {
                if (response.body() != null) {
                    suggestedMessage.value = response.body()?.text;
                }
            }

        })
    }

    fun sendMessage(message: String) {
        val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        val message = Message(
            null,
            AppData.username!!,
            friendUsername,
            simpleDateFormat.format(Date()), message
        )
        service.sendChatMessage(message).enqueue(object : Callback<Message> {
            override fun onFailure(call: Call<Message>, t: Throwable) {
                Log.i("SentSuggestedMessage", t.message)
            }

            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                getMessages()
            }

        })
    }

}
