package com.rong.drop.businesss.activity.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.rong.drop.R
import com.rong.drop.businesss.activity.BugGetCreateActivity
import com.rong.drop.framework.simple.SimpleFragment
import com.rong.drop.utils.TextUtils
import kotlinx.android.synthetic.main.fragment_create_bug_get_name.*

class CreateBugGetNameFragment : SimpleFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_create_bug_get_name

    override fun initView(savedInstanceState: Bundle?) {
        setTypeface(TextUtils.MONTSERRAT_REGULAR, editText)
        setTypeface(TextUtils.OPENSANS_REGULAR, hint)
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                (activity as BugGetCreateActivity).viewModel.bookName = p0.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })
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
