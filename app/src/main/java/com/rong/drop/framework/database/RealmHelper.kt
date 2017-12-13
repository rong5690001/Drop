package com.rong.drop.framework.database

import javax.inject.Singleton
import io.realm.Realm

/**
 * Created by chen.huarong on 2017/12/11.
 */

@Singleton
class RealmHelper private constructor() {

    var realm = Realm.getDefaultInstance()


}
