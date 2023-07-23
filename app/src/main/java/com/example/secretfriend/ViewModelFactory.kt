package com.example.secretfriend

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.secretfriend.Repository.RegisterRepository

class ViewModelFactory(private val registerRepository: RegisterRepository) : ViewModelProvider.Factory {

    constructor(context: Context): this(RegisterRepository(context))

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(RegisterRepository::class.java).newInstance(registerRepository)
    }

}