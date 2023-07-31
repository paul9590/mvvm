package com.example.test

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SampleViewModel constructor(
) : ViewModel() {
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val sampleUseCase = SampleUseCase(SampleRepository(SampleService()))

    fun fetchUserName() {
        viewModelScope.launch {
            _userName.value = sampleUseCase.getUserName()
            Log.e("a", userName.value.toString())
        }
    }
}
