package com.example.architecture.ui.search

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecture.data.model.RepoSearchResponse
import com.example.howareyou.network.RetrofitClient
import com.example.howareyou.network.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    private var service: ServiceApi? = null

    var searchArray = MutableLiveData<ArrayList<RepoSearchResponse.RepoItem>>()
    var totalCount = MutableLiveData<Int>()
    var query = MutableLiveData<String>()
    var loading = MutableLiveData<Boolean>()

    init {
        service = RetrofitClient.client!!.create(ServiceApi::class.java)

        query.value=""
        totalCount.value = 0
        loading.value = false
    }

    fun getSearch(query: String){
        loading.value = true
        service?.searchRepo(query)?.enqueue(object : Callback<RepoSearchResponse?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<RepoSearchResponse?>,
                response: Response<RepoSearchResponse?>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()!!
                    searchArray.value = result.items
                    totalCount.value = result.total_count

                } else { //통신에러

                }

                loading.value = false
            }

            override fun onFailure(call: Call<RepoSearchResponse?>?, t: Throwable) {
                //통신에러
                loading.value = false
            }
        })
    }

}

