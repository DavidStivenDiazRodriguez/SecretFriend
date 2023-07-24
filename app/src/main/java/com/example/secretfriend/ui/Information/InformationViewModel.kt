package com.example.secretfriend.ui.Information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.secretfriend.Repository.Repository
import com.example.secretfriend.Retrofit.UserResponse
import kotlinx.coroutines.launch

class InformationViewModel(private val repository: Repository) : ViewModel() {

    private val _gifts = MutableLiveData<UserResponse>()
    val gifts: LiveData<UserResponse> get()= _gifts

    //obtiene la informacion del parcticipante del repositorio por el username
    fun getGiftByUserName(username: String){
        viewModelScope.launch {
            _gifts.value =  repository.getFriendByUserName(username)
        }
    }


}