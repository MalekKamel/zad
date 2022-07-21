package com.idea.zad.component;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.idea.zad.util.SharedPref;

public class CustomBtn extends androidx.appcompat.widget.AppCompatButton {

    public CustomBtn(Context context) {
        super(context);
        customize(context);
    }

    public CustomBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        customize(context);
    }

    public CustomBtn(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        customize(context);
    }

    private void customize(Context context) {
        Typeface customFont = FontCache.getTypeface(SharedPref.getInstance().getAppFontType());
        setTypeface(customFont);
    }


}
