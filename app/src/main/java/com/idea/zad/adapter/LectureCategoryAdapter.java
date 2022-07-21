package com.idea.zad.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.idea.zad.R;
import com.idea.zad.common.adapter.BaseRecyclerAdapter;
import com.idea.zad.common.adapter.BaseViewHolder;
import com.idea.zad.common.eventbus.EventBusObject;
import com.idea.zad.common.eventbus.EventBusUtil;
import com.idea.zad.common.util.Utils;
import com.idea.zad.model.LectureCategory;
import com.idea.zad.ui.fragment.LectureCategoryFrag;

import java.util.ArrayList;


/**
 * Created by Sha on 4/20/17.
 */

public class LectureCategoryAdapter
        extends BaseRecyclerAdapter<LectureCategory, LectureCategoryAdapter.Vh> {

    public Activity activity;

    private int[] images = {
            R.drawable.ic_mosque,
            R.drawable.ic_islamic_art,
            R.drawable.ic_islamic_art_2,
            R.drawable.ic_islamic_prayer,
            R.drawable.ic_family,
            R.drawable.ic_mosque_and_moon,
            R.drawable.ic_mosque_moon_and_star,
            R.drawable.ic_open_book,
            R.drawable.ic_star_and_crescent,
            R.drawable.ic_mosque_2
    };

    public LectureCategoryAdapter(ArrayList<LectureCategory> values) {
        super(values);
    }

    @Override
    public Vh getViewHolder(ViewGroup viewGroup) {
        return new Vh(viewGroup);
    }

    class Vh extends BaseViewHolder<LectureCategory> {
        TextView tv_title;
        View v_root;
        ImageView iv_ic;

        private Vh(ViewGroup viewGroup) {
            super(viewGroup, R.layout.viewholder_category);
            tv_title = itemView.findViewById(R.id.tv_title);
            v_root = itemView.findViewById(R.id.v_root);
            iv_ic = itemView.findViewById(R.id.iv_ic);
            itemView.findViewById(R.id.v_root).setOnClickListener(v -> {
                /**
                 * Call
                 * {@link LectureCategoryFrag#didSelectCategoryItem(EventBusObject)}
                 */
                EventBusUtil.post(new EventBusObject<>(
                        getList().get(getAdapterPosition()),
                        EventBusTag.USER_SELECTED_CATEGORY)
                );
            });
        }

        @Override
        public void bindView(LectureCategory data) {
            tv_title.setText(data.getTitle());

            String drawableName = Utils.getCategoryDrawableName(getAdapterPosition() + 1);
            v_root.setBackgroundResource(Utils.getDrawableIndentifier(drawableName));

            iv_ic.setImageResource(images[getAdapterPosition()]);
        }
    }

}