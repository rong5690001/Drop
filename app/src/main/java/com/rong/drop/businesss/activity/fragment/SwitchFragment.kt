package com.rong.drop.businesss.activity.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import com.rong.drop.R
import com.rong.drop.framework.simple.SimpleFragment


/**
 * A simple [Fragment] subclass.
 */
class SwitchFragment : SimpleFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_switch

    companion object {
        fun newFragment(): SwitchFragment {
            return SwitchFragment()
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

}// Required empty public constructor
