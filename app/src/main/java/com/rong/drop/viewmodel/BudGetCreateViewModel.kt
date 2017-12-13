package com.rong.drop.viewmodel

import com.rong.drop.framework.base.BaseViewModel

/**
 * Created by chen.huarong on 2017/12/12.
 */
class BudGetCreateViewModel : BaseViewModel() {

    lateinit var bookName: String//账本名
    lateinit var moneySymbol: String//货币类型
    var account_cycle: Int = 0//结算日
    var accountBudget: Int = 0//预算金额
    var amountLeft: Int = 0//剩余金额

}