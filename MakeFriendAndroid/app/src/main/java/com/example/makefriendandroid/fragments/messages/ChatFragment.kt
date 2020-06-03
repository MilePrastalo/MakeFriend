package com.example.makefriendandroid.fragments.messages

import android.app.Activity
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
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
        val friendUsername = arguments?.getString("friendUsername")
        viewModel.friendUsername = friendUsername!!
        chat_recycler.layoutManager = LinearLayoutManager(context)
        viewModel.messages.observe(viewLifecycleOwner, Observer {
            chat_recycler.adapter = ChatAdapter(it, friendUsername)
            if (it.size > 0) {
                suggested_layout.visibility = View.GONE
            }
        })
        viewModel.suggestedMessage.observe(viewLifecycleOwner, Observer {
            if (it != "") {
                suggested_layout.visibility = View.VISIBLE
                suggested_message_text_view.text = it
                send_suggested_button.setOnClickListener {
                    viewModel.sendMessage(viewModel.suggestedMessage.value!!)
                }
            } else {
                suggested_layout.visibility = View.GONE
            }
        })
        viewModel.getMessages()
        send_button.setOnClickListener {
            val message = new_message_text.text.toString()
            viewModel.sendMessage(message)
            val imm =
                requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            var view = requireActivity().currentFocus
            if (view == null) {
                view = View(activity);
            }
            imm.hideSoftInputFromWindow(view.windowToken, 0)
            new_message_text.setText("")
        }
    }

}
