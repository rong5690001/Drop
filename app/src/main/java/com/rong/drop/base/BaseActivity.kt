package com.rong.drop.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.rong.drop.utils.TextUtils

/**
 * Created by chen.huarong on 2017/11/20.
 */

abstract class BaseActivity : AppCompatActivity() {

    abstract val layoutId: Int
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initView()
    }

    fun setTypeface(typeface: String, textView: TextView) {
        TextUtils.setTypeFace(typeface, textView)
    }
}
