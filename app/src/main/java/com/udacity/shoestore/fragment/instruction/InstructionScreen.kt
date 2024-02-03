package com.udacity.shoestore.fragment.instruction

import android.view.View
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionScreen :
    BaseFragment<FragmentInstructionBinding>(R.layout.fragment_instruction), View.OnClickListener {


    override fun init() {
        binding.listener = this
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnMoveNext -> {
                navController.navigate(InstructionScreenDirections.moveToListShoe())
            }
        }
    }

}