package com.rong.drop.businesss.activity.fragment

import android.os.Bundle
import com.rong.drop.R
import com.rong.drop.base.BaseFragment
import com.rong.drop.utils.TextUtils
import kotlinx.android.synthetic.main.fragment_create_bug_get_name.*

class CreateBugGetNameFragment : BaseFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_create_bug_get_name

    override fun initView(savedInstanceState: Bundle?) {
        setTypeface(TextUtils.MONTSERRAT_REGULAR, editText)
        setTypeface(TextUtils.OPENSANS_REGULAR, hint)
    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment CreateBugGetNameFragment.
         */
        fun newInstance(): CreateBugGetNameFragment {
            return CreateBugGetNameFragment()
        }
    }
}// Required empty public constructor
