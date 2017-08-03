package com.idea.zad.ui.fragment.dialog;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.idea.zad.R;
import com.idea.zad.common.navigation.Navigator;
import com.idea.zad.common.util.Utils;
import com.idea.zad.constants.C;
import com.idea.zad.database.DatabaseHelper;
import com.idea.zad.model.Lecture;
import com.idea.zad.ui.activity.EditLectureActivity;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OptionsDialog extends DialogFragment  {


    public interface OptionsDialogCallback {
        void onFavoriteOptionClicked(Lecture lecture);
        void onEdit(Lecture lecture);
    }
   private OptionsDialogCallback callback;

    @BindView(R.id.tv_favorite)
    Button tv_favorite;

    @BindView(R.id.iv_favorite)
    ImageView iv_favorite;

    private Lecture lecture;

    public static OptionsDialog newInstance(Lecture lecture, OptionsDialogCallback callback) {
        OptionsDialog fragment = new OptionsDialog();
        fragment.setOnCitySelectedListener(lecture);
        fragment.setCallback(callback);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog_options, container, false);
        ButterKnife.bind(this, v);
        init();
        return v;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    private void init() {
        updateFav();
    }

    private void updateFav() {
        int favRes = lecture.isFavorite() ? R.drawable.ic_favorite_on : R.drawable.ic_favorite_off;
        iv_favorite.setImageResource(favRes);

//        int txtRes = lecture.isFavorite() ? R.string.fav_off : R.string.fav_on;
//        tv_favorite.setText(txtRes);
    }

    public void setOnCitySelectedListener(Lecture lecture) {
        this.lecture = lecture;
    }

    @OnClick({
            R.id.btn_share,
            R.id.btn_copy,
            R.id.btn_favorite,
            R.id.btn_edit
    })
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_share:
                Intent sharingIntent = new Intent("android.intent.action.SEND");

                String body = new StringBuilder()
                        .append(lecture.getTitle())
                        .append("\n")
                        .append(lecture.getDetails())
                        .append("\n")
                        .append("------------------- \n")
                        .append(getString(R.string.shared))
                        .append(" ( ")
                        .append(getString(R.string.app_name))
                        .append(" - ")
                        .append(getString(R.string.slogan))
                        .append(") ")
                        .append(getString(R.string.for_android))
                        .append("\n")
                        .append("http://play.google.com/store/apps/details?id=")
                        .append(getActivity().getPackageName())
                        .toString();

                sharingIntent.setType("text/plain");
                sharingIntent.putExtra("android.intent.extra.SUBJECT", getString(R.string.app_name));
                sharingIntent.putExtra("android.intent.extra.TEXT", body);
                startActivity(Intent.createChooser(sharingIntent, "send"));
                break;

            case R.id.btn_copy:
                ClipboardManager clipboard = (ClipboardManager)
                        getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("lecture", lecture.getDetails());
                clipboard.setPrimaryClip(clip);
                Utils.toast(R.string.copied);
                break;

            case R.id.btn_favorite:
                int id = DatabaseHelper.getInstance().toggleFavorite(
                        lecture.getId(),
                        lecture.isFavorite());
                lecture.setFavorite(!lecture.isFavorite());
                callback.onFavoriteOptionClicked(lecture);
                if (id == 1)
                    updateFav();
                break;

            case R.id.btn_edit:
                Navigator navigator = new Navigator(getContext());
                navigator.attachExtraParcelable(Parcels.wrap(lecture));
                navigator.startActivityForResult(EditLectureActivity.class, C.RequestCode.EDIT_ACTIVITY);
                break;
        }

        dismiss();
    }

    public void setCallback(OptionsDialogCallback callback) {
        this.callback = callback;
    }
}