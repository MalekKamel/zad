package com.idea.zad.common.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.idea.zad.R;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.common.util.ActivityUtils;
import com.idea.zad.common.util.ToolbarInit;
import com.idea.zad.constants.C;


/**
 * Created by Mickey on 4/4/17.
 */

/**
 * This class is responsible for the following:
 * 1 - Hold presenter and dialog reference.
 * 2 - Init presenter.
 * 3 - setContentView.
 * 4 - Init ButterKnife.
 * 5 - Bind presenter to Activity lifecycle.
 * @param <T> presenter generic type whose parent is {@link BasePresenter}
 */
public abstract class BaseActivity<T extends BasePresenter> extends ActivityUtils
implements C {

    public T presenter;
    protected MaterialDialog dialog;
    protected boolean shouldKeepMusic;

    protected abstract T initPresenter();
    protected abstract int setResourceLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setResourceLayout());
        setToolbar();
        presenter = initPresenter();
    }

    private void setToolbar() {
        if (this instanceof ToolbarInit) {
            final ToolbarInit toolbarImpl = (ToolbarInit) this;

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            TextView toolbar_title = toolbar.findViewById(R.id.tv_toolbarTitle);
            toolbar_title.setText(toolbarImpl.initToolbarTitle());

            View btn_back = findViewById(R.id.iv_toolbarBack);
            if (btn_back != null)
                btn_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        toolbarImpl.onToolbarActionClicked();

                        onBackPressed();
                    }
                });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        shouldKeepMusic = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
