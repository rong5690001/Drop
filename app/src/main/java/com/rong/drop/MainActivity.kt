package com.rong.drop

import android.os.Bundle
import com.rong.drop.R.id.mainTitle
import com.rong.drop.R.id.totalCapital
import com.rong.drop.base.BaseActivity
import com.rong.drop.utils.SystemBarUtil
import com.rong.drop.utils.TextUtils

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SystemBarUtil.immersiveStatusBar(this, 0f)
        setTypeface(TextUtils.MONTSERRAT_BOLD, findViewById(mainTitle))
        setTypeface(TextUtils.SPOON_BOLD, findViewById(totalCapital))
    }
}
