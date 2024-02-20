package com.demo.myroomdatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.ViewModelLifecycle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(val repository: Repository):ViewModel() {

    val _data:MutableLiveData<Status<List<User>>> = MutableLiveData()
    val data:LiveData<Status<List<User>>> get()  = _data

    fun getData() = viewModelScope.launch {
        _data.value=Status.Processing
        _data.value=repository.getData()

    }
}