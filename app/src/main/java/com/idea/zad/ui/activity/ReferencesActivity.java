package com.idea.zad.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.idea.zad.R;
import com.idea.zad.common.activity.BaseActivity;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.common.util.ToolbarActionInit;
import com.idea.zad.common.util.Utils;

public class ReferencesActivity extends BaseActivity implements ToolbarActionInit {

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int setResourceLayout() {
        return R.layout.activity_references;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.iv_islamDoorLogo).setOnClickListener(v -> {
            Utils.createIntentChooser(
                    "http://www.islamdoor.com/k/",
                    getString(R.string.twitter),
                    this
            );
        });
    }

    @Override
    public String initToolbarTitle() {
        return getString(R.string.references);
    }

    @Override
    public void onToolbarActionClicked() {
    }

    @Override
    public void onFirstIconClicked() {

    }

    @Override
    public String setActionName() {
        return null;
    }
}
