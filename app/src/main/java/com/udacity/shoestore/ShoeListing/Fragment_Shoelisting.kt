package com.udacity.shoestore.ShoeListing

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoelistingBinding
import com.udacity.shoestore.databinding.ShoelistViewBinding

class Fragment_Shoelisting : Fragment() {

    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoelistingBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoelisting, container, false
        )

        binding.floatingActionButton.setOnClickListener {
            shoeViewModel.implementShoe()
            val action =
                Fragment_ShoelistingDirections.actionFragmentShoelistingToFragmentShoeDetail()
            NavHostFragment.findNavController(this).navigate(action)
        }

        shoeViewModel = ViewModelProvider(this)[ShoeViewModel::class.java]

        shoeViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            shoeList.forEach { shoe ->
                val shoeBinding: ShoelistViewBinding =
                    DataBindingUtil.inflate(inflater, R.layout.shoelist_view, container, false)
                shoeBinding.shoe = shoe
                binding.linearList.addView(shoeBinding.root)
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.logout_menu)
        toolbar.title = "Shoe Store Inventory"
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        shoeViewModel.clearInventory()
        logOut()
        return super.onOptionsItemSelected(item)
    }

    private fun logOut() {
        findNavController().navigate(Fragment_ShoelistingDirections.actionFragmentShoelistingToFragmentLogin())
    }

}



