package com.example.makefriendandroid.fragments.friends

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makefriendandroid.Adapters.FriendRequestAdapter
import com.example.makefriendandroid.Adapters.FriendsAdapter

import com.example.makefriendandroid.R
import kotlinx.android.synthetic.main.friends_fragment.*

class FriendsFragment : Fragment() {

    companion object {
        fun newInstance() = FriendsFragment()
    }

    private lateinit var viewModel: FriendsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.friends_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FriendsViewModel::class.java)
        requests_recycler.layoutManager = LinearLayoutManager(context)
        friends_recycler.layoutManager = LinearLayoutManager(context)
        viewModel.friends.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                friends_recycler.adapter = FriendsAdapter(it)
            }
        })
        viewModel.friendRequests.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                requests_recycler.adapter = FriendRequestAdapter(it)
            }

        })
        viewModel.getFriendRequests()
        viewModel.getFriends()
    }

}
