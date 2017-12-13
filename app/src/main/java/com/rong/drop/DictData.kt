package com.rong.drop

import com.rong.drop.bean.DictBean
import com.rong.drop.utils.JsonUtils

/**
 * Created by Administrator on 2017/12/12/012.
 */
object DictData {

    lateinit var addBillDicts: Array<DictBean>
    val moneySymbolDicts: Array<DictBean>
        get() = JsonUtils.parseFile(DropApplication.mCurrentActivity
                , Array<DictBean>::class.java, R.raw.moneysymbol)

    fun getAddBillDicts() = {
        if (addBillDicts == null || addBillDicts.isEmpty()) {
            addBillDicts = JsonUtils.parseFile(DropApplication.mCurrentActivity
                    , Array<DictBean>::class.java, R.raw.addbill)
        }
        addBillDicts
    }

//    fun getMoneySymbolDicts() {
//        if (moneySymbolDicts == null || moneySymbolDicts.isEmpty()) {
//            moneySymbolDicts = JsonUtils.parseFile(DropApplication.mCurrentActivity
//                    , Array<DictBean>::class.java, R.raw.moneysymbol)
//        }
//        moneySymbolDicts
//    }
}