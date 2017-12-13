package com.rong.drop.framework.simple

import android.content.Context
import com.rong.drop.R
import com.rong.drop.framework.base.BaseAdapter
import org.byteam.superadapter.SuperViewHolder
import kotlin.collections.ArrayList

/**
 * Created by chen.huarong on 2017/11/25.
 */
class SimpleRecyclerAdapter : BaseAdapter<SimpleItemViewModel> {

    var selectedIndex: Int = 0

    constructor(context: Context?, items: List<SimpleItemViewModel>)
            : super(context, items, R.layout.item_simple_recycler) {
        setOnItemClickListener { _, _, position ->
            selectedIndex = position
            notifyDataSetChanged()
        }
    }

    override fun onBind(holder: SuperViewHolder?, viewType: Int, layoutPosition: Int, item: SimpleItemViewModel?) {
        holder?.setText(R.id.simpleValue, item?.value)
        holder?.itemView?.isSelected = layoutPosition == selectedIndex
    }


}