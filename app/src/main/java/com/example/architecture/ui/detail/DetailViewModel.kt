package com.example.architecture.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture.MyApplication
import com.example.architecture.data.model.RepoGetResponse
import com.example.architecture.data.model.UserGetResponse
import com.example.howareyou.network.ServiceApi
import kotlinx.coroutines.launch

//class DetailViewModel(owner: String, name: String) @ViewModelInject constructor() : ViewModel() {
class DetailViewModel @ViewModelInject constructor(
    private val service: ServiceApi
) : ViewModel() {

    var repoDTO = MutableLiveData<RepoGetResponse>()
    var userDTO = MutableLiveData<UserGetResponse>()
    var loading = MutableLiveData<Boolean>()

    init {
        loading.value = false

        val owner = MyApplication.prefs.selectedOwner
        val name = MyApplication.prefs.selectedName

        getRepo(owner, name)
        getUser(owner)
    }

    private fun getRepo(owner: String, name: String) {
        loading.value = true

        viewModelScope.launch {
            val repoInfo = service.getRepo(owner,name)
            repoDTO.value = repoInfo
            loading.value = false
        }
    }

    private fun getUser(owner: String) {
        loading.value = true

        viewModelScope.launch {
            val userInfo = service.getUser(owner)
            userDTO.value = userInfo
            loading.value = false
        }
    }

}