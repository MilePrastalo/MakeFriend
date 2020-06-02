package com.example.makefriendandroid.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makefriendandroid.R
import com.example.makefriendandroid.model.Interest

class InterestsAdapter(val interests: List<Interest>, val userInterests: List<Interest>) :
    RecyclerView.Adapter<InterestsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.interest_list_item, parent, false)
        return ViewHolder(itemView, userInterests)
    }

    override fun getItemCount() = interests.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(interests[position])
    }

    class ViewHolder(val view: View,val userInterests: List<Interest>) : RecyclerView.ViewHolder(view) {
        var interestText: TextView
        lateinit var interest:Interest
        init {
            interestText = view.findViewById(R.id.interest_text_view)
            interestText.setOnClickListener {
                val filtered = userInterests.filter {
                    it.name == interestText.text.toString()
                }
                if (filtered.isNotEmpty()){
                    (userInterests as MutableList).remove(filtered[0])
                    interestText.setBackgroundColor(Color.WHITE)
                }else{
                    (userInterests as MutableList).add(interest)
                    interestText.setBackgroundColor(Color.GREEN)
                }
            }
        }

        fun bind(data: Interest) {
            interestText.text = data.name
            var exists = false
            for (interest in userInterests){
                if(interest.id == data.id){
                    exists = true
                    break
                }
            }
            if (exists){
                interestText.setBackgroundColor(Color.GREEN)
            }else{
                interestText.setBackgroundColor(Color.WHITE)
            }
            interest = data
        }

    }
}