package com.example.makefriendandroid.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makefriendandroid.R
import com.example.makefriendandroid.model.FriendRequest

class FriendRequestAdapter(val data:List<FriendRequest>):RecyclerView.Adapter<FriendRequestAdapter.RequestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.friend_request_list_item,parent,false)
        return RequestViewHolder((view))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        holder.bind(data[position])
    }
    class RequestViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val nameTextView = itemView.findViewById<TextView>(R.id.friend_request_name)
        fun bind(item:FriendRequest){
            nameTextView.text  = item.sender
        }
    }
}