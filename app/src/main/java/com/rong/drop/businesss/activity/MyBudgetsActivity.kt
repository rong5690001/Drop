package com.rong.drop.businesss.activity

import android.inputmethodservice.Keyboard
import android.support.v4.content.ContextCompat
import android.view.View
import com.rong.drop.R
import com.rong.drop.`object`.BudgetObject
import com.rong.drop.businesss.view.DefaultView
import com.rong.drop.databinding.ActivityMyBudgetsBinding
import com.rong.drop.framework.base.BaseBindingActivity
import com.rong.drop.utils.TextUtils
import com.rong.drop.viewmodel.FaildViewModel
import com.rong.drop.viewmodel.MyBudgetsViewModel
import com.rong.drop.widget.keyboard.DropKeyboardActionListener
import kotlinx.android.synthetic.main.activity_my_budgets.*

class MyBudgetsActivity : BaseBindingActivity<DefaultView<MyBudgetsViewModel>
        , MyBudgetsViewModel, ActivityMyBudgetsBinding>()
        , DefaultView<MyBudgetsViewModel> {

    companion object {
        val PAGE_TYPE_INCOME = 0
        val PAGE_TYPE_EXPEND = 1

        val KEY_PAGE_TYPE = "pageType"
    }


    override val layoutId: Int
        get() = R.layout.activity_my_budgets

    private var pageType = PAGE_TYPE_INCOME

    override fun buildViewModel(): MyBudgetsViewModel {
        return MyBudgetsViewModel()
    }

    override fun initValue() {
        super.initValue()
        pageType = intent.getIntExtra(KEY_PAGE_TYPE, PAGE_TYPE_INCOME)
    }

    override fun initView() {
        if (pageType == PAGE_TYPE_INCOME) {//收入
            viewModel.title.set(getString(R.string.income))
            contentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_89ADCA))
        } else {//支出
            viewModel.title.set(getString(R.string.expend))
            contentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_89ADCA))
        }
        viewModel.moneySymbol.set(BudgetObject.moneySymbol)
        setTypeface(TextUtils.SPOON_BOLD, money)

        keyboardView.keyboard = Keyboard(this, R.xml.keyboard)
        keyboardView.isEnabled = true
        keyboardView.setOnKeyboardActionListener(object : DropKeyboardActionListener() {
            override fun onKey(primaryCode: Int, keyCodes: IntArray) {
                super.onKey(primaryCode, keyCodes)
                viewModel.money.set(viewModel.money.get() * 10f + primaryCode * 0.1f)
            }
        })
    }

    override fun getIView(): DefaultView<MyBudgetsViewModel> {
        return this
    }

    override fun onSuccess(viewModel: MyBudgetsViewModel) {

    }

    override fun onFailed(viewModel: FaildViewModel) {

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.money -> {
                keyboardView.visibility = if (keyboardView.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            }
            else -> {
            }
        }
    }
}
