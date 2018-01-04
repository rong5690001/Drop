package com.rong.drop;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.rong.drop.framework.database.RealmManager;

/**
 * Created by chen.huarong on 2017/11/25.
 */

public class DropApplication extends Application {

    private static Context context;
    public static Activity mCurrentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        RealmManager.install(this);
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });

    }

    public static Context getContext() {
        return context;
    }
}
