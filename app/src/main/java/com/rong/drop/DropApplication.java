package com.rong.drop;

import android.app.Application;
import android.content.Context;
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

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        RealmManager.install(this);
    }

    public static Context getContext() {
        return context;
    }
}
