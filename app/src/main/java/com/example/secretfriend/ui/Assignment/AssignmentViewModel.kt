package com.example.secretfriend.ui.Assignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.secretfriend.Repository.Repository
import kotlinx.coroutines.launch

class AssignmentViewModel(private val repository: Repository) : ViewModel() {

    private val _usernames = MutableLiveData<List<String>>()
    val usernames: LiveData<List<String>> get()= _usernames

    //Obtiene la lista de username del repositorio
    fun getUsersByUserName(){
        viewModelScope.launch {
            _usernames.value =  repository.getFriend()
        }
    }
}