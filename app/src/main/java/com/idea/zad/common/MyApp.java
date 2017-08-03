package com.idea.zad.common;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.crashlytics.android.Crashlytics;
import com.idea.zad.database.CopyDataBase;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by ahmed on 13/04/17.
 */

public class MyApp extends MultiDexApplication {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();

        Realm.init(this);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        CopyDataBase.prepareDatabase();

        Fabric.with(this, new Crashlytics());
    }

    public static Context getContext(){
        return sContext;
    }



}
