package com.idea.zad.common.presenter;

import android.content.Context;

import com.idea.zad.common.observer.BaseView;
import com.idea.zad.constants.C;


/**
 * Created by Sha on 4/3/17.
 */



public class BasePresenter<V extends BaseView>  implements
        C {
    private V view;
    public Context context;

    public BasePresenter(Context context, V view) {
        this.view = view;
        this.context = context;
    }

    public V getView() {
        return view;
    }

}
