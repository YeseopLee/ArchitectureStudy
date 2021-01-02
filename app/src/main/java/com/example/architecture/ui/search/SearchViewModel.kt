package com.example.architecture.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.repository.SearchRepository
import kotlinx.coroutines.launch


class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel() {

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
            val searchRepoInfo = searchRepository.searchRepo(query)
            searchArray.value = searchRepoInfo.items
            totalCount.value = searchRepoInfo.total_count
            // 로딩 끝
            loading.value = false
        }
    }


}

