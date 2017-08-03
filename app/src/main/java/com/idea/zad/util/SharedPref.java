package com.idea.zad.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.idea.zad.R;
import com.idea.zad.common.MyApp;
import com.idea.zad.common.util.Utils;

/**
 * Created by Sha on 7/25/17.
 */

public class SharedPref {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    private SharedPref() {
        pref = PreferenceManager.getDefaultSharedPreferences(MyApp.getContext());
        editor = pref.edit();
    }

    private static SharedPref sInstance;
    public static SharedPref getInstance(){
        if (sInstance == null)
            sInstance = new SharedPref();
        return sInstance;
    }

    public String getContentFontType(){
        return pref.getString("contentFontType", "1");
    }

    public float getCustomTextSize(){
        int font = pref.getInt("contentTextSize", -1);
        if (font == -1)
            return MyApp.getContext().getResources().getDimension(R.dimen.content_text_size);
        else
            return font;
    }

    public int getContentTextColor(){
        return pref.getInt("contentTextColor", 0);
    }

    public int getContentBgColor(){
        return pref.getInt("contentBgColor", 0);
    }

    public String getAppFontType(){
        return pref.getString("AppFontType", "3");
    }

}
