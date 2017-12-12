package com.rong.drop

import com.rong.drop.bean.AddBillBean
import com.rong.drop.utils.JsonUtils

/**
 * Created by Administrator on 2017/12/12/012.
 */
object DictData {

    lateinit var addBillDicts: Array<AddBillBean> = {

    }

    fun getAddBillDicts() = {
        if (addBillDicts == null || addBillDicts.isEmpty()) {
            addBillDicts = JsonUtils.parseFile(DropApplication.mCurrentActivity
                    , Array<AddBillBean>::class.java, R.raw.addbill)
        }
        addBillDicts
    }
}