package com.rong.drop.businesss.activity

import android.os.Bundle
import com.rong.drop.R
import com.rong.drop.base.BaseActivity

class EditActivity : BaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_edit

    override fun initView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
    }
}
