package com.rong.drop.framework.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.rong.drop.BR

/**
 * Created by chen.huarong on 2018/1/18.
 */

abstract class BaseBindingFragment<V : BaseView, VM : BaseViewModel, Binding : ViewDataBinding> : Fragment(), View.OnClickListener {

    lateinit var view: V
    lateinit var viewModel: VM
    abstract val layoutId: Int
    lateinit var binding : Binding
    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun buildViewModel(): VM
    abstract fun getIView(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(activity!!, layoutId)
        initValue()
        view = getIView()
        viewModel = buildViewModel()
        binding.setVariable(BR.viewModel, viewModel)
        binding.setVariable(BR.onclickListener, this)
        initView(savedInstanceState)
    }

    open fun initValue() {

    }

    override fun onClick(v: View?) {

    }

}
