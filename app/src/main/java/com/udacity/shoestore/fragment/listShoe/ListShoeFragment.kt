package com.udacity.shoestore.fragment.listShoe

import android.view.View
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentListShoeBinding

class ListShoeFragment : BaseFragment<FragmentListShoeBinding>(R.layout.fragment_list_shoe),
    View.OnClickListener {
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun init() {
        binding.clickListener = this
        mainViewModel.listSHoe.observe(viewLifecycleOwner) {
            it.forEach { detail ->
                binding.shoeContainer.addView(
                    ShoeItemView(context ?: return@forEach).also {v ->
                        v.setDetail(detail)
                    }
                )
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fabAdd -> {
                navController.navigate(ListShoeFragmentDirections.moveToDetail())
            }
        }
    }
}