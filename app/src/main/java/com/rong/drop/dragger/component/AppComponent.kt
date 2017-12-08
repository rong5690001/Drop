package com.rong.drop.dragger.component

import com.rong.drop.dragger.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by chen.huarong on 2017/12/8.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent