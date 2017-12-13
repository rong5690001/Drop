package com.rong.drop.businesss.activity.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import com.rong.drop.R
import com.rong.drop.businesss.activity.BudGetCreateActivity
import com.rong.drop.framework.simple.SimpleFragment
import kotlinx.android.synthetic.main.fragment_switch.*

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
        switchBtn.setOnCheckedChangeListener { _, p1 ->
            (activity as BudGetCreateActivity).viewModel.balanceRolling = if (p1) 0 else 1
        }
    }

}// Required empty public constructor
