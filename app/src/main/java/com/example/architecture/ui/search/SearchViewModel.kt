package com.example.architecture.ui.search

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture.data.model.RepoSearchResponse
import com.example.howareyou.network.RetrofitClient
import com.example.howareyou.network.ServiceApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    private var service: ServiceApi = RetrofitClient.client!!.create(ServiceApi::class.java)

    var searchArray = MutableLiveData<ArrayList<RepoSearchResponse.RepoItem>>()
    var totalCount = MutableLiveData<Int>()
    var query = MutableLiveData<String>()
    var loading = MutableLiveData<Boolean>()

    init {
        query.value = ""
        totalCount.value = 0
        loading.value = false
    }

    fun getSearch(query: String) {
        //로딩 시작
        loading.value = true

        viewModelScope.launch {
            val searchRepoInfo = service.searchRepo(query)
            searchArray.value = searchRepoInfo.items
            totalCount.value = searchRepoInfo.total_count

            // 로딩 끝
            loading.value = false
        }
    }

}

