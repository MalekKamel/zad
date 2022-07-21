package com.idea.zad.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class SearchActivity extends BaseActivity implements ToolbarInit{
    RecyclerView rv;
    ImageView iv_empty;
    EditText et_search;

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
        rv = findViewById(R.id.rv);
        iv_empty = findViewById(R.id.iv_empty);
        et_search = findViewById(R.id.et_search);
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                searchSubject.onNext(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

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
                        .flatMap((Function<String, ObservableSource<ArrayList<Lecture>>>) s -> databaseHelper.search(s))
                        .subscribe(lectures -> {
                            int emptyIconVisibility = lectures.isEmpty() ? View.VISIBLE : View.GONE;
                            iv_empty.setVisibility(emptyIconVisibility);

                            if (lectureSubcategoryAdapter == null)
                                lectureSubcategoryAdapter = new LectureSubcategoryAdapter(
                                        lectures,
                                        SearchActivity.this);
                            else
                                lectureSubcategoryAdapter.setList(lectures);
                            rv.setAdapter(lectureSubcategoryAdapter);
                        });
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

