package com.rong.drop.framework.base

import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by chen.huarong on 2017/12/8.
 */

open class BasePresenter<V, VM> @Inject constructor() {

    private var mViewRef: WeakReference<V>? = null
    private var mViewModelRef: WeakReference<VM>? = null

    fun attachView(view: V, viewModel: VM) {
        mViewRef = WeakReference(view)
        mViewModelRef = WeakReference(viewModel)
    }

    fun detachView() {
        mViewRef?.clear()
        mViewRef = null
        mViewModelRef?.clear()
        mViewModelRef = null
    }

    fun getView() = {
        mViewRef?.get()
    }

    fun getViewModel() = {
        mViewModelRef?.get()
    }
}
