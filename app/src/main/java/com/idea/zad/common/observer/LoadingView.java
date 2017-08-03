package com.idea.zad.common.observer;

/**
 * Created by Sha on 4/3/17.
 */

public interface LoadingView extends BaseView {

    void onLoad(String message);
    void didLoad();
}
