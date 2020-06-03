package com.example.makefriendandroid.fragments.messages

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makefriendandroid.Adapters.MessageHeadAdapter

import com.example.makefriendandroid.R
import kotlinx.android.synthetic.main.all_messages_fragment.*

class AllMessagesFragment : Fragment() {

    companion object {
        fun newInstance() = AllMessagesFragment()
    }

    private lateinit var viewModel: AllMessagesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.all_messages_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AllMessagesViewModel::class.java)
        all_messagess_recycler.layoutManager = LinearLayoutManager(context)
        viewModel.messagess.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                all_messagess_recycler.adapter = MessageHeadAdapter(it,this)
            }
        })
        viewModel.getMessagess()
    }
    fun navigateToMessage(username:String){
        val bundle = bundleOf("friendUsername" to username)
        findNavController().navigate(R.id.action_allMessagesFragment_to_chatFragment, bundle)
    }

}
