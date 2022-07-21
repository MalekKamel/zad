package com.idea.zad.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.idea.zad.R;
import com.idea.zad.common.activity.BaseActivity;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.model.Lecture;
import com.idea.zad.ui.fragment.dialog.OptionsDialog;

import org.parceler.Parcels;

public class LectureActivity extends BaseActivity{

    private Lecture lecture;

    TextView tv_lectureDetails;
    TextView tv_lectureTitle;
    ImageView btn_options;
    ImageView iv_favorite;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int setResourceLayout() {
        return R.layout.activity_lecture;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIntentData();
        setData();
        updateFav();
    }

    private void updateFav() {
        int favoriteIconVisibility = lecture.isFavorite() ? View.VISIBLE : View.GONE;
        iv_favorite.setVisibility(favoriteIconVisibility);
    }

    private void setData() {
        tv_lectureDetails = findViewById(R.id.tv_lectureDetails);
        tv_lectureTitle = findViewById(R.id.tv_title);
        btn_options = findViewById(R.id.btn_options);
        iv_favorite = findViewById(R.id.iv_favorite);

        findViewById(R.id.btn_options).setOnClickListener(v -> {
            OptionsDialog dialog =
                    OptionsDialog.newInstance(
                            lecture,
                            new OptionsDialog.OptionsDialogCallback() {
                                @Override
                                public void onFavoriteOptionClicked(Lecture lecture) {
                                    LectureActivity.this.lecture = lecture;
                                    updateFav();

                                    Intent i = new Intent();
                                    i.putExtra(INTENT_PARCELABLE, Parcels.wrap(lecture));
                                    setResult(RESULT_OK, i);
                                }

                                @Override
                                public void onEdit(Lecture lecture) {

                                }
                            });
            dialog.show(
                    getSupportFragmentManager(),
                    OptionsDialog.class.getSimpleName());
        });

        tv_lectureTitle.setText(lecture.getTitle());
        tv_lectureDetails.setText(lecture.getDetails());
    }

    private void getIntentData() {
        lecture = Parcels.unwrap(getIntent().getParcelableExtra(INTENT_PARCELABLE));
    }
}
