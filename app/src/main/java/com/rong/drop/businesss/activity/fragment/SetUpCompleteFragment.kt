package com.rong.drop.businesss.activity.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import com.rong.drop.R
import com.rong.drop.framework.simple.SimpleFragment

/**
 * A simple [Fragment] subclass.
 */
class SetUpCompleteFragment : SimpleFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_set_up_complete

    companion object {
        fun newFragment():SetUpCompleteFragment{
            return SetUpCompleteFragment()
        }
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

}
