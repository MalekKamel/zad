package com.idea.zad.adapter;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.idea.zad.R;
import com.idea.zad.common.adapter.BaseRecyclerAdapter;
import com.idea.zad.common.adapter.BaseViewHolder;
import com.idea.zad.common.navigation.Navigator;
import com.idea.zad.model.Lecture;
import com.idea.zad.ui.activity.LectureActivity;
import com.idea.zad.ui.fragment.dialog.OptionsDialog;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Sha on 4/20/17.
 */

public class LectureSubcategoryAdapter
        extends BaseRecyclerAdapter<Lecture, LectureSubcategoryAdapter.Vh> {

    private FragmentActivity activity;
    public LectureSubcategoryAdapter(ArrayList<Lecture> values, FragmentActivity activity){
        super(values);
        this.activity = activity;
    }

    @Override
    public Vh getViewHolder(ViewGroup viewGroup) {
        return new Vh(viewGroup);
    }

    public void updateItem(Lecture lecture) {
        for (int i = 0 ; i < getList().size() ; i++){
            Lecture l = getList().get(i);
            if (l.getId() == lecture.getId()){
                getList().set(i, lecture);
                notifyItemChanged(i);
                break;
            }
        }
    }

    class Vh extends BaseViewHolder<Lecture> {
        @BindView(R.id.tv_title)
        TextView tv_title;

        @BindView(R.id.tv_lectureDetails)
        TextView tv_lectureDetails;

        @BindView(R.id.btn_options)
        ImageView btn_options;

        @BindView(R.id.iv_favorite)
        ImageView iv_favorite;

        private Vh(ViewGroup viewGroup) {
            super(viewGroup, R.layout.viewholder_subcategory);
        }

        @Override
        public void bindView(Lecture lecture) {
            tv_title.setText(lecture.getTitle());
            String details = lecture
                    .getDetails()
                    .substring(0, 500)
                    .replaceAll("\n", " ")
                    + "...";
            tv_lectureDetails.setText(details);

            int favoriteIconVisibility = lecture.isFavorite() ? View.VISIBLE : View.GONE;
            iv_favorite.setVisibility(favoriteIconVisibility);
        }

        @OnClick({
                R.id.tv_lectureDetails,
                R.id.btn_options,
        })
        public void onClick(View v){
            switch (v.getId()){

                case R.id.tv_lectureDetails:
                    Navigator navigator = new Navigator(activity);
                    navigator.attachExtraParcelable(
                            Parcels.wrap(getList().get(getLayoutPosition())));
                    navigator.startActivityForResult(LectureActivity.class, RequestCode.CONTENT_ACTIVITY);
                    break;

                case R.id.btn_options:
                    OptionsDialog dialog =
                            OptionsDialog.newInstance(
                                    getList().get(getLayoutPosition()),
                                    new OptionsDialog.OptionsDialogCallback() {
                                        @Override
                                        public void onFavoriteOptionClicked(Lecture lecture) {
                                            for (int i = 0 ; i < getList().size() ; i++){
                                                if (getList().get(i).getId() == lecture.getId()){
                                                    getList().set(i, lecture);
                                                    notifyItemChanged(i);
                                                    break;
                                                }
                                            }
                                        }

                                        @Override
                                        public void onEdit(Lecture lecture) {

                                        }
                                    });
                    dialog.show(
                            activity.getSupportFragmentManager(),
                            OptionsDialog.class.getSimpleName());
                    break;
            }
        }
    }


}