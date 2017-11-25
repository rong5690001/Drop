package com.rong.drop;

import android.app.Application;
import android.content.Context;

/**
 * Created by chen.huarong on 2017/11/25.
 */

public class DropApplication extends Application {

    private static Context sContext;

    public DropApplication() {
        this.sContext = this;
    }

    public static Context getContext(){
        return sContext;
    }
}
