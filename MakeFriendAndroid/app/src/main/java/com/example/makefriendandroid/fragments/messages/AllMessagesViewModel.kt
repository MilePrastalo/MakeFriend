package com.example.makefriendandroid.fragments.messages

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.MessageHead
import com.example.makefriendandroid.service.MessagesService
import com.example.makefriendandroid.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllMessagesViewModel : ViewModel() {
    val messagess = MutableLiveData<List<MessageHead>>()
    fun getMessagess() {
        val service = RetrofitService.get_retrofit().create(MessagesService::class.java)
        service.getMessages().enqueue(object : Callback<List<MessageHead>> {
            override fun onFailure(call: Call<List<MessageHead>>, t: Throwable) {
                Log.i("AllMessagesViewModel", t.message)
            }

            override fun onResponse(
                call: Call<List<MessageHead>>,
                response: Response<List<MessageHead>>
            ) {
                messagess.value = response.body()
            }

        })
    }
}
