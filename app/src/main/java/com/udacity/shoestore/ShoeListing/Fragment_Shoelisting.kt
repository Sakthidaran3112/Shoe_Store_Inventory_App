package com.udacity.shoestore.ShoeListing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoelistingBinding
import com.udacity.shoestore.databinding.ShoelistViewBinding

class Fragment_Shoelisting : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflating the layout
        val binding: FragmentShoelistingBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoelisting, container, false
        )

        binding.addButton.setOnClickListener {
            shoeViewModel.Savedata()
            findNavController().navigate(R.id.action_fragment_Shoelisting_to_fragment_ShoeDetail)
        }

        shoeViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEach { ShoeData ->
                val shoeListBinding: ShoelistViewBinding =
                    DataBindingUtil.inflate(inflater, R.layout.shoelist_view, container, false)
                shoeListBinding.shoe = ShoeData
                binding.DetailList.addView(shoeListBinding.root)
            }
        })

        return binding.root
    }

    //Creating the menu for implementing logout function
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.logout_menu)
        toolbar.title = "Shoe Store Inventory"
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.logout -> {
                    findNavController().navigate(R.id.action_fragment_Shoelisting_to_loginFragment)
                    true
                }
                else -> false
            }
        }

    }
}



