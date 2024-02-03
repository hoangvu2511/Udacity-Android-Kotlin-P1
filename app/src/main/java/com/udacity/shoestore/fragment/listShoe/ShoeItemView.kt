package com.udacity.shoestore.fragment.listShoe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.databinding.ViewShoeItemBinding

class ShoeItemView(context: Context) : FrameLayout(context) {

    private val binding: ViewShoeItemBinding

    init {
        binding = ViewShoeItemBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

    fun setDetail(shoeDetail: MainViewModel.ShoeDetail) {
        binding.detail = shoeDetail
    }

    override fun getRootView(): View {
        return binding.root
    }
}