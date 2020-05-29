package com.example.makefriendandroid.fragments.messages

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.Message
import com.example.makefriendandroid.service.MessagesService
import com.example.makefriendandroid.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.function.LongFunction

class ChatViewModel : ViewModel() {
   val messages = MutableLiveData<List<Message>>()
    var friendId: Long = 0
    fun getMessages(){
        val service = RetrofitService.get_retrofit().create(MessagesService::class.java)
        service.getChatMessages(friendId).enqueue(object :Callback<List<Message>>{
            override fun onFailure(call: Call<List<Message>>, t: Throwable) {
                Log.i("ChatViewModel",t.message)
            }

            override fun onResponse(call: Call<List<Message>>, response: Response<List<Message>>) {
                messages.value = response.body()
            }

        })
    }

}
