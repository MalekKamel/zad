package com.idea.zad.ui.activity;


import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.idea.zad.ui.fragment.SettingsFragment;

public class SettingsActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }


}

