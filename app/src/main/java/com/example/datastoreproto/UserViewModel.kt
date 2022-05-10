package com.example.datastoreproto

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = UserRepository(application)

    val data = repository.readProto.asLiveData()

    fun update(nama : String) = viewModelScope.launch {
        repository.updateData(nama)
    }
}