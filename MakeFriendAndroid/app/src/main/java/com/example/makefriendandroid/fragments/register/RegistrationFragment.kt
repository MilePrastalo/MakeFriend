package com.example.makefriendandroid.fragments.register

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

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
        register_button.setOnClickListener{
            register()
        }
        return inflater.inflate(R.layout.registration_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegistrationViewModel::class.java)
        // TODO: Use the ViewModel
    }
    private fun register(){
        val firstName = first_name_edit_text.text.toString()
        val lastName = last_name_edit_text.text.toString()
        val username = username_edit_text.text.toString()
        val password = password_edit_text.text.toString()
        val confirmedPassword = confirm_password_edit_text.text.toString()
        val email = email_edit_text.text.toString()
        if(password == confirmedPassword){
            val form  = RegistrationForm(firstName,lastName,username,password,confirmedPassword,email)
            viewModel.register(form)
        }else{
            Toast.makeText(context,"Passwords don't match",Toast.LENGTH_SHORT).show()
        }

    }

}
