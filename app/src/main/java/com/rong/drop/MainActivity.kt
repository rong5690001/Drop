package com.rong.drop

import com.rong.drop.base.BaseActivity
import com.rong.drop.utils.SystemBarUtil
import com.rong.drop.utils.TextUtils
import com.rong.drop.utils.ToastUtil
import com.rong.drop.widget.MetaballDebugView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MetaballDebugView.MetaballListener {

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView() {
        SystemBarUtil.immersiveStatusBar(this, 0f)
        setTypeface(TextUtils.MONTSERRAT_BOLD, mainTitle)
        setTypeface(TextUtils.SPOON_BOLD, totalCapital)
        setTypeface(TextUtils.MONTSERRAT_REGULAR, hint)
        metaballDebugView.setMetaballListener(this)
    }

    override fun onIncome() {
        ToastUtil.makeToast("收入")
    }

    override fun onExpend() {
        ToastUtil.makeToast("支出")
    }
}
