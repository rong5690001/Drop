package com.rong.drop.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.rong.drop.utils.TextUtils

/**
 * Created by chen.huarong on 2017/11/20.
 */

abstract class BaseActivity<P : BasePresenter<BaseView>> : AppCompatActivity() {

    var presenter: P? = null
    abstract val layoutId: Int
    abstract fun initView()
    abstract fun buildPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initView()
        presenter = buildPresenter()
        checkNotNull(presenter)
    }

    fun setTypeface(typeface: String, textView: TextView) {
        TextUtils.setTypeFace(typeface, textView)
    }
}
