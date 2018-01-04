package com.rong.drop.viewmodel

import android.databinding.ObservableField
import android.databinding.ObservableFloat
import com.rong.drop.R
import com.rong.drop.framework.base.BaseViewModel

/**
 * Created by Administrator on 2017/12/24/024.
 */
class MyBudgetsViewModel : BaseViewModel() {

    var title = ObservableField<String>(getString(R.string.income))
    var moneySymbol = ObservableField<String>("¥")
    var money = ObservableFloat()
}