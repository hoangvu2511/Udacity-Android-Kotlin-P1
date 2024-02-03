package com.udacity.shoestore.fragment.login

import androidx.fragment.app.viewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.base.BaseFragment
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun init() {
        binding.user = loginViewModel.user
        binding.loginViewModel = loginViewModel
        loginViewModel.onComplete.observe(viewLifecycleOwner) {
            if (it) {
                //TODO navigate to Welcome Screen
                navController.navigate(LoginFragmentDirections.moveToWelcome())
            }
        }
    }
}