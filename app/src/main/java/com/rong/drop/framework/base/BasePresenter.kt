package com.rong.drop.framework.base

import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by chen.huarong on 2017/12/8.
 */

open class BasePresenter<V, VM> @Inject constructor(){

    private var mViewRef: WeakReference<V>? = null
    private var mViewModelRef: WeakReference<VM>? = null

    fun attachView(view: V, viewModel:VM) {
        mViewRef = WeakReference(view)
        mViewModelRef = WeakReference(viewModel)
    }

    fun detachView() {
        if (mViewRef != null) {
            mViewRef!!.clear()
            mViewRef = null
        }
        if (mViewModelRef != null) {
            mViewModelRef!!.clear()
            mViewModelRef = null
        }
    }

    fun getView() = {
        checkNotNull(mViewRef)
        mViewRef!!.get()
    }

    fun getViewModel() = {
        checkNotNull(mViewModelRef)
        mViewModelRef!!.get()
    }
}
