package com.rong.drop.base

import android.content.Context
import org.byteam.superadapter.IMulItemViewType
import org.byteam.superadapter.SuperAdapter

/**
 * Created by chen.huarong on 2017/11/25.
 */
abstract class BaseAdapter<T> :SuperAdapter<T>{

    constructor(context: Context?, items: MutableList<T>?, layoutResId: Int) : super(context, items, layoutResId)
    constructor(context: Context?, items: MutableList<T>?, mulItemViewType: IMulItemViewType<T>?) : super(context, items, mulItemViewType)

}