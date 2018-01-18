package com.rong.drop.framework.database;

import android.app.Application;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmObject;
import io.realm.RealmSchema;
import io.realm.annotations.PrimaryKey;

/**
 * Created by chen.huarong on 2017/12/8.
 * 数据库管理类
 */

public class RealmManager {

    private static final int FIRST_VERSION = 1;
    private static final int CURRENT_VERSION = 2;

    public static void install(Application application) {
        Realm.init(application);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(CURRENT_VERSION) // Must be bumped when the schema changes
                .migration(getMigration()) // Migration to run instead of throwing an exception
                .build();
//        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }

    /**
     * 升级数据库需要在此做数据库升级处理
     *
     * @return
     */
    private static RealmMigration getMigration() {
        return new RealmMigration() {
            @Override
            public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

                // DynamicRealm exposes an editable schema
                RealmSchema schema = realm.getSchema();

//                 Migrate to version 1: Add a new class
//                 Example:
//                 public Person extends RealmObject {
//                     private String name;
//                     private int age;
//                     // getters and setters left out for brevity
//                 }
//                if (oldVersion == 0) {
//                    schema.create("Person")
//                            .addField("name", String.class)
//                            .addField("age", int.class);
//                    oldVersion++;
//                }
//
//                 Migrate to version 2: Add a primary key + object references
//                 Example:
//                 public Person extends RealmObject {
//                     private String name;
//                     @PrimaryKey
//                     private int age;
//                     private Dog favoriteDog;
//                     private RealmList<Dog> dogs;
//                     // getters and setters left out for brevity
//                 }
                if (oldVersion == 1) {
                    schema.get("AccountBookNode")
                            .addField("bookId", int.class, FieldAttribute.PRIMARY_KEY);
                    schema.get("AccountNode")
                            .addField("nodeId", int.class, FieldAttribute.PRIMARY_KEY)
                            .addField("money", float.class)
                            .addField("account_book_id", int.class);
                    schema.get("AccountTypeNode")
                            .addField("typeId", int.class, FieldAttribute.PRIMARY_KEY);
                    oldVersion++;
                }
            }
        };
    }

}
