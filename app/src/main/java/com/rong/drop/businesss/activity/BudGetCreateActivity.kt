package com.rong.drop.businesss.activity

import android.content.Intent
import android.support.v4.app.Fragment
import android.view.View
import com.rong.drop.MainActivity
import com.rong.drop.R
import com.rong.drop.framework.base.BaseActivity
import com.rong.drop.businesss.activity.fragment.*
import com.rong.drop.businesss.view.DefaultView
import com.rong.drop.extensions.dropStartActivity
import com.rong.drop.framework.simple.SimpleFragment
import com.rong.drop.presenter.BudGetCreatePresenter
import com.rong.drop.utils.PreferencesUtils
import com.rong.drop.utils.TextUtils
import com.rong.drop.utils.ToastUtil
import com.rong.drop.extensions.setTypefaceExtension
import com.rong.drop.viewmodel.BudGetCreateViewModel
import com.rong.drop.viewmodel.FaildViewModel
//import io.realm.Realm
import kotlinx.android.synthetic.main.activity_bug_get_create.*

class BudGetCreateActivity : BaseActivity<BudGetCreatePresenter, DefaultView<BudGetCreateViewModel>, BudGetCreateViewModel>()
        , View.OnClickListener, DefaultView<BudGetCreateViewModel> {


    override fun getIView(): DefaultView<BudGetCreateViewModel> {
        return this
    }

    override fun buildPresenter(): BudGetCreatePresenter {
        return BudGetCreatePresenter()
    }

    override fun buildViewModel(): BudGetCreateViewModel {
        return BudGetCreateViewModel()
    }

    private val mFragments = arrayOfNulls<SimpleFragment>(7)


    private var mCurrentIndex = -1
    override val layoutId: Int
        get() = R.layout.activity_bug_get_create

    override fun initView() {
        bottomBtn.setTypefaceExtension(TextUtils.MONTSERRAT_BOLD)
        System.out.println("int.....")
        next()
    }

    override fun onSuccess(viewModel: BudGetCreateViewModel) {

    }

    override fun onFailed(viewModel: FaildViewModel) {

    }


    private fun previous() {
        mCurrentIndex = Math.max(--mCurrentIndex, 0)
        replaceFragment(mFragments[mCurrentIndex]!!)
    }

    override fun onBackPressed() {
        if (mCurrentIndex == 0) {
            super.onBackPressed()
        } else {
            previous()
        }
    }

    private fun next() {
        if (mCurrentIndex > -1 && mFragments[mCurrentIndex]?.isValid == false) {
            ToastUtil.makeToast(mFragments[mCurrentIndex]?.validMessage ?: getString(R.string.error))
            return
        }
        var fragment: SimpleFragment
        //取值
        mCurrentIndex = Math.min(++mCurrentIndex, 6)
        when (mCurrentIndex) {
            1 -> {
                fragment = ChooseFragment.newChooseMoneyTypeFragment()
            }
            2 -> {
                fragment = ChooseFragment.newChooseStartDay()
            }
            3 -> {
                fragment = InputFragment.newAmount()
            }
            4 -> {
                fragment = InputFragment.newAmountLeft()
            }
            5 -> {
                fragment = SwitchFragment.newFragment()
            }
            6 -> {
                fragment = SetUpCompleteFragment.newFragment()
            }
            else -> {
                fragment = CreateBudGetNameFragment.newInstance()
            }
        }
        mFragments[mCurrentIndex] = fragment
        replaceFragment(fragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment).commit()
        when (mCurrentIndex) {
            1, 2, 3, 4, 5 -> {
                backBtn.visibility = View.VISIBLE
                bottomBtn.text = getString(R.string.next)
            }
            6 -> {
                backBtn.visibility = View.VISIBLE
                bottomBtn.text = getString(R.string.done)
            }
            else -> {
                backBtn.visibility = View.GONE
                bottomBtn.text = getString(R.string.next)
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.bottomBtn -> {
                if (mCurrentIndex == 6) {
                    done()
                } else {
                    next()
                }
            }
            R.id.backBtn -> {
                previous()
            }
            else -> {
            }
        }
    }

    private fun done() {
//        val realm = Realm.getDefaultInstance()
////        realm.beginTransaction()
//        realm.executeTransaction({
//            val accountBookNode = realm.createObject(AccountBookNode::class.java)
//            accountBookNode.book_name = viewModel.bookName
//            val accountTypeNode = realm.createObject(AccountTypeNode::class.java)
//            accountTypeNode.typeName = viewModel.moneySymbol
//            accountBookNode.mAccountTypeNode = accountTypeNode
//            accountBookNode.account_cycle = viewModel.account_cycle
//            accountBookNode.account_budget = viewModel.accountBudget
//            accountBookNode.balance_rolling = viewModel.balanceRolling
//            startActivity(Intent(this, MainActivity::class.java))
//        })
        dropStartActivity(MainActivity::class.java)
        PreferencesUtils.putValue(PreferencesUtils.KEY_HAS_BUDGET, true)
//        realm.addChangeListener {  }
//        realm.commitTransaction()
    }
}
