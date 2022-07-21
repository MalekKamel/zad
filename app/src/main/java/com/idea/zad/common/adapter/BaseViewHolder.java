package com.idea.zad.common.adapter;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.idea.zad.constants.C;

/**
 * Created by Mickey on 4/20/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements C {


    public BaseViewHolder(ViewGroup viewGroup, @LayoutRes int layoutRes) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(layoutRes, viewGroup, false));
    }

    public abstract void bindView(T item);

}
