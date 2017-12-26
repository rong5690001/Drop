package com.rong.drop.viewmodel;

import android.databinding.ObservableField;

import com.rong.drop.framework.base.BaseViewModel;

/**
 * Created by Administrator on 2017/12/26/026.
 */

public class MainViewModel extends BaseViewModel {

    public ObservableField accountBudget = new ObservableField<String>();
//    private val mRealm = Realm.getDefaultInstance()

//    fun getData(){
//        mRealm.beginTransaction()
//        val accountBookNode = mRealm.where(AccountBookNode::class.java).findFirst()
//        accountBudget.set(accountBookNode.account_budget)
//        mRealm.close()
//    }


}
