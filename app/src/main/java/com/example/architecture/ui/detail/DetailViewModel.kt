package com.example.architecture.ui.detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture.data.model.RepoGetResponse
import com.example.architecture.data.model.UserGetResponse
import com.example.howareyou.network.RetrofitClient
import com.example.howareyou.network.ServiceApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel(owner: String, name: String) : ViewModel() {

    private var service: ServiceApi = RetrofitClient.client!!.create(ServiceApi::class.java)

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