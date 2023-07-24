package com.example.secretfriend

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.secretfriend.Repository.Repository

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    constructor(context: Context): this(Repository(context))

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repository::class.java).newInstance(repository)
    }

}