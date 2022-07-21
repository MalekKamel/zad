package com.idea.zad.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.idea.zad.R;
import com.idea.zad.adapter.LectureSubcategoryAdapter;
import com.idea.zad.common.activity.BaseActivity;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.common.util.ToolbarActionInit;
import com.idea.zad.database.DatabaseHelper;
import com.idea.zad.model.Lecture;

import org.parceler.Parcels;

import java.util.ArrayList;


public class FavoriteActivity extends BaseActivity implements ToolbarActionInit{

    RecyclerView rv;
    ImageView iv_empty;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int setResourceLayout() {
        return R.layout.activity_favorite;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        getData();
    }

    private void init() {
        rv = findViewById(R.id.rv);
        iv_empty = findViewById(R.id.iv_empty);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getData() {
        ArrayList<Lecture> lectures =  DatabaseHelper.getInstance().getFavoriteLectures();

        int emptyIconVisibility = lectures.isEmpty() ? View.VISIBLE : View.GONE;
        iv_empty.setVisibility(emptyIconVisibility);

        rv.setAdapter(new LectureSubcategoryAdapter(lectures, this));
    }

    @Override
    public String initToolbarTitle() {
        return getString(R.string.favorites);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RequestCode.CONTENT_ACTIVITY:
            case RequestCode.EDIT_ACTIVITY:
                if (data != null){
                    Lecture lecture = Parcels.unwrap(data.getParcelableExtra(INTENT_PARCELABLE));
                    ((LectureSubcategoryAdapter)rv.getAdapter()).updateItem(lecture);
                }
                break;
        }
    }
}
