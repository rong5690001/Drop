package com.rong.drop.viewmodel

import com.rong.drop.framework.base.BaseViewModel

/**
 * Created by chen.huarong on 2017/12/12.
 */
class BudGetCreateViewModel : BaseViewModel() {

    lateinit var bookName: String//账本名
    var moneySymbol: Int = 0//货币类型
    var account_cycle: Int = 0//结算日
    lateinit var accountBudget: String //预算金额
    lateinit var amountLeft: String//剩余金额
    var balanceRolling: Int = 1//是否滚存

}