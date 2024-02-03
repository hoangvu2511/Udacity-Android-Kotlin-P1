package com.udacity.shoestore.fragment.shoeDetail

import android.view.View
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentDetailShoeBinding

class FragmentShoeDetail : BaseFragment<FragmentDetailShoeBinding>(R.layout.fragment_detail_shoe),
    View.OnClickListener {
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun init() {
        binding.shoeDetail = mainViewModel.initNewShoe()
        binding.listener = this

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCancel -> navController.popBackStack()
            R.id.btnSave -> {
                mainViewModel.saveCurrentDetail()
                navController.popBackStack()
            }
        }
    }
}