package com.rong.drop.framework.base

import java.io.Serializable

/**
 * Created by chen.huarong on 2017/12/8.
 */
open class BaseViewModel : Serializable {

    var isValid = true//为true时显示正常页面,为false时显示缺省页面

}