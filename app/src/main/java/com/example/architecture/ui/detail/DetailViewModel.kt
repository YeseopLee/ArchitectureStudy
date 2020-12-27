package com.example.architecture.ui.detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecture.data.model.RepoGetResponse
import com.example.architecture.data.model.UserGetResponse
import com.example.howareyou.network.RetrofitClient
import com.example.howareyou.network.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel(owner: String, name: String) : ViewModel() {

    private var service: ServiceApi? = null

    init {
        service = RetrofitClient.client!!.create(ServiceApi::class.java)
        getRepo(owner,name)
    }

    private fun getRepo(owner: String, name: String){
        service?.getRepo(owner, name)?.enqueue(object : Callback<RepoGetResponse?> {
            override fun onResponse(
                call: Call<RepoGetResponse?>,
                response: Response<RepoGetResponse?>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()!!

                } else { //통신에러
                }
            }

            override fun onFailure(call: Call<RepoGetResponse?>?, t: Throwable) {
                //통신에러
            }
        })
    }

    private fun getUser(owner: String){
        service?.getUser(owner)?.enqueue(object : Callback<UserGetResponse?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<UserGetResponse?>,
                response: Response<UserGetResponse?>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()!!


                } else { //통신에러
                }
            }

            override fun onFailure(call: Call<UserGetResponse?>?, t: Throwable) {
                //통신에러
            }
        })
    }
}