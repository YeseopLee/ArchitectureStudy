package com.example.architecture.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.architecture.R
import com.example.architecture.data.model.RepoGetResponse
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.data.model.UserGetResponse
import com.example.architecture.ui.adapter.SearchAdapter
import com.example.howareyou.network.RetrofitClient
import com.example.howareyou.network.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    private var service: ServiceApi? = null

    private val ARG_PARAM1 = "param1"
    private val ARG_PARAM2 = "param2"

    private var searchArray: ArrayList<RepoSearchResponse.RepoItem> = arrayListOf()
    private var repoDTO: ArrayList<RepoGetResponse> = arrayListOf()

    private lateinit var searchAdapter: SearchAdapter

    private lateinit var searchQuery: String
    private lateinit var owner : String
    private lateinit var name : String

    private lateinit var recyclerView : RecyclerView
    private lateinit var loadingLayout : ConstraintLayout

    private lateinit var btn_search : Button
    private lateinit var et_search : EditText
    private lateinit var tv_totalCount : TextView

    fun newInstance(param1: String?, param2: String?): DetailFragment? {
        val fragment = DetailFragment()
        val args = Bundle()
        args.putString(ARG_PARAM1, param1)
        args.putString(ARG_PARAM2, param2)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        service = RetrofitClient.client!!.create(ServiceApi::class.java)

        recyclerView = view.findViewById(R.id.search_recyclerview)
        loadingLayout = view.findViewById(R.id.search_layout_loading)
        btn_search = view.findViewById(R.id.search_button_search)
        et_search = view.findViewById(R.id.search_edittext_search)
        tv_totalCount = view.findViewById(R.id.search_textview_totalCount)

        initListner()
        initAdapter()

    }

    private fun initListner(){

        btn_search.setOnClickListener {
            attemptSearch()
        }
    }

    private fun initAdapter(){

        searchAdapter = SearchAdapter(activity!!, searchArray)
        val lm = LinearLayoutManager(activity!!)
        recyclerView.layoutManager = lm
        recyclerView.adapter = searchAdapter

        searchAdapter.setItemClickListener(object : SearchAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                owner = searchArray[position].owner.login
                name = searchArray[position].name
                (activity as MainActivity?)!!.replaceFragment(DetailFragment(),owner,name)
            }
        })

    }

    fun newInstance(): SearchFragment? {
        return SearchFragment()
    }

    // 검색 유효성 검사
    private fun attemptSearch(){
        et_search.error = null
        searchQuery = et_search.text.toString()
        var cancel = false
        var focusView: View? = null

        if(searchQuery.isEmpty()){ // 검색어가 공백일 경우
            et_search.error = "검색어를 입력하세요."
            focusView = et_search
            cancel = true
        }

        if(cancel){
            focusView?.requestFocus()
        } else {
            getSearch(searchQuery)
        }
    }

    private fun getSearch(query: String){
        showProgress(true)
        service?.searchRepo(query)?.enqueue(object : Callback<RepoSearchResponse?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<RepoSearchResponse?>,
                response: Response<RepoSearchResponse?>
            ) {
                if (response.isSuccessful) {
                    showProgress(false)
                    val result = response.body()!!
                    tv_totalCount.text = result.total_count.toString() + "개의 검색 결과가 있습니다."

                    searchArray.clear()
                    Log.e("size", result.items.size.toString())
                    for (i in 0 until result.items.size) {
                        searchArray.add(
                            RepoSearchResponse.RepoItem(
                                result.items[i].archive_url,
                                result.items[i].full_name,
                                result.items[i].name,
                                result.items[i].private,
                                result.items[i].owner
                            )
                        )
                    }

                    searchAdapter.notifyDataSetChanged()
                } else { //통신에러
                    showProgress(false)
                }
            }

            override fun onFailure(call: Call<RepoSearchResponse?>?, t: Throwable) {
                //통신에러
                showProgress(false)
            }
        })
    }

    private fun showProgress(show: Boolean){
        loadingLayout.visibility = (if (show) View.VISIBLE else View.GONE)
    }


}