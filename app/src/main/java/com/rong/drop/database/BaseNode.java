package com.rong.drop.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import java.io.Serializable;

/**
 * Created by chen.huarong on 2017/12/8.
 */

public class BaseNode extends RealmObject implements Serializable {

    @PrimaryKey
    public long id;

}
