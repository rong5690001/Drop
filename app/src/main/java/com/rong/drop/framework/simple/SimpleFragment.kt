package com.rong.drop.framework.simple

import com.rong.drop.R
import com.rong.drop.businesss.view.DefaultView
import com.rong.drop.framework.base.BaseFragment
import com.rong.drop.presenter.DefaultPresenter
import com.rong.drop.viewmodel.DefaultViewModel
import com.rong.drop.viewmodel.FaildViewModel

/**
 * Created by chen.huarong on 2017/12/12.
 */
abstract class SimpleFragment : BaseFragment<DefaultPresenter
        , DefaultView<DefaultViewModel>
        , DefaultViewModel>()
        , DefaultView<DefaultViewModel> {

    var isValid = true//是否有效的（可用于校验可否进行下一下操作等）
    lateinit var validMessage: String
    override val layoutId: Int = R.layout.fragment_base

    override fun onSuccess(viewModel: DefaultViewModel) {

    }

    override fun onFailed(viewModel: FaildViewModel) {
    }

    override fun getIView(): DefaultView<DefaultViewModel> {
        return this
    }

    override fun buildPresenter(): DefaultPresenter {
        return DefaultPresenter()
    }

    override fun buildViewModel(): DefaultViewModel {
        validMessage = getString(R.string.error)
        return DefaultViewModel()
    }
}