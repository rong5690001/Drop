package com.rong.drop.businesss.activity

import android.app.Activity
import android.content.Intent
import android.inputmethodservice.Keyboard
import android.support.v4.content.ContextCompat
import android.view.View
import com.rong.drop.MainActivity
import com.rong.drop.R
import com.rong.drop.`object`.BudgetObject
import com.rong.drop.businesss.view.DefaultView
import com.rong.drop.common.Constant
import com.rong.drop.database.AccountBookNode
import com.rong.drop.database.AccountNode
import com.rong.drop.database.AccountTypeNode
import com.rong.drop.databinding.ActivityMyBudgetsBinding
import com.rong.drop.framework.base.BaseBindingActivity
import com.rong.drop.utils.PreferencesUtils
import com.rong.drop.utils.TextUtils
import com.rong.drop.utils.pinpoint
import com.rong.drop.utils.setTypefaceExtension
import com.rong.drop.viewmodel.FaildViewModel
import com.rong.drop.viewmodel.MyBudgetsViewModel
import com.rong.drop.widget.keyboard.DropKeyboardActionListener
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_my_budgets.*

class MyBudgetsActivity : BaseBindingActivity<DefaultView<MyBudgetsViewModel>
        , MyBudgetsViewModel, ActivityMyBudgetsBinding>()
        , DefaultView<MyBudgetsViewModel> {

    companion object {
        val PAGE_TYPE_INCOME = 1
        val PAGE_TYPE_EXPEND = 0

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
        money.setTypefaceExtension(TextUtils.SPOON_BOLD)
        keyboardView.keyboard = Keyboard(this, R.xml.keyboard)
        keyboardView.isEnabled = true
        keyboardView.isPreviewEnabled = false
        keyboardView.setOnKeyboardActionListener(object : DropKeyboardActionListener() {
            override fun onKey(primaryCode: Int, keyCodes: IntArray) {
                super.onKey(primaryCode, keyCodes)

                when (primaryCode) {
                    Constant.KEY_CODE_DELETE -> {
                        val value = (viewModel.money.get() / 10f).pinpoint(1)
                        viewModel.money.set(Math.max(value, 0.0f))
                    }
                    Constant.KEY_CODE_FINISH -> {
                        done()
                    }
                    else -> {
                        val value = (viewModel.money.get() * 10f + primaryCode * 0.1f).pinpoint(1)
                        viewModel.money.set(Math.max(value, 0.0f))
                    }
                }

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

    /**
     * 完成
     */
    private fun done() {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction({
            val accountNode = realm.createObject(AccountNode::class.java)
            accountNode.account_book_id = BudgetObject.bookId
            accountNode.account_type_id
            accountNode.money_type = pageType
            accountNode.money = viewModel.money.get()
        })
        setResult(Activity.RESULT_OK)
        finish()
    }
}
