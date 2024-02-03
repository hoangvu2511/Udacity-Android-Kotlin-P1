package com.udacity.shoestore

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    class ShoeDetail : BaseObservable() {
        var shoeName: String = ""
            set(value) {
                field = value
                notifyChange()
            }
        var company: String = ""
            set(value) {
                field = value
                notifyChange()
            }
        var shoeSize: String = ""
            set(value) {
                field = value
                notifyChange()
            }
        var shoeDesc: String = ""

        @Bindable
        fun isVerifyDetail(): Boolean {
            return shoeName.isNotEmpty() && company.isNotEmpty() && shoeSize.isNotEmpty()
        }
    }

    private var currentShoeDetail: ShoeDetail? = null

    private val _listShoe = MutableLiveData<List<ShoeDetail>>()
    val listSHoe: LiveData<List<ShoeDetail>>
        get() = _listShoe

    fun initNewShoe(): ShoeDetail {
        currentShoeDetail = ShoeDetail()
        return currentShoeDetail!!
    }

    fun saveCurrentDetail() {
        currentShoeDetail?.let {
            _listShoe.value = (_listShoe.value ?: emptyList()) + it
        }
    }

}