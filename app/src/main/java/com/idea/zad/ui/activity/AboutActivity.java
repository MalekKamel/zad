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

import butterknife.BindView;
import butterknife.OnClick;

public class AboutActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.btn_appVersion)
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
        String version = btn_appVersion.getText() + ": " + Utils.getAppVersionName();
        btn_appVersion.setText(version);
    }

    @OnClick({
            R.id.button_share,
            R.id.button_feedback,
            R.id.button_apps,
            R.id.button_rate,
            R.id.btnTwitter,
            R.id.btnFacebook
    })
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_share:
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
                break;

            case R.id.button_feedback:
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
                break;

            case R.id.button_apps:
                String account = "IdeaS0ft";
                try{
                    Utils.searchInMarketApp(account, this);
                }
                catch (Exception e){
                    e.printStackTrace();
                    Utils.searchInMarketSite(account, this);
                }
                break;

            case R.id.button_rate:
                try {
                    Utils.openAppInMarketApp(getPackageName(), this);
                }
                catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    Utils.openAppInMarketSite(getPackageName(), this);
                }
                break;

            case R.id.btnTwitter:
                Utils.createIntentChooser(
                        "http://twitter.com/IdeaS0ft",
                        getString(R.string.twitter),
                        this
                );
                break;

            case R.id.btnFacebook:
                Utils.createIntentChooser(
                        "https://www.facebook.com/Idea-Soft-249042682134802/",
                        getString(R.string.facebook),
                        this);
                break;

        }
    }

}
