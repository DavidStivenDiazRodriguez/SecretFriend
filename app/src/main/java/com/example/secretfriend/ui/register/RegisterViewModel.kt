package com.example.secretfriend.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.secretfriend.Repository.RegisterRepository
import com.example.secretfriend.Retrofit.User
import kotlinx.coroutines.launch

class RegisterViewModel(private val registerRepository: RegisterRepository) : ViewModel() {

    //Llamado de método para guardar un nuevo registro
    fun postRegisterUser(user: User) {
        viewModelScope.launch {
            registerRepository.registerUser(user)
        }
    }

}