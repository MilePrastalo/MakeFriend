package com.example.makefriendandroid.fragments.messages

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.makefriendandroid.R

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
        // TODO: Use the ViewModel
    }

}
