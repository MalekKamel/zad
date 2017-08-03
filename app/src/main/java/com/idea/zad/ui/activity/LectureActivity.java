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

import butterknife.BindView;
import butterknife.OnClick;

public class LectureActivity extends BaseActivity{

    private Lecture lecture;

    @BindView(R.id.tv_lectureDetails)
    TextView tv_lectureDetails;

    @BindView(R.id.tv_title)
    TextView tv_lectureTitle;

    @BindView(R.id.btn_options)
    ImageView btn_options;

    @BindView(R.id.iv_favorite)
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
        tv_lectureTitle.setText(lecture.getTitle());
        tv_lectureDetails.setText(lecture.getDetails());
    }

    private void getIntentData() {
        lecture = Parcels.unwrap(getIntent().getParcelableExtra(INTENT_PARCELABLE));
    }


    @OnClick(R.id.btn_options)
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_options:
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
                break;
        }
    }

}
