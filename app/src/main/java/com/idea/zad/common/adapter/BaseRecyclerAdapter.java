package com.idea.zad.common.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import java.util.ArrayList;

/**
 * Created by Mickey on 4/20/17.
 */

public abstract class BaseRecyclerAdapter<M,VH extends BaseViewHolder<M>> extends RecyclerView.Adapter<VH> {

    private ArrayList<M> list;

    public BaseRecyclerAdapter(ArrayList<M> list) {
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return getViewHolder(parent);
    }

    public abstract VH getViewHolder(ViewGroup viewGroup);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bindView(list.get(position));
//        startScrollAnim(position, holder.itemView);
    }

    private int lastPosition = 0;
    private void startScrollAnim(int position, View v) {
        if (position <= lastPosition)
            v.setAnimation(null);
        else {
            TranslateAnimation scrollAnim = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF,
                    0.0f,
                    Animation.RELATIVE_TO_SELF,
                    0.0f,
                    Animation.RELATIVE_TO_SELF,
                    0.1f,
                    Animation.RELATIVE_TO_SELF,
                    0.0f);
            scrollAnim.setDuration(300);
            v.startAnimation(scrollAnim);
            lastPosition = position;
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public ArrayList<M> getList() {
        return list;
    }

    public void setList(ArrayList<M> list) {
        this.list = list;
    }
}
