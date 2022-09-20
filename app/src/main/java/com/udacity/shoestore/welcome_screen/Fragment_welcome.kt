package com.udacity.shoestore.welcome_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class Fragment_welcome : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflating the fragment
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcome, container, false)
        binding.NextInstructionButton.setOnClickListener {
            val action = Fragment_welcomeDirections.actionFragmentWelcomeToFragmentInstructions()
            NavHostFragment.findNavController(this).navigate(action)
        }
        return binding.root
    }


}