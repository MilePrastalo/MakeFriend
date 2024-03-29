package com.example.makefriendandroid.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makefriendandroid.R
import com.example.makefriendandroid.fragments.home.HomeViewModel
import com.example.makefriendandroid.model.FriendSuggestion

class FriendSuggestionsAdapter(val data: List<FriendSuggestion>, val viewModel:HomeViewModel) :
    RecyclerView.Adapter<FriendSuggestionsAdapter.SuggestionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionViewHolder {
        val friendSuggestion_list = LayoutInflater.from(parent.context)
            .inflate(R.layout.friend_suggestion_list_item, parent, false)
        return SuggestionViewHolder(friendSuggestion_list,viewModel)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: SuggestionViewHolder, position: Int) {
        holder.bindData(data[position])
    }


    class SuggestionViewHolder(itemView: View,val viewModel:HomeViewModel) : RecyclerView.ViewHolder(itemView) {
        var friendName: TextView
        var add_friend:Button
        var image: ImageView

        init {
            friendName = itemView.findViewById(R.id.name_suggestion_text_view)
            image = itemView.findViewById(R.id.suggested_image_view)
            image.setImageResource(R.drawable.image)
            add_friend = itemView.findViewById(R.id.add_friend)
        }

        fun bindData(friendSuggestion: FriendSuggestion) {
            friendName.text = friendSuggestion.firstName + " " + friendSuggestion.lastName
            add_friend.setOnClickListener {
                viewModel.addFriend(friendSuggestion.username!!)
            }
        }

    }
}