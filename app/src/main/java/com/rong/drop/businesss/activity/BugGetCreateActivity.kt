package com.rong.drop.businesss.activity

import android.support.v4.app.Fragment
import android.view.View
import com.rong.drop.R
import com.rong.drop.base.BaseActivity
import com.rong.drop.businesss.activity.fragment.CreateBugGetNameFragment
import com.rong.drop.utils.TextUtils
import kotlinx.android.synthetic.main.activity_bug_get_create.*

class BugGetCreateActivity : BaseActivity(), View.OnClickListener {
    private val mFragments = arrayOfNulls<Fragment>(7)


    private var mCurrentIndex = -1
    override val layoutId: Int
        get() = R.layout.activity_bug_get_create

    override fun initView() {
        setTypeface(TextUtils.MONTSERRAT_BOLD, bottomBtn)
        System.out.println("int.....")
        next()
    }

    private fun previous() {
        mCurrentIndex = Math.max(--mCurrentIndex, 0)
        replaceFragment(mFragments[mCurrentIndex]!!)
    }

    private fun next() {
        var fragment: Fragment
        mCurrentIndex = Math.min(++mCurrentIndex, 6)
        when (mCurrentIndex) {
            else -> {
                fragment = CreateBugGetNameFragment.newInstance()
                mFragments[mCurrentIndex] = fragment
            }
        }
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

    }
}
