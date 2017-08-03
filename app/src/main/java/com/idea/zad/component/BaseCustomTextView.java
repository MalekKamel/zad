package com.idea.zad.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.idea.zad.util.SharedPref;

/**
 * Created by Sha on 7/25/17.
 */

public abstract class BaseCustomTextView extends android.support.v7.widget.AppCompatTextView {

    protected SharedPref pref = SharedPref.getInstance();

    public BaseCustomTextView(Context context) {
        super(context);
        customize(context);
    }

    public BaseCustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        customize(context);
    }

    public BaseCustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        customize(context);
    }

    protected abstract void customize(Context context);

}
