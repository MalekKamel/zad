package com.idea.zad.common;

import android.content.Context;
import androidx.multidex.MultiDexApplication;

import com.crashlytics.android.Crashlytics;
import com.idea.zad.database.CopyDataBase;

import io.fabric.sdk.android.Fabric;


/**
 * Created by ahmed on 13/04/17.
 */

public class MyApp extends MultiDexApplication {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();

        CopyDataBase.prepareDatabase();

//        Fabric.with(this, new Crashlytics());
    }

    public static Context getContext(){
        return sContext;
    }



}
