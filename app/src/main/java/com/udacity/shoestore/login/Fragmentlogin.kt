package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class Fragmentlogin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login, container, false
        )
        //Function for the Signin button
        binding.Signinbutton.setOnClickListener {
            val action = FragmentloginDirections.actionFragmentLoginToFragmentWelcome()
            NavHostFragment.findNavController(this).navigate(action)
        }
        //Function for the Signup button
        binding.Signupbutton.setOnClickListener {
            val action1 = FragmentloginDirections.actionFragmentLoginToFragmentWelcome()
            NavHostFragment.findNavController(this).navigate(action1)
        }
            return binding.root
        }
    }


