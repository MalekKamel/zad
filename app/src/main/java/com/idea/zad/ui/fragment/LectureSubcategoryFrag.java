package com.idea.zad.ui.fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.idea.zad.R;
import com.idea.zad.adapter.LectureSubcategoryAdapter;
import com.idea.zad.common.eventbus.EventBusObject;
import com.idea.zad.common.eventbus.EventBusUtil;
import com.idea.zad.common.frag.BaseFragment;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.database.DatabaseHelper;
import com.idea.zad.eventbus.ToolbarTitleChangeEvent;
import com.idea.zad.model.Lecture;
import com.idea.zad.model.LectureCategory;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;


public class LectureSubcategoryFrag extends BaseFragment{

    @BindView(R.id.rv)
    RecyclerView rv;

    private LectureCategory category;

    public static LectureSubcategoryFrag getInstance(LectureCategory category) {
        LectureSubcategoryFrag instance = new LectureSubcategoryFrag();
        instance.setCategory(category);
        return instance;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int setResourceLayout() {
        return R.layout.fragment_subcategory;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        setData();
    }

    private void setData() {
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Lecture> lectures = DatabaseHelper.getInstance().getLecturesByCategory(category.getId());

        rv.setAdapter(new LectureSubcategoryAdapter(lectures, getActivity()));

        /**
         * Call {@link com.idea.zad.ui.activity.MainActivity#onChangeToolbarTitle(EventBusObject)}
         */
        ToolbarTitleChangeEvent event = new ToolbarTitleChangeEvent(
                category.getTitle());
        EventBusUtil.post(new EventBusObject<>(
                event,
                EventBusTag.TOOLBAR_TITLE_CHANGE));
    }


    public void setCategory(LectureCategory category) {
        this.category = category;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
    
