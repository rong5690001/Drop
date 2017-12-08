package com.rong.drop.businesss.adapter

import android.content.Context
import com.rong.drop.R
import com.rong.drop.framework.base.BaseAdapter
import org.byteam.superadapter.SuperViewHolder
import kotlin.collections.ArrayList

/**
 * Created by chen.huarong on 2017/11/25.
 */
class SimpleRecyclerAdapter : BaseAdapter<String> {

    private var selectedIndex: Int = 0

    constructor(context: Context?, items: Array<String>)
            : super(context, ArrayList<String>(items.asList()), R.layout.item_simple_recycler) {
        setOnItemClickListener { _, _, position ->
            selectedIndex = position
            notifyDataSetChanged()
        }
    }

    override fun onBind(holder: SuperViewHolder?, viewType: Int, layoutPosition: Int, item: String?) {
        holder!!.setText(R.id.simpleValue, item)
        holder.itemView.isSelected = layoutPosition == selectedIndex
    }


}