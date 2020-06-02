package com.example.makefriendandroid.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makefriendandroid.R
import com.example.makefriendandroid.model.Trait
import com.example.makefriendandroid.model.UserTrait

class TraitsAdapter(val traits:List<Trait>, val userTraits:List<UserTrait>):RecyclerView.Adapter<TraitsAdapter.TraitsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TraitsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trait_list_item,parent,false)
        return TraitsViewHolder(view,userTraits)
    }

    override fun getItemCount() = traits.size

    override fun onBindViewHolder(holder: TraitsViewHolder, position: Int) {
        val trait = traits[position]
        holder.bind(trait)
    }


    class TraitsViewHolder(itemView: View,val userTraits:List<UserTrait>):RecyclerView.ViewHolder(itemView){
        val traitName:TextView
        val yes:RadioButton
        val no:RadioButton
        init {
            traitName = itemView.findViewById(R.id.trait_name)
            yes = itemView.findViewById(R.id.yes_radio)
            no = itemView.findViewById(R.id.no_radio)
            yes.setOnClickListener{
                val trait = userTraits.find {
                    it.name == traitName.text
                }
                if(trait != null){
                    trait.value = true
                }else{
                    val newTrait = UserTrait(null,traitName.text.toString(),true)
                    (userTraits as MutableList).add(newTrait)
                }
            }
            no.setOnClickListener {
                val trait = userTraits.find {
                    it.name == traitName.text
                }
                if(trait != null){
                    trait.value = false
                }else{
                    val newTrait = UserTrait(null,traitName.text.toString(),false)
                    (userTraits as MutableList).add(newTrait)
                }
            }
        }
        fun bind(trait:Trait){
            traitName.text = trait.name
            var exist = false
            for (userTrait in userTraits){
                if(trait.name == userTrait.name){
                    exist = true
                    if(userTrait.value){
                        yes.isChecked = true
                    }else{
                        no.isChecked = true
                    }
                    break
                }
            }
        }
    }
}