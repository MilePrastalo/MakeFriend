package com.example.makefriendandroid.fragments.register

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.example.makefriendandroid.R
import com.example.makefriendandroid.model.RegistrationForm
import kotlinx.android.synthetic.main.registration_fragment.*

class RegistrationFragment : Fragment() {

    companion object {
        fun newInstance() = RegistrationFragment()
    }

    private lateinit var viewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.registration_fragment, container, false)
        val register_button = view.findViewById<Button>(R.id.register_button)
        val register_to_login = view.findViewById<TextView>(R.id.register_to_login_text_view)
        register_button.setOnClickListener {
            register()
        }
        register_to_login.setOnClickListener {
            this.findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegistrationViewModel::class.java)
        viewModel.loggedIn.observe(viewLifecycleOwner, Observer {
            if (it) {
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                with(sharedPref!!.edit()) {
                    putString("username", com.example.makefriendandroid.service.AppData.username)
                    putString("password", com.example.makefriendandroid.service.AppData.password)
                    commit()
                }
                this.findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
            } else {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun register() {
        val firstName = reg_first_name_edit_text.text.toString()
        val lastName = reg_last_name_edit_text.text.toString()
        val username = reg_username_edit_text.text.toString()
        val password = reg_password_edit_text.text.toString()
        val confirmedPassword = reg_confirm_password_edit_text.text.toString()
        val email = reg_email_edit_text.text.toString()
        if (password == confirmedPassword) {
            val form =
                RegistrationForm(firstName, lastName, username, password, confirmedPassword, email)
            viewModel.register(form)
        } else {
            Toast.makeText(context, "Passwords don't match", Toast.LENGTH_SHORT).show()
        }
    }

}
