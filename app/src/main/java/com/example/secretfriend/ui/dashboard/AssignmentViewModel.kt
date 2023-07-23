package com.example.secretfriend.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.secretfriend.Repository.RegisterRepository
import kotlinx.coroutines.launch

class AssignmentViewModel(private val registerRepository: RegisterRepository) : ViewModel() {

    private val _usernames = MutableLiveData<List<String>>()
    val usernames: LiveData<List<String>> get()= _usernames

    //obtiene la lista de username del repositorio
    fun getUsersByUserName(){
        viewModelScope.launch {
            _usernames.value =  registerRepository.getFriend()
        }
    }
}