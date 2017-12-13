package com.rong.drop.utils

import java.time.MonthDay
import java.util.*

/**
 * Created by chen.huarong on 2017/12/13.
 */
object TimeUtils {

//    fun getTime(dayOfMonth: Int) : Long {
//        MonthDay.now()
//    }

    fun getTodayOfMonth(): Int {
        var calender = Calendar.getInstance()
        return calender.get(Calendar.DAY_OF_MONTH)
    }
}