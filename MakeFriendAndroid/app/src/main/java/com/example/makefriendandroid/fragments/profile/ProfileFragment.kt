package com.example.makefriendandroid.fragments.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.example.makefriendandroid.R
import com.example.makefriendandroid.model.ProfileDetails
import kotlinx.android.synthetic.main.profile_fragment.*
import kotlinx.android.synthetic.main.profile_fragment.prof_email_edit_text
import kotlinx.android.synthetic.main.profile_fragment.prof_first_name_edit_text
import kotlinx.android.synthetic.main.profile_fragment.prof_last_name_edit_text
import kotlinx.android.synthetic.main.registration_fragment.*

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        to_traits_button.setOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_profileTraitsFragment)
        }

        viewModel.getProfileInfo()
        viewModel.profileDetails.observe(viewLifecycleOwner, Observer {
            prof_first_name_edit_text.setText(it.firstName)
            prof_last_name_edit_text.setText(it.lastName)
            prof_email_edit_text.setText(it.email)
        })

        save_button.setOnClickListener {
            viewModel.profileDetails.value?.firstName = prof_first_name_edit_text.text.toString()
            viewModel.profileDetails.value?.lastName = prof_last_name_edit_text.text.toString()
            viewModel.profileDetails.value?.email = prof_email_edit_text.text.toString()
            viewModel.saveProfileInfo()
        }
    }


}
