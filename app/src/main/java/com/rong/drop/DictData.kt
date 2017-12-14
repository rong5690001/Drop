package com.rong.drop

import com.rong.drop.bean.DictBean
import com.rong.drop.utils.JsonUtils

/**
 * Created by Administrator on 2017/12/12/012.
 */
object DictData {

    val addBillDicts: Array<DictBean>
        get() = JsonUtils.parseFile(DropApplication.mCurrentActivity
                , Array<DictBean>::class.java, R.raw.addbill)
    val moneySymbolDicts: Array<DictBean>
        get() = JsonUtils.parseFile(DropApplication.mCurrentActivity
                , Array<DictBean>::class.java, R.raw.moneysymbol)

//    fun getMoneySymbolDicts() {
//        if (moneySymbolDicts == null || moneySymbolDicts.isEmpty()) {
//            moneySymbolDicts = JsonUtils.parseFile(DropApplication.mCurrentActivity
//                    , Array<DictBean>::class.java, R.raw.moneysymbol)
//        }
//        moneySymbolDicts
//    }
}