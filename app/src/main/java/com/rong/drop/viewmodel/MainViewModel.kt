package com.rong.drop.viewmodel

import android.databinding.ObservableField
import com.rong.drop.`object`.BudgetObject
import com.rong.drop.database.AccountBookNode

import com.rong.drop.framework.base.BaseViewModel
import io.realm.Realm

/**
 * Created by Administrator on 2017/12/26/026.
 */

class MainViewModel : BaseViewModel() {

    var accountBudget = ObservableField<String>()
    private val mRealm = Realm.getDefaultInstance()
    var moneySymbol = "$"

    fun getData() {
        mRealm.beginTransaction()
        val accountBookNode = mRealm.where(AccountBookNode::class.java).findFirst()
        var typeName = accountBookNode.mAccountTypeNode.typeName
        if (!typeName.isBlank()) {
            moneySymbol = typeName.substring(IntRange(0, 0))
        }
        accountBudget.set(moneySymbol + accountBookNode.account_budget)
        BudgetObject.moneySymbol = moneySymbol
        BudgetObject.account_budget = accountBookNode.account_budget
        BudgetObject.bookId = accountBookNode.bookId
        BudgetObject.accountTypeId = accountBookNode.mAccountTypeNode.typeId
        mRealm.close()

    }


}
