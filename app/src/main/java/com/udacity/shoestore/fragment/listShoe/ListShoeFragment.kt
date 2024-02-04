package com.udacity.shoestore.fragment.listShoe

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
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
                    ShoeItemView(context ?: return@forEach).also { v ->
                        v.setDetail(detail)
                    }
                )
            }
        }
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.list_shoe_screen_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.logout -> {
                        navController.navigate(ListShoeFragmentDirections.logout())
                        requireActivity().removeMenuProvider(this)
                        true
                    }

                    else -> false
                }
            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fabAdd -> {
                navController.navigate(ListShoeFragmentDirections.moveToDetail())
            }
        }
    }
}