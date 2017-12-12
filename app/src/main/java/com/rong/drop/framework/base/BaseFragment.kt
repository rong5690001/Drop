package com.rong.drop.framework.base

import android.content.Context
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
abstract class BaseFragment<P : BasePresenter<V, VM>, V : BaseView, VM : BaseViewModel> : Fragment() {

    var mPresenter: P? = null
    lateinit var mView: V
    lateinit var mViewModel: VM
    abstract val layoutId: Int
    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun buildPresenter(): P
    abstract fun buildViewModel(): VM
    abstract fun getIView(): V

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View
        if (layoutId != -1) {
            view = LayoutInflater.from(context).inflate(layoutId, container, false)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_base, container, false)
        }

        mView = getIView()
        mViewModel = buildViewModel()
        mPresenter = buildPresenter()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
//        checkNotNull(mPresenter) {
//            "mPresenter can't null, should build it first!"
//        }
        mPresenter?.attachView(mView, mViewModel)
    }

    override fun onDetach() {
//        checkNotNull(mPresenter) {
//            "mPresenter can't null, should build it first!"
//        }
        mPresenter?.detachView()
        super.onDetach()
    }

    fun setTypeface(typeface: String, textView: TextView) {
        TextUtils.setTypeFace(typeface, textView)
    }

}
