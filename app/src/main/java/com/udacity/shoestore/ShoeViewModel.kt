package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel () {

    var shoesList: Shoe? = null
    private var shoe = mutableListOf<Shoe>()

    private val _List = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _List

    val shoeDetail = SingleLiveEvent<Boolean>()


    fun Savedata() {
        shoesList = Shoe("", "", "","")
    }

    fun addShoe() {
        shoesList?.let { list ->
                shoe.add(list)
                Addetail()
                _List.value = shoe
        }

    }
    fun Addetail() {
        shoeDetail.value= true
    }



}




