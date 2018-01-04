package com.rong.drop.utils

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.rong.drop.DropApplication

/**
 * Created by chen.huarong on 2017/12/27.
 */
object PreferencesUtils {

    val FILE_NAME = "Preferences"
    val KEY_HAS_BUDGET = "key.hasBudget"

    fun getSharedPreferences(): SharedPreferences {
        return DropApplication.getContext().getSharedPreferences(FILE_NAME, MODE_PRIVATE)
    }

    fun getEditor(): SharedPreferences.Editor {
        return getSharedPreferences().edit()
    }

    fun <T> putValue(key: String, value: T) {
        var editor = getEditor()
        if (value is Int) {
            editor.putInt(key, value)
        } else if (value is String) {
            editor.putString(key, value)
        } else if (value is Float) {
            editor.putFloat(key, value)
        } else if (value is Boolean) {
            editor.putBoolean(key, value)
        } else if (value is Long) {
            editor.putLong(key, value)
        }
        editor.apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return getSharedPreferences().getBoolean(key, defaultValue)
    }

    fun getFloat(key: String, defaultValue: Float): Float {
        return getSharedPreferences().getFloat(key, defaultValue)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return getSharedPreferences().getInt(key, defaultValue)
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return getSharedPreferences().getLong(key, defaultValue)
    }

    fun getString(key: String, defaultValue: String): String {
        return getSharedPreferences().getString(key, defaultValue)
    }

}