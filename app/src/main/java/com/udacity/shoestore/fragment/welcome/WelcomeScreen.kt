package com.udacity.shoestore.fragment.welcome

import android.view.View
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeScreen : BaseFragment<FragmentWelcomeBinding>(R.layout.fragment_welcome),
    View.OnClickListener {
    override fun init() {
        binding.listener = this
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnMoveNext -> {
                navController.navigate(WelcomeScreenDirections.moveToInstruction())
            }
        }
    }
}