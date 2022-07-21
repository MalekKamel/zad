package com.idea.zad.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;

import androidx.core.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.idea.zad.R;
import com.idea.zad.common.util.Utils;

public class ContentTextView extends BaseCustomTextView{

    public ContentTextView(Context context) {
        super(context);
    }

    public ContentTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ContentTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void customize(Context context) {
        Typeface customFont = FontCache.getTypeface(pref.getContentFontType());
        setTypeface(customFont);

        float textSize = pref.getCustomTextSize();
        setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

        int textColor = pref.getContentTextColor();
        if (textColor == 0)
            setTextColor(ContextCompat.getColor(context, R.color.black));
        else
            setTextColor(Color.parseColor("#" + Utils.formatColor(pref.getContentTextColor())));

        setBackgroundResource(R.drawable.details_text);
        GradientDrawable drawable = (GradientDrawable) getBackground();
        int bgColor = pref.getContentBgColor();
        if (bgColor == 0)
            drawable.setColor(ContextCompat.getColor(context, R.color.white));
        else
            drawable.setColor(Color.parseColor("#" + Utils.formatColor(bgColor)));
    }


}
