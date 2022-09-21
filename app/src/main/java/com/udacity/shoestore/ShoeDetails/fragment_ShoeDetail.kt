package com.udacity.shoestore.ShoeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoedetailBinding

class fragment_ShoeDetail : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoedetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflating the fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoedetail, container, false
        )

        binding.shoeViewModel = shoeViewModel
        binding.lifecycleOwner = this

        //function for the cancel button
        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        //Function for the save button
        shoeViewModel.shoeDetail.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(R.id.action_fragment_ShoeDetail_to_fragment_Shoelisting)
            }
        })

        return binding.root
    }

}

