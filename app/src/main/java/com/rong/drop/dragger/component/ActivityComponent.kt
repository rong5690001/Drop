package com.rong.drop.dragger.component

import com.rong.drop.MainActivity
import com.rong.drop.dragger.PerActivity
import com.rong.drop.dragger.module.ActivityModule
import com.rong.drop.framework.base.BaseActivity
import dagger.Component

/**
 * Created by chen.huarong on 2017/12/8.
 */

@PerActivity
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: MainActivity)

}