package com.example.makefriendandroid.fragments.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.makefriendandroid.R

class ProfileTraitsFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileTraitsFragment()
    }

    private lateinit var viewModel: ProfileTraitsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_traits_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileTraitsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
