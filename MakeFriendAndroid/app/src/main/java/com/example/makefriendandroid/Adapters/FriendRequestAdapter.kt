package com.example.makefriendandroid.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makefriendandroid.R
import com.example.makefriendandroid.fragments.friends.FriendsViewModel
import com.example.makefriendandroid.model.FriendRequest

class FriendRequestAdapter(val data: List<FriendRequest>, val viewModel: FriendsViewModel) :
    RecyclerView.Adapter<FriendRequestAdapter.RequestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.friend_request_list_item, parent, false)
        return RequestViewHolder(view, viewModel)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class RequestViewHolder(itemView: View, val viewModel: FriendsViewModel) :
        RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.friend_request_name)
        val acceptButton: Button = itemView.findViewById(R.id.accept_request)
        val rejectButton: Button = itemView.findViewById(R.id.reject_request)
        fun bind(item: FriendRequest) {
            nameTextView.text = item.sender
            acceptButton.setOnClickListener {
                viewModel.acceptRequest(item)
            }
            rejectButton.setOnClickListener {
                viewModel.rejectRequest(item)
            }
        }
    }
}