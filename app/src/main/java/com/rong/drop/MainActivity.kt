package com.rong.drop

import android.app.Activity
import android.content.Intent
import com.rong.drop.businesss.activity.MyBudgetsActivity
import com.rong.drop.businesss.view.DefaultView
import com.rong.drop.databinding.ActivityMainBinding
import com.rong.drop.framework.base.BaseBindingActivity
import com.rong.drop.utils.SystemBarUtil
import com.rong.drop.utils.TextUtils
import com.rong.drop.framework.extensions.setTypefaceExtension
import com.rong.drop.viewmodel.FaildViewModel
import com.rong.drop.viewmodel.MainViewModel
import com.rong.drop.widget.MetaballDebugView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseBindingActivity<DefaultView<MainViewModel>, MainViewModel, ActivityMainBinding>()
        , MetaballDebugView.MetaballListener, DefaultView<MainViewModel> {

    val REQUEST_CODE_INCOME = 0
    val REQUEST_CODE_EXPEND = 1

    override fun getIView(): DefaultView<MainViewModel> {
        return this
    }

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView() {
        SystemBarUtil.immersiveStatusBar(this, 0f)
        mainTitle.setTypefaceExtension(TextUtils.MONTSERRAT_BOLD)
        accountBudget.setTypefaceExtension(TextUtils.SPOON_BOLD)
        hint.setTypefaceExtension(TextUtils.MONTSERRAT_REGULAR)
        metaballDebugView.setMetaballListener(this)
    }

    override fun buildViewModel(): MainViewModel {
        val mainViewModel = MainViewModel()
        mainViewModel.getData()
        return mainViewModel
    }

    override fun onSuccess(viewModel: MainViewModel) {

    }

    override fun onFailed(viewModel: FaildViewModel) {

    }

    override fun onIncome() {
        startActivityForResult(Intent(this
                , MyBudgetsActivity::class.java)
                .putExtra(MyBudgetsActivity.KEY_PAGE_TYPE, MyBudgetsActivity.PAGE_TYPE_INCOME)
                , REQUEST_CODE_INCOME)
    }

    override fun onExpend() {
        startActivityForResult(Intent(this
                , MyBudgetsActivity::class.java)
                .putExtra(MyBudgetsActivity.KEY_PAGE_TYPE, MyBudgetsActivity.PAGE_TYPE_EXPEND)
                , REQUEST_CODE_EXPEND)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_INCOME, REQUEST_CODE_EXPEND -> {
                    viewModel.getData()
                }
            }
        }
    }
}
