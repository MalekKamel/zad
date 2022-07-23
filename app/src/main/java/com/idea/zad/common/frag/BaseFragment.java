package com.idea.zad.common.frag;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.afollestad.materialdialogs.MaterialDialog;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.common.util.FragmentUtils;

/**
 * Created by Sha on 4/3/17.
 */

/**
 * This class is responsible for the following:
 * 1 - Hold presenter and dialog reference.
 * 2 - Init presenter.
 * 3 - set View.
 * 5 - Bind presenter to Fragment lifecycle.
 * @param <T> presenter generic type whose parent is {@link BasePresenter}
 */
public abstract class BaseFragment<T extends BasePresenter> extends FragmentUtils {

    public T presenter;
    public MaterialDialog dialog;

    public abstract T initPresenter();
    public abstract int setResourceLayout();

    public boolean shouldKeepMusic;
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setResourceLayout(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

}