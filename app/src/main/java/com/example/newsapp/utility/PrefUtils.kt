package com.example.newsapp.utility

import android.content.Context

object PrefUtils {

    var SEARCH = "SEARCH"

    fun clearAll(context: Context) {
        Prefs.with(context).removeAll()
    }

    fun contains(context: Context, key: String): Boolean {
        return Prefs.with(context).contains(key)
    }

    fun setStringValue(context: Context, key: String, value: String) {
        Prefs.with(context).save(key, value)
    }

    fun getStringValue(context: Context, key: String): String {
        return Prefs.with(context).getString(key, "").toString()
    }

    fun getStringValue(context: Context, key: String, defValue: String): String {
        return Prefs.with(context).getString(key, defValue).toString()
    }

    fun setIntValue(context: Context, key: String, value: Int) {
        Prefs.with(context).save(key, value)
    }

    fun setLongValue(context: Context, key: String, value: Long) {
        Prefs.with(context).save(key, value)
    }

    fun getLongValue(context: Context, key: String): Long {
        return Prefs.with(context).getLong(key, 0)!!
    }

    fun getIntValue(context: Context, key: String): Int {
        return Prefs.with(context).getInt(key, 0)!!
    }

    fun getIntValue(context: Context, key: String, defValue: Int): Int {
        return Prefs.with(context).getInt(key, defValue)!!
    }

    fun setBooleanValue(context: Context, key: String, value: Boolean) {
        Prefs.with(context).save(key, value)
    }

    fun getBooleanValue(context: Context, key: String): Boolean {
        return Prefs.with(context).getBoolean(key, false)!!
    }

    fun setObjectValue(context: Context, key: String, data: Any?) {
        //val toJson = CommunageAppApplication.gson!!.toJson(data)
        //setStringValue(context, key, toJson)
    }
}