package com.example.makefriendandroid.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makefriendandroid.R
import com.example.makefriendandroid.fragments.friends.FriendsViewModel
import com.example.makefriendandroid.model.UserBasic

class FriendsAdapter(val data: List<UserBasic>, val viewModel: FriendsViewModel) :
    RecyclerView.Adapter<FriendsAdapter.FriendViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.friend_list_item, parent, false)
        return FriendViewHolder(view, viewModel)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class FriendViewHolder(itemView: View, val viewModel: FriendsViewModel) :
        RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.friend_name_text_view)
        val report = itemView.findViewById<Button>(R.id.report_friend)
        fun bind(item: UserBasic) {
            if (viewModel.reported.value != null) {
                val found =
                    viewModel.reported.value!!.find { user -> user.username == item.username }
                if (found != null) {
                    report.visibility = View.INVISIBLE
                } else {
                    report.visibility = View.VISIBLE
                }
            }
            name.text = item.firstName + " " + item.lastName
            report.setOnClickListener {
                viewModel.report(item.username)
            }
        }
    }
}