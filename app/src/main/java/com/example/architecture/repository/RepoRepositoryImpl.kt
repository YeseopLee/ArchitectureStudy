package com.example.architecture.repository

import android.annotation.SuppressLint
import android.view.View
import com.example.architecture.data.BaseResponse
import com.example.architecture.data.model.RepoDetailModel
import com.example.architecture.data.model.RepoGetResponse
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.data.model.UserGetResponse
import com.example.howareyou.network.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRepositoryImpl(

    private val service : ServiceApi

) : RepoRepository {

    override fun searchRepo(query: String, callback: BaseResponse<RepoSearchResponse>) {
        callback.onLoading()
        service.searchRepo(query).enqueue(object : Callback<RepoSearchResponse?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<RepoSearchResponse?>,
                response: Response<RepoSearchResponse?>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()!!
                    callback.onSuccess(body)
                } else { //통신에러
                    callback.onFail(response.message())
                }

                callback.onLoaded()
            }

            override fun onFailure(call: Call<RepoSearchResponse?>?, t: Throwable) {
                //통신에러
                callback.onError(t)
                callback.onLoaded()
            }
        })
    }

    override fun getDetail(owner: String, name: String, callback: BaseResponse<RepoDetailModel>) {
        callback.onLoading()
        service.getRepo(owner, name).enqueue(object : Callback<RepoGetResponse?> {
            override fun onResponse(
                call: Call<RepoGetResponse?>,
                response: Response<RepoGetResponse?>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()!!
                    val RepoModel = body

                    service.getUser(owner)
                        .enqueue(object : Callback<UserGetResponse?>{
                            override fun onResponse(
                                call: Call<UserGetResponse?>,
                                response: Response<UserGetResponse?>
                            ) {
                                if(response.isSuccessful){
                                    val body = response.body()!!
                                    val userModel = body

                                    callback.onSuccess(
                                        RepoDetailModel(
                                            full_name = RepoModel.full_name,
                                            watchers_count = RepoModel.watchers_count,
                                            stargazers_count = RepoModel.stargazers_count,
                                            forks_count = RepoModel.forks_count,
                                            language = RepoModel.language,
                                            login = userModel.login,
                                            avatar_url = userModel.avatar_url,
                                            blog = userModel.blog,
                                            followers = userModel.followers,
                                            following = userModel.following

                                        )
                                    )
                                } else {
                                    callback.onFail(response.message())
                                }

                                callback.onLoaded()
                            }

                            override fun onFailure(call: Call<UserGetResponse?>, t: Throwable) {
                                callback.onError(t)
                                callback.onLoaded()
                            }
                        })

                } else { //통신에러
                    callback.onFail(response.message())
                    callback.onLoaded()
                }
            }

            override fun onFailure(call: Call<RepoGetResponse?>?, t: Throwable) {
                //통신에러
                callback.onError(t)
                callback.onLoaded()
            }
        })
    }

}

