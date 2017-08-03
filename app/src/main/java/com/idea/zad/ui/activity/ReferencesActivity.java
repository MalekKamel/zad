package com.idea.zad.ui.activity;

import android.view.View;

import com.idea.zad.R;
import com.idea.zad.common.activity.BaseActivity;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.common.util.ToolbarActionInit;
import com.idea.zad.common.util.Utils;

import butterknife.OnClick;

public class ReferencesActivity extends BaseActivity implements ToolbarActionInit {

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int setResourceLayout() {
        return R.layout.activity_references;
    }

    @OnClick(R.id.iv_islamDoorLogo)
    public void onClick(View v){
        switch (v.getId()){
            case R.id.iv_islamDoorLogo:
                Utils.createIntentChooser(
                        "http://www.islamdoor.com/k/",
                        getString(R.string.twitter),
                        this
                );
                break;
        }
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
