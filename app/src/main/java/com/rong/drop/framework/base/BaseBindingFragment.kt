package com.rong.drop.framework.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.TextView
import com.rong.drop.BR
import com.rong.drop.utils.TextUtils

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
        binding = DataBindingUtil.setContentView<Binding>(activity, layoutId)
        initValue()
        view = getIView()
        viewModel = buildViewModel()
        binding.setVariable(BR.viewModel, viewModel)
        binding.setVariable(BR.onclickListener, this)
        initView(savedInstanceState)
    }

    open fun initValue() {

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onClick(v: View?) {

    }

}
