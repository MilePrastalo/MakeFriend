package com.example.makefriendandroid.fragments.messages

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makefriendandroid.Adapters.ChatAdapter

import com.example.makefriendandroid.R
import kotlinx.android.synthetic.main.chat_fragment.*

class ChatFragment : Fragment() {

    companion object {
        fun newInstance() = ChatFragment()
    }

    private lateinit var viewModel: ChatViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.chat_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChatViewModel::class.java)
        val friendId = arguments?.getLong("friendId")
        viewModel.friendId = friendId!!
        chat_recycler.layoutManager = LinearLayoutManager(context)
        viewModel.messages.observe(viewLifecycleOwner, Observer {
            chat_recycler.adapter = ChatAdapter(it, friendId)
        })
        viewModel.getMessages()
    }

}
