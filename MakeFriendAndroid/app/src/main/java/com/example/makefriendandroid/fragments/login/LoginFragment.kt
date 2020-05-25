package com.example.makefriendandroid.fragments.login

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
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)
        val login_button = view.findViewById<Button>(R.id.login_button)
        val login_to_register_text_view =
            view.findViewById<TextView>(R.id.login_to_register_text_view)
        login_button.setOnClickListener {
            login()
        }
        login_to_register_text_view.setOnClickListener {
            this.findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.networkError.observe(viewLifecycleOwner, Observer {
            if (it) {
                Toast.makeText(context, "Network error", Toast.LENGTH_SHORT).show()
                viewModel.networkError.value = false
            }
        })
        viewModel.loggedIn.observe(viewLifecycleOwner, Observer {
            if (it) {
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                with(sharedPref!!.edit()) {
                    putString("username", com.example.makefriendandroid.service.AppData.username)
                    putString("password", com.example.makefriendandroid.service.AppData.password)
                    commit()
                }
                this.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            } else {
                Toast.makeText(context, "Wrong credentials", Toast.LENGTH_SHORT).show()
            }
        })

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        val userName = sharedPref?.getString("username", "")
        val password = sharedPref?.getString("password", "")
        if (userName != "" && password != "") {
            viewModel.login(userName!!, password!!)
        }
    }

    private fun login() {
        val username = user_name_edit_text.text.toString()
        val password = reg_password_edit_text.text.toString()
        viewModel.login(username, password)
    }

}
