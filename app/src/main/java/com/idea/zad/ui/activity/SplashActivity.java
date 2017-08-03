package com.idea.zad.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.idea.zad.R;
import com.idea.zad.common.activity.BaseActivity;
import com.idea.zad.common.presenter.BasePresenter;


public class SplashActivity extends BaseActivity {
    private static final int SPLASH_TIME_OUT = 2000;
    private Handler delayHandler = new Handler();
    private final Runnable runnable;

    public SplashActivity() {
        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        };
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int setResourceLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delayHandler.postDelayed(runnable, SPLASH_TIME_OUT);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        delayHandler.removeCallbacks(runnable);
    }
}
