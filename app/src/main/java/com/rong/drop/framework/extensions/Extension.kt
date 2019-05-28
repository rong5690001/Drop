package com.rong.drop.framework.extensions

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast

/**
 * Created by chen.huarong on 2018/1/18.
 */
/////////////////////////////////////////////extension////////////////////////
/**
 * 获取最后一位字符
 */
fun String.getLastChar(): Char {
    return this[this.length]
}

/**
 * 移除最后一位字符
 */
fun String.removeLastChar(string: String) {
    var lastIndexOf = this.lastIndexOf(string)
    if (lastIndexOf > -1) {
        this.substring(kotlin.ranges.IntRange(0, lastIndexOf))
    }
}

fun TextView.setTypefaceExtension(typeface: String) {
    this.typeface = Typeface.createFromAsset(this.context?.assets, typeface)
}

fun AppCompatActivity.makeToast(value: String) {
    Toast.makeText(this.applicationContext, value, Toast.LENGTH_SHORT).show()
}

/**
 * 精确到小数点后几位
 */
fun Float.pinpoint(count: Int): Float {
    1.22
    var offset = Math.pow(10.toDouble(), count.toDouble())
    return (this * offset).toInt().toFloat() / offset.toFloat()
//    var format = "0"
//    var i = 0
//    while (i < count) {
//        format += ".0"
//        i++
//    }
//    val decimalFormat = DecimalFormat(format)
//    println(decimalFormat.format(this))
//    return decimalFormat.format(this).toFloat()
}