package com.rong.drop.businesss.activity

import android.os.Bundle
import com.rong.drop.R
import com.rong.drop.businesss.view.DefaultView
import com.rong.drop.framework.base.BaseActivity
import com.rong.drop.presenter.EditPresenter
import com.rong.drop.viewmodel.EditViewModel
import com.rong.drop.viewmodel.FaildViewModel

class EditActivity : BaseActivity<EditPresenter, DefaultView<EditViewModel>, EditViewModel>() , DefaultView<EditViewModel>{

    override fun onSuccess(viewModel: EditViewModel) {

    }

    override fun onFailed(viewModel: FaildViewModel) {
    }

    override fun getIView(): DefaultView<EditViewModel> {
        return this
    }

    override fun buildViewModel(): EditViewModel {
        return EditViewModel()
    }

    override fun buildPresenter(): EditPresenter {
        return EditPresenter()
    }

    override val layoutId: Int
        get() = R.layout.activity_edit

    override fun initView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
    }
}
