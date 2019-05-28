package com.rong.drop.businesss.activity.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.rong.drop.R
import com.rong.drop.businesss.activity.BudGetCreateActivity
import com.rong.drop.framework.simple.SimpleFragment
import com.rong.drop.utils.TextUtils
import com.rong.drop.extensions.setTypefaceExtension
import kotlinx.android.synthetic.main.fragment_create_bug_get_name.*

class CreateBudGetNameFragment : SimpleFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_create_bug_get_name

    override fun initView(savedInstanceState: Bundle?) {
        editText.setTypefaceExtension(TextUtils.MONTSERRAT_REGULAR)
        hint.setTypefaceExtension(TextUtils.OPENSANS_REGULAR)
        isValid = true
        validMessage = getString(R.string.budget_name_valid_msg)
        (activity as BudGetCreateActivity).viewModel.bookName = editText.text.toString()
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                isValid = !p0.toString().isEmpty()
                (activity as BudGetCreateActivity).viewModel.bookName = p0.toString()
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
         * @return A new instance of fragment CreateBudGetNameFragment.
         */
        fun newInstance(): CreateBudGetNameFragment {
            return CreateBudGetNameFragment()
        }
    }
}// Required empty public constructor
