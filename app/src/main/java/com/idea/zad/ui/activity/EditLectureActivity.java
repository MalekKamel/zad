package com.idea.zad.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.idea.zad.R;
import com.idea.zad.common.activity.BaseActivity;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.database.DatabaseHelper;
import com.idea.zad.model.Lecture;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.OnClick;

public class EditLectureActivity extends BaseActivity{

    private Lecture lecture;

    @BindView(R.id.et_editLecture)
    EditText et_editLecture;

    @BindView(R.id.tv_title)
    TextView tv_lectureTitle;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int setResourceLayout() {
        return R.layout.activity_edit_lecture;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIntentData();
        setData();
    }

    private void getIntentData() {
        lecture = Parcels.unwrap(getIntent().getParcelableExtra(INTENT_PARCELABLE));
    }

    private void setData() {
        tv_lectureTitle.setText(lecture.getTitle());
        et_editLecture.setText(lecture.getDetails());
    }

    @OnClick(R.id.btn_save)
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_save:
                if (et_editLecture.getText().toString().equals(lecture.getDetails())){
                    finish();
                    return; // No edit
                }

                lecture.setDetails(et_editLecture.getText().toString());
                int id = DatabaseHelper.getInstance().updateLecture(lecture);
                if (id == 1){
                    toast(R.string.update_done);

                    Intent i = new Intent();
                    i.putExtra(INTENT_PARCELABLE, Parcels.wrap(lecture));
                    setResult(RESULT_OK, i);

                    finish();
                }
                else {
                    toast(R.string.update_error);
                }
                break;
        }
    }


}
