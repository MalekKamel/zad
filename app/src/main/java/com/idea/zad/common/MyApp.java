package com.idea.zad.common;

import android.content.Context;
import androidx.multidex.MultiDexApplication;

import com.idea.zad.database.CopyDataBase;


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
    }

    public static Context getContext(){
        return sContext;
    }



}
