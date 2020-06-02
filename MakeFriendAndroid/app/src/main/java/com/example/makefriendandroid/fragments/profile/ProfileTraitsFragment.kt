package com.example.makefriendandroid.fragments.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makefriendandroid.Adapters.TraitsAdapter

import com.example.makefriendandroid.R
import kotlinx.android.synthetic.main.profile_traits_fragment.*

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
        viewModel = ViewModelProvider(this).get(ProfileTraitsViewModel::class.java)
        traits_recycler_view.layoutManager = LinearLayoutManager(context)
        next_button.setOnClickListener {
            findNavController().navigate(R.id.action_profileTraitsFragment_to_interestsFragment)
        }
        previous_button.setOnClickListener {
            findNavController().navigate(R.id.action_profileTraitsFragment_to_profileFragment)
        }
        viewModel.traits.observe(viewLifecycleOwner, Observer {
            val adapter = TraitsAdapter(viewModel.traits.value!!,viewModel.userTraits.value!!)
            traits_recycler_view.adapter = adapter
        })
        viewModel.userTraits.observe(viewLifecycleOwner, Observer {
            val adapter = TraitsAdapter(viewModel.traits.value!!,viewModel.userTraits.value!!)
            traits_recycler_view.adapter = adapter

        })
        viewModel.getAllTraits()
        viewModel.getUserTraits()

        save_button.setOnClickListener {
            viewModel.saveTraits()
        }
    }

}
