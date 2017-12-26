package com.rong.drop.businesss.activity

import android.support.v4.content.ContextCompat
import com.rong.drop.R
import com.rong.drop.businesss.view.DefaultView
import com.rong.drop.databinding.ActivityMyBudgetsBinding
import com.rong.drop.framework.base.BaseBindingActivity
import com.rong.drop.utils.TextUtils
import com.rong.drop.viewmodel.FaildViewModel
import com.rong.drop.viewmodel.MyBudgetsViewModel
import kotlinx.android.synthetic.main.activity_my_budgets.*

class MyBudgetsActivity : BaseBindingActivity<DefaultView<MyBudgetsViewModel>
        , MyBudgetsViewModel, ActivityMyBudgetsBinding>()
        , DefaultView<MyBudgetsViewModel> {

    companion object {
        val PAGE_TYPE_INCOME = 0;
        val PAGE_TYPE_EXPEND = 1;

        val KEY_PAGE_TYPE = "pageType"
    }


    override val layoutId: Int
        get() = R.layout.activity_my_budgets

    private var pageType = PAGE_TYPE_INCOME

    override fun initView() {
        pageType = intent.getIntExtra(KEY_PAGE_TYPE, PAGE_TYPE_INCOME)
        if (pageType == PAGE_TYPE_INCOME) {//收入
            contentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_89ADCA))

        } else {
            contentLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_89ADCA))
        }
        setTypeface(TextUtils.SPOON_BOLD, money)
    }

    override fun buildViewModel(): MyBudgetsViewModel {
        var viewModel = MyBudgetsViewModel()
        viewModel.title =
                return MyBudgetsViewModel()
    }

    override fun getIView(): DefaultView<MyBudgetsViewModel> {
        return this
    }

    override fun onSuccess(viewModel: MyBudgetsViewModel) {

    }

    override fun onFailed(viewModel: FaildViewModel) {

    }
}
