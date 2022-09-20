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

    private val _ShoeDetail = MutableLiveData<Boolean>()
    val ShoeDetail: LiveData<Boolean>
        get() = _ShoeDetail


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
        _ShoeDetail.value = true
    }


}




