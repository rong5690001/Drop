package com.rong.drop.utils

import android.widget.Toast

import com.rong.drop.DropApplication

/**
 * Created by chen.huarong on 2017/11/25.
 */

object ToastUtil {

    fun makeToast(value: String) {
        Toast.makeText(DropApplication.getContext(), value, Toast.LENGTH_SHORT).show()
    }

}
