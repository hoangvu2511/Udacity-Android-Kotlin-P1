package com.udacity.shoestore.fragment.login

import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    class User: BaseObservable() {

        var edtEmail: String = ""
            set(value) {
                field = value
                notifyChange()
            }
        var edtPwd: String = ""
            set(value) {
                field = value
                notifyChange()
            }

        @Bindable
        fun isValid(): Boolean {
            val isEmail = Patterns.EMAIL_ADDRESS.matcher(edtEmail).find()
            return edtEmail.isNotEmpty() && isEmail && edtPwd.isNotEmpty()
        }
    }

    private val _onComplete = MutableLiveData<Boolean>()
    val onComplete: LiveData<Boolean> = _onComplete

    val user = User()

    fun onCreateNewAccount() {
        viewModelScope.launch {
            delay(500)
            _onComplete.value =  true
        }
    }

    fun onSignIn() {
        viewModelScope.launch {
            delay(500)
            _onComplete.value =  true
        }

    }
}