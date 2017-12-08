package com.rong.drop.base

import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by chen.huarong on 2017/12/8.
 */
class BasePresenter<T> @Inject constructor() {

    var mViewRef: WeakReference<T>? = null

    fun attachView(t: T) {
        mViewRef = WeakReference(t)
    }

    fun detachView() {
        checkNotNull(mViewRef)
        mViewRef!!.clear()
        mViewRef = null
    }

}