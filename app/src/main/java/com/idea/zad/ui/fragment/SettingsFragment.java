package com.idea.zad.ui.fragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import com.idea.zad.R;
import com.idea.zad.common.navigation.Navigator;
import com.idea.zad.database.DatabaseHelper;
import com.idea.zad.model.Lecture;
import com.idea.zad.ui.activity.LectureActivity;
import org.parceler.Parcels;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        init();
    }

    private void init() {
        Preference lecturePreview = findPreference("lecturePreview");
        lecturePreview.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Lecture lecture =
                        DatabaseHelper.getInstance().getLectureForPreview();

                Navigator navigator = new Navigator(getActivity());
                navigator.attachExtraParcelable(
                        Parcels.wrap(lecture));
                navigator.navigateToActivity(LectureActivity.class);
                return true;
            }
        });
    }


}