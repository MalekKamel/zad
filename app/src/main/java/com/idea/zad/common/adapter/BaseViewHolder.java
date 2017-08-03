package com.idea.zad.common.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.idea.zad.constants.C;

import butterknife.ButterKnife;

/**
 * Created by Mickey on 4/20/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements C {


    public BaseViewHolder(ViewGroup viewGroup, @LayoutRes int layoutRes) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(layoutRes, viewGroup, false));
        ButterKnife.bind(this, itemView);
    }

    public abstract void bindView(T item);

}
