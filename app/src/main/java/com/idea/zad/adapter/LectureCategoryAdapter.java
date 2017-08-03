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

import butterknife.BindView;
import butterknife.OnClick;

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
    public LectureCategoryAdapter(ArrayList<LectureCategory> values){
        super(values);
    }

    @Override
    public Vh getViewHolder(ViewGroup viewGroup) {
        return new Vh(viewGroup);
    }

    class Vh extends BaseViewHolder<LectureCategory> {
        @BindView(R.id.tv_title)
        TextView tv_title;

        @BindView(R.id.v_root)
        View v_root;

        @BindView(R.id.iv_ic)
        ImageView iv_ic;

        private Vh(ViewGroup viewGroup) {
            super(viewGroup, R.layout.viewholder_category);
        }

        @Override
        public void bindView(LectureCategory data) {
            tv_title.setText(data.getTitle());

            String drawableName = Utils.getCategoryDrawableName(getLayoutPosition() + 1);
            v_root.setBackgroundResource(Utils.getDrawableIndentifier(drawableName));

            iv_ic.setImageResource(images[getLayoutPosition()]);
        }

        @OnClick({
                R.id.v_root,
        })
        public void onClick(View v){
            switch (v.getId()){

                case R.id.v_root:
                    /**
                     * Call
                     * {@link LectureCategoryFrag#didSelectCategoryItem(EventBusObject)}
                     */
                    EventBusUtil.post(new EventBusObject<>(
                            getList().get(getLayoutPosition()),
                            EventBusTag.USER_SELECTED_CATEGORY)
                    );
                    break;

            }
        }
        

    }

}