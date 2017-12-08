package com.rong.drop.dragger.module

import android.app.Application
import android.content.Context
import com.rong.drop.DropApplication
import com.rong.drop.dragger.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by chen.huarong on 2017/12/8.
 */
@Module
class AppModule(private val instance: DropApplication) {

    @Provides
    @Singleton
    fun provideInstance(): Application = instance

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = instance.applicationContext
}