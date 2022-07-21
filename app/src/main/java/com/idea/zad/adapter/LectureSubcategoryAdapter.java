package com.idea.zad.adapter;

import androidx.fragment.app.FragmentActivity;
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
        TextView tv_title;
        TextView tv_lectureDetails;
        ImageView btn_options;
        ImageView iv_favorite;

        private Vh(ViewGroup viewGroup) {
            super(viewGroup, R.layout.viewholder_subcategory);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_lectureDetails = itemView.findViewById(R.id.tv_lectureDetails);
            btn_options = itemView.findViewById(R.id.btn_options);
            iv_favorite = itemView.findViewById(R.id.iv_favorite);

            itemView.findViewById(R.id.tv_lectureDetails).setOnClickListener(v -> {
                Navigator navigator = new Navigator(activity);
                navigator.attachExtraParcelable(
                        Parcels.wrap(getList().get(getAdapterPosition())));
                navigator.startActivityForResult(LectureActivity.class, RequestCode.CONTENT_ACTIVITY);
            });

            itemView.findViewById(R.id.btn_options).setOnClickListener(v -> {
                OptionsDialog dialog =
                        OptionsDialog.newInstance(
                                getList().get(getAdapterPosition()),
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
            });
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
    }

}