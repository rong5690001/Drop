package com.rong.drop

import android.support.v7.app.AppCompatActivity
import com.rong.drop.base.BaseActivity
import com.rong.drop.utils.SystemBarUtil
import com.rong.drop.utils.TextUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView() {
        SystemBarUtil.immersiveStatusBar(this, 0f)
        setTypeface(TextUtils.MONTSERRAT_BOLD, mainTitle)
        setTypeface(TextUtils.SPOON_BOLD, totalCapital)
        setTypeface(TextUtils.MONTSERRAT_REGULAR, hint)
    }
}
