package com.rong.drop

import com.rong.drop.businesss.view.DefaultView
import com.rong.drop.database.AccountBookNode
import com.rong.drop.framework.base.BaseActivity
import com.rong.drop.presenter.MainPresenter
import com.rong.drop.utils.SystemBarUtil
import com.rong.drop.utils.TextUtils
import com.rong.drop.utils.ToastUtil
import com.rong.drop.viewmodel.FaildViewModel
import com.rong.drop.viewmodel.MainViewModel
import com.rong.drop.widget.MetaballDebugView
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter, DefaultView<MainViewModel>, MainViewModel>()
        , MetaballDebugView.MetaballListener, DefaultView<MainViewModel> {

    lateinit var realm: Realm

    override fun onSuccess(viewModel: MainViewModel) {
    }

    override fun onFailed(viewModel: FaildViewModel) {
    }

    override fun getIView(): DefaultView<MainViewModel> {
        return this
    }

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView() {
        SystemBarUtil.immersiveStatusBar(this, 0f)
        setTypeface(TextUtils.MONTSERRAT_BOLD, mainTitle)
        setTypeface(TextUtils.SPOON_BOLD, accountBudget)
        setTypeface(TextUtils.MONTSERRAT_REGULAR, hint)
        metaballDebugView.setMetaballListener(this)
    }

    override fun buildPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun buildViewModel(): MainViewModel {
        var mainViewModel = MainViewModel()
        realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        var accountBookNode = realm.where(AccountBookNode::class.java).findFirst()
        mainViewModel.accountBudget = accountBookNode.account_budget
        accountBudget.text = mainViewModel.accountBudget
        return mainViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    override fun onIncome() {
        ToastUtil.makeToast("收入")
    }

    override fun onExpend() {
        ToastUtil.makeToast("支出")
    }
}
