package com.idea.zad.component;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import com.idea.zad.common.MyApp;

import java.util.HashMap;


public class FontCache {

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(String fontName) {
        Typeface typeface = fontCache.get(fontName);

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(MyApp.getContext().getAssets(), "font/" +  fontName + ".otf");
            }
            catch (Exception e) {

                Log.e("font" , "not applied");
                return null;
            }

            fontCache.put(fontName, typeface);
        }
        return typeface;
    }

}