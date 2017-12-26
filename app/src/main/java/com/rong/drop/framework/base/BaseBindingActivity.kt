package com.rong.drop.framework.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.rong.drop.DropApplication
import com.rong.drop.utils.TextUtils

/**
 * Created by chen.huarong on 2017/11/20.
 */

abstract class BaseBindingActivity<V : BaseView, VM : BaseViewModel, Binding : ViewDataBinding> : AppCompatActivity(), View.OnClickListener {

    lateinit var view: V
    lateinit var viewModel: VM
    abstract val layoutId: Int
    lateinit var binding : Binding
    abstract fun initView()
    abstract fun buildViewModel(): VM
    abstract fun getIView(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<Binding>(this, layoutId)
        initValue()
        view = getIView()
        viewModel = buildViewModel()
//        binding.setVariable(BR.viewModel, viewModel)
//        binding.setVariable(BR.onclickListener, this)
        initView()
    }

    open fun initValue() {

    }

    fun setTypeface(typeface: String, textView: TextView) {
        TextUtils.setTypeFace(typeface, textView)
    }

    override fun onResume() {
        super.onResume()
        DropApplication.mCurrentActivity = this
    }

    override fun onClick(v: View?) {

    }

}
