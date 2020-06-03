package com.example.makefriendandroid.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makefriendandroid.R
import com.example.makefriendandroid.model.Message

class ChatAdapter(val data: List<Message>, val friendUsername: String) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.chat_list_item, parent, false)
        return ChatViewHolder(view, friendUsername)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class ChatViewHolder(itemview: View, val friendUsername: String) : RecyclerView.ViewHolder(itemview) {
        private val receivedMessage: TextView = itemview.findViewById(R.id.received_message_text)
        private val sentMessage: TextView = itemview.findViewById(R.id.sent_message_text)
        fun bind(item: Message) {
            if (item.sender == friendUsername) {
                receivedMessage.text = item.text
                sentMessage.text = ""
            } else {
                receivedMessage.text = ""
                sentMessage.text = item.text
            }
        }
    }
}