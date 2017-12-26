package com.rong.drop.viewmodel

import android.databinding.ObservableFloat
import com.rong.drop.framework.base.BaseViewModel

/**
 * Created by Administrator on 2017/12/24/024.
 */
class MyBudgetsViewModel : BaseViewModel() {

    lateinit var title: String
    lateinit var moneySymbol: String
    var money = ObservableFloat()
}