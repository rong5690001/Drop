package com.rong.drop.framework.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.rong.drop.utils.TextUtils

/**
 * Created by chen.huarong on 2017/11/20.
 */

abstract class BaseActivity<P : BasePresenter<V, VM>, V : BaseView, VM : BaseViewModel> : AppCompatActivity() {

    var presenter: P? = null
    lateinit var view: V
    lateinit var viewModel: VM
    abstract val layoutId: Int
    abstract fun initView()
    abstract fun buildPresenter(): P
    abstract fun buildViewModel(): VM
    abstract fun getIView(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initView()
        view = getIView()
        viewModel = buildViewModel()
        presenter = buildPresenter()
        presenter?.attachView(view, viewModel)
    }

    fun setTypeface(typeface: String, textView: TextView) {
        TextUtils.setTypeFace(typeface, textView)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }

    fun getViewModel() = {
        viewModel
    }
}
