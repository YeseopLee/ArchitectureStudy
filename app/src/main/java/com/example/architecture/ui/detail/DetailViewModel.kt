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

    var repoDTO = MutableLiveData<RepoGetResponse>()
    var userDTO = MutableLiveData<UserGetResponse>()
    var loading = MutableLiveData<Boolean>()

    var owner: String
    var name: String

    init {
        service = RetrofitClient.client!!.create(ServiceApi::class.java)

        this.owner = owner
        this.name = name
        loading.value = false

        getRepo(owner,name)
        getUser(owner)
    }

    fun getRepo(owner: String, name: String){
        loading.value = true
        service?.getRepo(owner, name)?.enqueue(object : Callback<RepoGetResponse?> {
            override fun onResponse(
                call: Call<RepoGetResponse?>,
                response: Response<RepoGetResponse?>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()!!
                    repoDTO.value = result
                    Log.e("getUser",repoDTO.value.toString())

                } else { //통신에러
                    Log.e("getRepo",response.message())
                }
                loading.value = false
            }

            override fun onFailure(call: Call<RepoGetResponse?>?, t: Throwable) {
                //통신에러
                loading.value = false
            }
        })
    }

    fun getUser(owner: String){
        loading.value = true
        service?.getUser(owner)?.enqueue(object : Callback<UserGetResponse?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<UserGetResponse?>,
                response: Response<UserGetResponse?>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()!!
                    userDTO.value = result
                    Log.e("getUser",userDTO.value.toString())


                } else { //통신에러
                    Log.e("getUser",response.message())
                }
                loading.value = false
            }

            override fun onFailure(call: Call<UserGetResponse?>?, t: Throwable) {
                //통신에러
                loading.value = false
            }
        })
    }

}