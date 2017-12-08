package com.rong.drop.base


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rong.drop.R
import com.rong.drop.utils.TextUtils

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
abstract class BaseFragment : Fragment() {

    abstract val layoutId: Int
    abstract fun initView(savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View
        if (layoutId != -1) {
            view = LayoutInflater.from(context).inflate(layoutId, container, false)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_base, container, false)
        }
        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState)
    }

    fun setTypeface(typeface: String, textView: TextView) {
        TextUtils.setTypeFace(typeface, textView)
    }
}
