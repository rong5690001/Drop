package com.rong.drop.dragger.module

import android.app.Activity
import android.content.Context
import com.rong.drop.dragger.ActivityContext
import com.rong.drop.dragger.PerActivity
import dagger.Module
import dagger.Provides

/**
 * Created by chen.huarong on 2017/12/8.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @PerActivity
    @Provides
    @ActivityContext
    fun provideContext(): Context = activity


}

