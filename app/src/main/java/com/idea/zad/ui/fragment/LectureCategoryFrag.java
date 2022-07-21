package com.idea.zad.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.idea.zad.R;
import com.idea.zad.adapter.LectureCategoryAdapter;
import com.idea.zad.common.eventbus.EventBusObject;
import com.idea.zad.common.eventbus.EventBusUtil;
import com.idea.zad.common.frag.BaseFragment;
import com.idea.zad.common.navigation.Navigator;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.eventbus.ToolbarTitleChangeEvent;
import com.idea.zad.model.LectureCategory;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;


public class LectureCategoryFrag extends BaseFragment {

    RecyclerView rv;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int setResourceLayout() {
        return R.layout.fragment_category;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setData();
    }

    private void setData() {
        rv = getView().findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));

        String[] categoryTitles = getResources().getStringArray(R.array.category_titles);
        ArrayList<LectureCategory> categories = new ArrayList<>();
        LectureCategory category;
        int id = 1;
        for (String title : categoryTitles) {
            category = new LectureCategory();
            category.setTitle(title);
            category.setId(id);
            categories.add(category);
            id++;
        }
        rv.setAdapter(new LectureCategoryAdapter(categories));

        /**
         * Call {@link com.idea.zad.ui.activity.MainActivity#onChangeToolbarTitle(EventBusObject)}
         */
        ToolbarTitleChangeEvent event = new ToolbarTitleChangeEvent(
                getString(R.string.category));
        EventBusUtil.post(new EventBusObject<>(
                event,
                EventBusTag.TOOLBAR_TITLE_CHANGE));
    }


    @Subscribe
    public void didSelectCategoryItem(EventBusObject<LectureCategory> event) {
        switch (event.getActionTag()) {
            case USER_SELECTED_CATEGORY:
                LectureSubcategoryFrag frag = LectureSubcategoryFrag.getInstance(event.getObj());
                new Navigator(getContext()).navigateToFragment(frag, true);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBusUtil.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBusUtil.unregister(this);

    }
}