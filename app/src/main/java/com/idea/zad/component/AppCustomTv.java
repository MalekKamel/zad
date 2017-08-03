package com.idea.zad.component;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.idea.zad.util.SharedPref;

public class AppCustomTv extends BaseCustomTextView {

    public AppCustomTv(Context context) {
        super(context);
        customize(context);
    }

    public AppCustomTv(Context context, AttributeSet attrs) {
        super(context, attrs);
        customize(context);
    }

    public AppCustomTv(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void customize(Context context) {
        Typeface customFont = FontCache.getTypeface(pref.getAppFontType());
        setTypeface(customFont);
    }






}
