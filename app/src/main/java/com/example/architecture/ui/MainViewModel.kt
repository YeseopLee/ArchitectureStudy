package com.example.architecture.ui

import android.os.Bundle
import android.provider.Settings.Global.putString
import android.view.Gravity.apply
import androidx.core.view.GravityCompat.apply
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecture.R
import com.example.architecture.ui.detail.DetailFragment
import com.example.architecture.ui.search.SearchFragment

class MainViewModel : ViewModel() {


    var owner = MutableLiveData<String>()
    var name = MutableLiveData<String>()

    init {
        owner.value = ""
        name.value = ""
        replaceFragment(SearchFragment())
    }

    fun replaceFragment(fragment: Fragment?){
        FragmentManager.beginTransaction().replace(R.id.main_framelayout, fragment!!.apply {
            arguments = Bundle().apply {
                putString("owner",owner.value)
                putString("name",name.value)
            }
        })
            .commit()
    }
}