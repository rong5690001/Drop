package com.rong.drop.framework.database;

import javax.inject.Inject;
import javax.inject.Singleton;
import io.realm.Realm;

/**
 * Created by chen.huarong on 2017/12/11.
 */

public class RealmHelper {

    private static RealmHelper mInstance;
    private Realm mRealm;

    @Singleton
    public RealmHelper() {

    }
}
