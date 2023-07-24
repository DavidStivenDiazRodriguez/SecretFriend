package com.example.secretfriend.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.secretfriend.Repository.Repository
import com.example.secretfriend.Retrofit.User
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: Repository) : ViewModel() {

    //Llamado de método para guardar un nuevo registro
    fun postRegisterUser(user: User) {
        viewModelScope.launch {
            repository.registerUser(user)
        }
    }

}