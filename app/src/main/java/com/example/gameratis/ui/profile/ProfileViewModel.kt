package com.example.gameratis.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gameratis.LoginActivity

class ProfileViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _text = MutableLiveData<String>().apply {
        value = LoginActivity.active_user
    }
    val text: LiveData<String> = _text
}