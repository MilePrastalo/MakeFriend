package com.example.makefriendandroid.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makefriendandroid.R
import com.example.makefriendandroid.model.Interest
import com.example.makefriendandroid.model.InterestCategory

class InterestCategoryAdapter(
    val interestCategories: List<InterestCategory>,
    val userInterests: List<Interest>
) : RecyclerView.Adapter<InterestCategoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.interest_category_list_item, parent, false)
        return ViewHolder(view,parent.context,userInterests)
    }

    override fun getItemCount() = interestCategories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = interestCategories[position]
        holder.bind(item)
    }

    class ViewHolder(itemView: View, val context:Context,val userInterests:List<Interest>) : RecyclerView.ViewHolder(itemView) {
        var categoryName:TextView
        var interestsRecycler:RecyclerView
        init {
            categoryName = itemView.findViewById(R.id.interestCategoryName)
            interestsRecycler = itemView.findViewById(R.id.interestsRecycler)
        }
        fun bind(item:InterestCategory){
            categoryName.text = item.name
            val adapter = InterestsAdapter(item.interests,userInterests)
            interestsRecycler.layoutManager = LinearLayoutManager(context)
            interestsRecycler.adapter = adapter
        }
    }


}