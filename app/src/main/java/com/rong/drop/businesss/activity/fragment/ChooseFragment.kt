package com.rong.drop.businesss.activity.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.rong.drop.R
import com.rong.drop.businesss.activity.BudGetCreateActivity
import com.rong.drop.businesss.adapter.SimpleRecyclerAdapter
import com.rong.drop.framework.simple.SimpleFragment
import com.rong.drop.utils.TextUtils
import kotlinx.android.synthetic.main.fragment_choose_money_type.*
import kotlinx.android.synthetic.main.item_simple_recycler.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [ChooseFragment.newChooseMoneyTypeFragment] factory method to
 * create an instance of this fragment.
 */
class ChooseFragment : SimpleFragment() {

    override val layoutId: Int = R.layout.fragment_choose_money_type

    private val moneyTypes = arrayOf("￥CNY", "\$USD", "\$HKD", "\$NHD")
    private val startDays = arrayOf("Today", "First day", "Last day", "2nd")
    private var mAdapter: SimpleRecyclerAdapter? = null
    private var mPageType: Int = PAGE_TYPE_MONEY

    companion object {

        private val PAGE_TYPE_MONEY = 0
        private val PAGE_TYPE_STARTDAY = 1
        private val KEY_PAGE_TYPE = "mPageType"

        fun newChooseMoneyTypeFragment(): ChooseFragment {
            var bundle = Bundle()
            bundle.putInt(KEY_PAGE_TYPE, PAGE_TYPE_MONEY)
            var fragment = ChooseFragment()
            fragment.arguments = bundle
            return fragment
        }

        fun newChooseStartDay(): ChooseFragment {
            var bundle = Bundle()
            bundle.putInt(KEY_PAGE_TYPE, PAGE_TYPE_STARTDAY)
            var fragment = ChooseFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        mPageType = arguments.getInt(KEY_PAGE_TYPE)
        setTypeface(TextUtils.MONTSERRAT_BOLD, title)
        setTypeface(TextUtils.OPENSANS_REGULAR, hint)
        if (mPageType == PAGE_TYPE_MONEY) {
            title.text = "币种"
            mAdapter = SimpleRecyclerAdapter(context, moneyTypes)
            mAdapter?.setOnItemClickListener { itemView, _, position ->
                (activity as BudGetCreateActivity).viewModel.typeName = itemView.simpleValue.text.toString()
                mAdapter?.selectedIndex = position
                mAdapter?.notifyDataSetChanged()
            }
        } else {
            title.text = "START DATE"
            mAdapter = SimpleRecyclerAdapter(context, startDays)
            mAdapter?.setOnItemClickListener { itemView, _, position ->
                mAdapter?.selectedIndex = position
                mAdapter?.notifyDataSetChanged()
                //                (activity as BudGetCreateActivity).mViewModel.typeName = itemView.simpleValue.text.toString()
            }
        }
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = mAdapter
    }


}
