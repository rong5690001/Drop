package com.rong.drop.viewmodel

import com.rong.drop.DictData
import com.rong.drop.DropApplication
import com.rong.drop.R
import com.rong.drop.framework.simple.SimpleItemViewModel
import java.util.*

/**
 * Created by chen.huarong on 2017/12/13.
 */
object SimpleItemMapper {

    /**
     * 获取货币种类
     */
    fun moneySymbolMapper(): List<SimpleItemViewModel> {
        val results = mutableListOf<SimpleItemViewModel>()
        DictData.moneySymbolDicts.mapTo(results) { SimpleItemViewModel("", it.detail + it.title) }
        return results
    }

    /**
     * 获取预算开始日期
     */
    fun startDateMapper(): List<SimpleItemViewModel> {
        var results = mutableListOf<SimpleItemViewModel>()
        results.add(SimpleItemViewModel("0", DropApplication.mCurrentActivity.getString(R.string.today)))
        (1..30).mapTo(results) {
            SimpleItemViewModel(it.toString()
                    , String.format(Locale.CHINESE, DropApplication.mCurrentActivity.getString(R.string.which_day), it))
        }
        return results
    }
}