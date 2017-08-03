package com.idea.zad.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.idea.zad.R;

public final class ResetPrefsDialogPreference extends DialogPreference
        implements SharedPreferences.OnSharedPreferenceChangeListener  {
    public ResetPrefsDialogPreference(Context context, AttributeSet attrs) {
	super(context, attrs);

    }

    @Override
    protected View onCreateDialogView() {
	// Get current value from preferences

	// Inflate layout
	LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        return inflater.inflate(R.layout.dialog_reset_prefs, null);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
	super.onDialogClosed(positiveResult);

	// Return if change was cancelled
	if (positiveResult) {
        resetPrefs();

    }
	// Notify com.zad.doaa.activity about changes (to update preference summary line)
	notifyChanged();
    }

    @Override
    public CharSequence getSummary() {
	return null;
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }

    private void resetPrefs(){
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getContext());
        SP.edit().clear().apply();
    }
}