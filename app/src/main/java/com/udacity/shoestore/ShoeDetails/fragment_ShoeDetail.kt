package com.udacity.shoestore.ShoeDetails

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoedetailBinding

class fragment_ShoeDetail : Fragment() {

    private val shoeViewModel : ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoedetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoedetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoedetail, container, false)

        binding.shoeViewModel = shoeViewModel

        binding.cancelButton.setOnClickListener {
            val action = fragment_ShoeDetailDirections.actionFragmentShoeDetailToFragmentShoelisting()
            NavHostFragment.findNavController(this).navigate(action)
        }

        shoeViewModel.detailReturnToList.observe(viewLifecycleOwner, Observer{
            if (it) {
                findNavController().navigateUp()
            }
        })

        shoeViewModel.formIncomplete.observe(viewLifecycleOwner, Observer { showError ->
            if (showError) {
                formIncompleteMessage()
            }

        })

        return binding.root
    }
    private fun formIncompleteMessage() {
        AlertDialog.Builder(requireContext())
            .setTitle("Attention!")
            .setMessage("Please enter all fields")
            .setPositiveButton(requireContext().getString(android.R.string.ok)) {
                    dialogInterface, i -> dialogInterface.dismiss()
            }
            .setCancelable(true)
            .create()
            .show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        shoeViewModel.finish()
    }
}

