package com.idea.zad.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.idea.zad.R;
import com.idea.zad.adapter.LectureSubcategoryAdapter;
import com.idea.zad.common.activity.BaseActivity;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.common.util.ToolbarInit;
import com.idea.zad.database.DatabaseHelper;
import com.idea.zad.model.Lecture;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnTextChanged;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class SearchActivity extends BaseActivity implements ToolbarInit{

    @BindView(R.id.rv)
    RecyclerView rv;

    @BindView(R.id.iv_empty)
    ImageView iv_empty;

    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
    private PublishSubject<String> searchSubject;
    private Disposable mTextWatchSubscription;
    private LectureSubcategoryAdapter lectureSubcategoryAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int setResourceLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        initSearchObservable();
    }

    private void initSearchObservable() {
        searchSubject = PublishSubject.create();
        mTextWatchSubscription =
                searchSubject
                        .debounce(400, TimeUnit.MILLISECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .flatMap(new Function<String, ObservableSource<ArrayList<Lecture>>>() {
                            @Override
                            public ObservableSource<ArrayList<Lecture>> apply(String s) throws Exception {
                                return databaseHelper.search(s);
                            }
                        })
                        .subscribe(new Consumer<ArrayList<Lecture>>() {
                            @Override
                            public void accept(ArrayList<Lecture> lectures) throws Exception {
                                int emptyIconVisibility = lectures.isEmpty() ? View.VISIBLE : View.GONE;
                                iv_empty.setVisibility(emptyIconVisibility);

                                if (lectureSubcategoryAdapter == null)
                                    lectureSubcategoryAdapter = new LectureSubcategoryAdapter(
                                            lectures,
                                            SearchActivity.this);
                                else
                                    lectureSubcategoryAdapter.setList(lectures);
                                rv.setAdapter(lectureSubcategoryAdapter);
                            }
                        });
    }

    @OnTextChanged(R.id.et_search)
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        searchSubject.onNext(s.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTextWatchSubscription.dispose();
    }

    @Override
    public String initToolbarTitle() {
        return getString(R.string.search);
    }

    @Override
    public void onToolbarActionClicked() {

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

