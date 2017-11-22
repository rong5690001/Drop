package com.rong.drop.businesss.activity.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

import com.rong.drop.R
import com.rong.drop.base.BaseFragment
import com.rong.drop.utils.TextUtils

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CreateBugGetNameFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CreateBugGetNameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateBugGetNameFragment : BaseFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_create_bug_get_name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setTypeface(TextUtils.MONTSERRAT_BOLD, view!!.findViewById(R.id.editText))
    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment CreateBugGetNameFragment.
         */
        fun newInstance(): CreateBugGetNameFragment {
            return CreateBugGetNameFragment()
        }
    }
}// Required empty public constructor
