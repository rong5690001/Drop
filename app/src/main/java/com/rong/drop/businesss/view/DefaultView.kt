package com.rong.drop.businesss.view

import com.rong.drop.framework.base.BaseView
import com.rong.drop.framework.base.BaseViewModel
import com.rong.drop.viewmodel.FaildViewModel

/**
 * Created by chen.huarong on 2017/12/8.
 */
interface DefaultView<in VM : BaseViewModel> : BaseView {

    fun onSuccess(viewModel: VM)

    fun onFailed(viewModel: FaildViewModel)

}