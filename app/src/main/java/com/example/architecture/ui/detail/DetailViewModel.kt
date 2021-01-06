package com.example.architecture.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture.data.model.RepoGetResponse
import com.example.architecture.data.model.UserGetResponse
import com.example.architecture.di.module.DetailName
import com.example.architecture.di.module.DetailOwner
import com.example.howareyou.network.ServiceApi
import kotlinx.coroutines.launch

//class DetailViewModel(owner: String, name: String) @ViewModelInject constructor() : ViewModel() {
class DetailViewModel @ViewModelInject constructor(
    private val service: ServiceApi,
    @DetailOwner
    private val owner: String,
    @DetailName
    private val name: String
) : ViewModel() {

    var repoDTO = MutableLiveData<RepoGetResponse>()
    var userDTO = MutableLiveData<UserGetResponse>()
    var loading = MutableLiveData<Boolean>()

    init {
        loading.value = false

        getRepo(owner, name)
        getUser(owner)
    }

    fun getRepo(owner: String, name: String) {
        loading.value = true

        viewModelScope.launch {
            val repoInfo = service.getRepo(owner,name)
            repoDTO.value = repoInfo
            loading.value = false
        }
    }

    fun getUser(owner: String) {
        loading.value = true

        viewModelScope.launch {
            val userInfo = service.getUser(owner)
            userDTO.value = userInfo
            loading.value = false
        }
    }

}