package com.idea.zad.common.navigation;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Created by Mickey on 4/1/17.
 */

public interface NavigatorCallback {

    void navigateToActivity(@NonNull Class<?> clazz);

    void navigateToFragment(Fragment fragment, boolean addToBackStack);
    void startActivityForResult(@NonNull Class<?> clazz, int key);
    void navigateToFragment(Fragment fragment, int frameRes, boolean addToBackStack);
    void attachExtraParcelable(Parcelable parcelable);
    void removeFragmentFromFrame(Fragment fragment);
}
