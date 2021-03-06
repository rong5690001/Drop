package com.rong.drop.businesss.activity.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.rong.drop.R
import com.rong.drop.businesss.activity.BudGetCreateActivity
import com.rong.drop.framework.simple.SimpleRecyclerAdapter
import com.rong.drop.framework.simple.SimpleFragment
import com.rong.drop.utils.TextUtils
import com.rong.drop.framework.extensions.setTypefaceExtension
import com.rong.drop.viewmodel.SimpleItemMapper
import kotlinx.android.synthetic.main.fragment_choose.*

/**
 * A simple [Fragment] subclass.
 * Use the [ChooseFragment.newChooseMoneyTypeFragment] factory method to
 * create an instance of this fragment.
 */
class ChooseFragment : SimpleFragment() {

    override val layoutId: Int = R.layout.fragment_choose

    private var mAdapter: SimpleRecyclerAdapter? = null
    private var mPageType: Int = PAGE_TYPE_MONEY

    companion object {

        private val PAGE_TYPE_MONEY = 0
        private val PAGE_TYPE_STARTDAY = 1
        private val KEY_PAGE_TYPE = "mPageType"

        fun newChooseMoneyTypeFragment(): ChooseFragment {
            val bundle = Bundle()
            bundle.putInt(KEY_PAGE_TYPE, PAGE_TYPE_MONEY)
            val fragment = ChooseFragment()
            fragment.arguments = bundle
            return fragment
        }

        fun newChooseStartDay(): ChooseFragment {
            val bundle = Bundle()
            bundle.putInt(KEY_PAGE_TYPE, PAGE_TYPE_STARTDAY)
            var fragment = ChooseFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        mPageType = arguments!!.getInt(KEY_PAGE_TYPE)
        title.setTypefaceExtension(TextUtils.MONTSERRAT_BOLD)
        hint.setTypefaceExtension(TextUtils.OPENSANS_REGULAR)
        if (mPageType == PAGE_TYPE_MONEY) {
            title.text = getString(R.string.currency)
            hint.text = getString(R.string.start_date_hint)
            mAdapter = SimpleRecyclerAdapter(context, SimpleItemMapper.moneySymbolMapper())
            mAdapter?.setOnItemClickListener { _, _, position ->
                (activity as BudGetCreateActivity).viewModel.moneySymbol = (mAdapter?.getItem(position)?.value) ?: "\$USD"
                mAdapter?.selectedIndex = position
                mAdapter?.notifyDataSetChanged()
            }
        } else {
            title.text = getString(R.string.start_date)
            hint.text = getString(R.string.start_date_hint)
            mAdapter = SimpleRecyclerAdapter(context, SimpleItemMapper.startDateMapper())
            mAdapter?.setOnItemClickListener { itemView, _, position ->
                mAdapter?.selectedIndex = position
                mAdapter?.notifyDataSetChanged()
                (activity as BudGetCreateActivity).viewModel.account_cycle = position
            }
        }
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = mAdapter
    }


}
