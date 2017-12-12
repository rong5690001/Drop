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

    var presenter: P? = null
    lateinit var view: V
    lateinit var viewModel: VM
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
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState)
        view = getIView()
        viewModel = buildViewModel()
        presenter = buildPresenter()

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        checkNotNull(presenter) {
            "presenter can't null, should build it first!"
        }
        presenter!!.attachView(view, viewModel)
    }

    override fun onDetach() {
        checkNotNull(presenter) {
            "presenter can't null, should build it first!"
        }
        presenter!!.detachView()
        super.onDetach()
    }

    fun setTypeface(typeface: String, textView: TextView) {
        TextUtils.setTypeFace(typeface, textView)
    }

}
