package com.example.makefriendandroid.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makefriendandroid.R
import com.example.makefriendandroid.fragments.messages.AllMessagesFragment
import com.example.makefriendandroid.model.MessageHead

class MessageHeadAdapter(val data: List<MessageHead>, val fragment: AllMessagesFragment) :
    RecyclerView.Adapter<MessageHeadAdapter.MessageHeadViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHeadViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.messages_list_item, parent, false)
        return MessageHeadViewHolder(view, fragment)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MessageHeadViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class MessageHeadViewHolder(itemView: View, val fragment: AllMessagesFragment) :
        RecyclerView.ViewHolder(itemView) {
        val friendName: TextView = itemView.findViewById(R.id.friend_name_text_view)
        val view:View = itemView
        fun bind(item: MessageHead) {
            friendName.text = item.name
            view.setOnClickListener {
                fragment.navigateToMessage(item.username)
            }
        }
    }
}