package com.udacity.shoestore.Instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding


class Fragment_Instructions : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentInstructionsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instructions, container, false
        )
        binding.NextInstructionButton.setOnClickListener {
            val action = Fragment_InstructionsDirections.actionFragmentInstructionsToFragmentShoelisting()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root

    }
}
