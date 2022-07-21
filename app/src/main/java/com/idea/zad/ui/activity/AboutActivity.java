package com.idea.zad.ui.activity;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.idea.zad.R;
import com.idea.zad.common.activity.BaseActivity;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.common.util.Utils;

public class AboutActivity extends BaseActivity {

    TextView btn_appVersion;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int setResourceLayout() {
        return R.layout.activity_about;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        btn_appVersion = findViewById(R.id.btn_appVersion);

        String version = btn_appVersion.getText() + ": " + Utils.getAppVersionName();
        btn_appVersion.setText(version);

        findViewById(R.id.button_share).setOnClickListener(v -> {
            Intent sharingIntent = new Intent("android.intent.action.SEND");

            String body = new StringBuilder()
                    .append(getString(R.string.suggest_app_description))
                    .append(" (")
                    .append(getString(R.string.app_name))
                    .append(") ")
                    .append(getString(R.string.app_description))
                    .append(" ")
                    .append("\n")
                    .append("http://play.google.com/store/apps/details?id=")
                    .append(getPackageName())
                    .toString();

            sharingIntent.setType("text/plain");
            sharingIntent.putExtra("android.intent.extra.SUBJECT", getString(R.string.app_name));
            sharingIntent.putExtra("android.intent.extra.TEXT", body);
            startActivity(Intent.createChooser(sharingIntent, "send"));
        });

        findViewById(R.id.button_feedback).setOnClickListener(v -> {
            Intent intent = new Intent(
                    "android.intent.action.SENDTO",
                    Uri.parse("mailto:ideasoftwaretech@gmail.com"));

            String subject = new StringBuilder()
                    .append(getString(R.string.about_feedback_title))
                    .append(" ")
                    .append(getString(R.string.app_name))
                    .append(" v")
                    .append(Utils.getAppVersionName())
                    .toString();

            intent.putExtra("android.intent.extra.SUBJECT", subject);
            startActivity(Intent.createChooser(intent, "Send"));
        });

        findViewById(R.id.button_apps).setOnClickListener(v -> {
            String account = "IdeaS0ft";
            try {
                Utils.searchInMarketApp(account, this);
            } catch (Exception e) {
                e.printStackTrace();
                Utils.searchInMarketSite(account, this);
            }
        });

        findViewById(R.id.button_rate).setOnClickListener(v -> {
            try {
                Utils.openAppInMarketApp(getPackageName(), this);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                Utils.openAppInMarketSite(getPackageName(), this);
            }
        });

        findViewById(R.id.btnTwitter).setOnClickListener(v -> {
            Utils.createIntentChooser(
                    "http://twitter.com/IdeaS0ft",
                    getString(R.string.twitter),
                    this
            );
        });
        findViewById(R.id.btnFacebook).setOnClickListener(v -> {
            Utils.createIntentChooser(
                    "https://www.facebook.com/Idea-Soft-100610612747354",
                    getString(R.string.facebook),
                    this);
        });
    }
}
