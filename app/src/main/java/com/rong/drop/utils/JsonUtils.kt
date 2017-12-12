package com.rong.drop.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.stream.JsonReader

/**
 * Created by Administrator on 2017/12/12/012.
 */
object JsonUtils {

    fun <T> parseFile(context: Context, _class:Class<T>, resId:Int): T {
        var gson = Gson()
        var inputStream = context.resources.openRawResource(resId)
        var jsonReader = JsonReader(inputStream.reader())
        return gson.fromJson<T>(jsonReader, _class)
    }

}