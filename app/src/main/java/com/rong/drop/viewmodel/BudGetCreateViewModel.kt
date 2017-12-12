package com.rong.drop.viewmodel

import com.rong.drop.framework.base.BaseViewModel

/**
 * Created by chen.huarong on 2017/12/12.
 */
class BudGetCreateViewModel : BaseViewModel() {

    lateinit var bookName: String
    lateinit var typeName: String
    var accountBudget: Int = 0
    var amountLeft: Int = 0

}