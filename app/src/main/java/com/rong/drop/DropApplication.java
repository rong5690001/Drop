package com.rong.drop;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.rong.drop.dragger.component.AppComponent;
import com.rong.drop.dragger.component.DaggerAppComponent;
import com.rong.drop.dragger.module.AppModule;
import com.rong.drop.framework.database.RealmManager;

/**
 * Created by chen.huarong on 2017/11/25.
 */

public class DropApplication extends Application {

    private static Context context;
    private AppComponent mAppComponent;
    public static Activity mCurrentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        RealmManager.install(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public static Context getContext() {
        return context;
    }
}
