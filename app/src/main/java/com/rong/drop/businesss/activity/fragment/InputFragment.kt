package com.rong.drop.businesss.activity.fragment

import android.inputmethodservice.Keyboard
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.rong.drop.R
import com.rong.drop.businesss.activity.BudGetCreateActivity
import com.rong.drop.framework.simple.SimpleFragment
import com.rong.drop.widget.keyboard.DropKeyboardActionListener
import kotlinx.android.synthetic.main.fragment_input.*

/**
 * A simple [Fragment] subclass.
 */
class InputFragment : SimpleFragment(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.text -> {
                keyboardView.visibility = if (keyboardView.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            }
        }
    }

    override val layoutId: Int = R.layout.fragment_input
    private var pageType: Int = PAGE_TYPE_AMOUNT

    companion object {
        private val KEY_PAGE_TYPE = "pageType"
        private val PAGE_TYPE_AMOUNT = 0
        private val PAGE_TYPE_AMOUNTLEFT = 1
        fun newAmount(): InputFragment {
            var bundle = Bundle()
            bundle.putInt(KEY_PAGE_TYPE, PAGE_TYPE_AMOUNT)
            var fragment = InputFragment()
            fragment.arguments = bundle
            return fragment
        }

        fun newAmountLeft(): InputFragment {
            var bundle = Bundle()
            bundle.putInt(KEY_PAGE_TYPE, PAGE_TYPE_AMOUNTLEFT)
            var fragment = InputFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        pageType = arguments!!.getInt(KEY_PAGE_TYPE)
        if (pageType == PAGE_TYPE_AMOUNT) {
            title.text = getString(R.string.budget_amount)
            hint.text = getString(R.string.budget_amount_hint)
            editText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    var value = editText.text.toString()
                    if (value.isNotEmpty()) {
                        (activity as BudGetCreateActivity).viewModel.accountBudget = value
                    }
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

            })
        } else {
            title.text = getString(R.string.amount_left)
            hint.text = getString(R.string.amount_left_hint)
            editText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    var value = editText.text.toString()
                    if (value.isNotEmpty()) {
                        (activity as BudGetCreateActivity).viewModel.amountLeft = value
                    }
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

            })
        }

        keyboardView.keyboard = Keyboard(context, R.xml.keyboard)
        keyboardView.visibility = View.VISIBLE
        keyboardView.setOnKeyboardActionListener(object : DropKeyboardActionListener() {
            override fun onKey(primaryCode: Int, keyCodes: IntArray) {
                super.onKey(primaryCode, keyCodes)
                editText.append(primaryCode.toString())
            }
        })

        editText.setOnClickListener(this)
    }

}// Required empty public constructor
