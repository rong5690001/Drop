package com.rong.drop.framework.base

import android.content.Context
import org.byteam.superadapter.IMulItemViewType
import org.byteam.superadapter.SuperAdapter

/**
 * Created by chen.huarong on 2017/11/25.
 */
abstract class BaseAdapter<T> :SuperAdapter<T>{

    constructor(context: Context?, items: List<T>?, layoutResId: Int) : super(context, items, layoutResId)
    constructor(context: Context?, items: List<T>?, mulItemViewType: IMulItemViewType<T>?) : super(context, items, mulItemViewType)

}