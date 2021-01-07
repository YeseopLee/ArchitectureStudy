package com.example.architecture.util

import android.content.Context
import android.content.SharedPreferences


class PreferenceDB(context: Context){

    val prefs_filename = "prefs"
    val key_selectedOwner = "owner"
    val key_selectedName = "name"

    val prefs: SharedPreferences = context.getSharedPreferences(prefs_filename, 0)

    var selectedOwner: String
        get() = prefs.getString(key_selectedOwner, "")!!
        set(value) = prefs.edit().putString(key_selectedOwner, value).apply()

    var selectedName: String
        get() = prefs.getString(key_selectedName, "")!!
        set(value) = prefs.edit().putString(key_selectedName, value).apply()


    /* get/set 함수 임의 설정. get 실행 시 저장된 값을 반환하며 default 값은 ""
     * set(value) 실행 시 value로 값을 대체한 후 저장 */
}