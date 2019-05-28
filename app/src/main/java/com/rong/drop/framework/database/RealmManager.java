package com.rong.drop.framework.database;

import android.app.Application;

/**
 * Created by chen.huarong on 2017/12/8.
 * 数据库管理类
 */

public class RealmManager {

    private static final int FIRST_VERSION = 1;
    private static final int CURRENT_VERSION = 1;

    public static void install(Application application) {
//        Realm.init(application);
//
//        RealmConfiguration config = new RealmConfiguration.Builder()
//                .schemaVersion(CURRENT_VERSION) // Must be bumped when the schema changes
//                .migration(getMigration()) // Migration to run instead of throwing an exception
//                .build();
////        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
//        Realm.setDefaultConfiguration(config);
    }

    /**
     * 升级数据库需要在此做数据库升级处理
     *
     * @return
     */
//    private static RealmMigration getMigration() {
//        return new RealmMigration() {
//            @Override
//            public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
//
//                // DynamicRealm exposes an editable schema
//                RealmSchema schema = realm.getSchema();
////                 Migrate to version 1: Add a new class
////                 Example:
////                 public Person extends RealmObject {
////                     private String name;
////                     private int age;
////                     // getters and setters left out for brevity
////                 }
////                if (oldVersion == 0) {
////                    schema.create("Person")
////                            .addField("name", String.class)
////                            .addField("age", int.class);
////                    oldVersion++;
////                }
////
////                 Migrate to version 2: Add a primary key + object references
////                 Example:
////                 public Person extends RealmObject {
////                     private String name;
////                     @PrimaryKey
////                     private int age;
////                     private Dog favoriteDog;
////                     private RealmList<Dog> dogs;
////                     // getters and setters left out for brevity
////                 }
////                if (oldVersion == 2) {
////                    schema.get("AccountNode")
////                            .addField("money_tmp", Float.class)
////                            .transform(new RealmObjectSchema.Function() {
////                                @Override
////                                public void apply(DynamicRealmObject obj) {
////                                    String oldMoney = obj.getString("money");
////                                    obj.setFloat("money_tmp"
////                                            , TextUtils.isEmpty(oldMoney) ? 0.0f : Float.parseFloat(oldMoney));
////                                }
////                            })
////                            .removeField("money")
////                            .renameField("money_tmp", "money");
////                    oldVersion++;
////                }
//            }
//        };
//    }

}
