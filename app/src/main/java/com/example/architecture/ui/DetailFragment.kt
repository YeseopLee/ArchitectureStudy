package com.example.architecture.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.architecture.R
import com.example.architecture.data.model.RepoGetResponse
import com.example.architecture.data.model.UserGetResponse
import com.example.howareyou.network.RetrofitClient
import com.example.howareyou.network.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFragment : Fragment() {

    private var service: ServiceApi? = null

    private lateinit var mParam1: String
    private lateinit var mParam2: String

    private var repoDTO: ArrayList<RepoGetResponse> = arrayListOf()
    private var userDTO: ArrayList<UserGetResponse> = arrayListOf()

    private lateinit var iv_profile: ImageView
    private lateinit var tv_fullname: TextView
    private lateinit var tv_watch: TextView
    private lateinit var tv_star: TextView
    private lateinit var tv_fork: TextView
    private lateinit var tv_follower: TextView
    private lateinit var tv_following: TextView
    private lateinit var tv_owner: TextView
    private lateinit var tv_language: TextView
    private lateinit var loadingLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString("owner").toString()
            mParam2 = arguments!!.getString("name").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        service = RetrofitClient.client!!.create(ServiceApi::class.java)

        iv_profile = view.findViewById(R.id.detail_imageview_profile)
        tv_fullname = view.findViewById(R.id.detail_textview_fullname)
        tv_watch = view.findViewById(R.id.detail_textview_watch)
        tv_fork = view.findViewById(R.id.detail_textview_fork)
        tv_star = view.findViewById(R.id.detail_textview_star)
        tv_follower = view.findViewById(R.id.detail_textview_follower)
        tv_following = view.findViewById(R.id.detail_textview_following)
        tv_language = view.findViewById(R.id.detail_textview_language)
        tv_owner = view.findViewById(R.id.detail_textview_owner)
        loadingLayout = view.findViewById(R.id.detail_layout_loading)

        Log.e("owner",mParam1)
        Log.e("name",mParam2)

        getRepo(mParam1,mParam2)
        getUser(mParam1)

    }

    private fun getRepo(owner: String, name: String){
        showProgress(true)
        service?.getRepo(owner, name)?.enqueue(object : Callback<RepoGetResponse?> {
            override fun onResponse(
                call: Call<RepoGetResponse?>,
                response: Response<RepoGetResponse?>
            ) {
                if (response.isSuccessful) {
                    showProgress(false)
                    val result = response.body()!!
                    repoDTO.add(
                        RepoGetResponse(
                            result.full_name,
                            result.watchers_count,
                            result.stargazers_count,
                            result.forks_count,
                            result.language
                        )
                    )

                    tv_fullname.text = result.full_name
                    tv_watch.text = result.watchers_count.toString()
                    tv_fork.text = result.forks_count.toString()
                    tv_star.text = result.stargazers_count.toString()
                    tv_language.text = result.language

                } else { //통신에러
                    showProgress(false)
                }
            }

            override fun onFailure(call: Call<RepoGetResponse?>?, t: Throwable) {
                //통신에러
                showProgress(false)
            }
        })
    }

    private fun getUser(owner: String){
        showProgress(true)
        service?.getUser(owner)?.enqueue(object : Callback<UserGetResponse?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<UserGetResponse?>,
                response: Response<UserGetResponse?>
            ) {
                if (response.isSuccessful) {
                    showProgress(false)
                    val result = response.body()!!
                    userDTO.add(
                        UserGetResponse(
                            result.login,
                            result.avatar_url,
                            result.blog,
                            result.followers,
                            result.following
                        )
                    )
                    tv_owner.text = result.login
                    tv_follower.text = "follower: "+result.followers.toString()
                    tv_following.text = "following: "+result.following.toString()
                    Glide.with(view!!).load(result.avatar_url).into(iv_profile)

                } else { //통신에러
                    showProgress(false)
                }
            }

            override fun onFailure(call: Call<UserGetResponse?>?, t: Throwable) {
                //통신에러
                showProgress(false)
            }
        })
    }

    private fun showProgress(show: Boolean){
        loadingLayout.visibility = (if (show) View.VISIBLE else View.GONE)
    }

}