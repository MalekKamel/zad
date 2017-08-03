package com.idea.zad.common.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.idea.zad.R;
import com.idea.zad.constants.C;


/**
 * Created by Sha on 4/1/17.
 */

public class Navigator implements NavigatorCallback, C {

    private Context context = null;
    private Parcelable extraParcelable;

    public Navigator(Context context) {
        this.context = context;
    }

    @Override
    public void navigateToActivity(@NonNull Class<?> clazz) {
        Intent intent = new Intent(context,clazz);
        attachToActivity(intent);
        context.startActivity(intent);
    }

    public void navigateToActivityWithClearTask(@NonNull Class<?> clazz) {
        Intent intent = new Intent(context,clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        attachToActivity(intent);
        context.startActivity(intent);
    }

    @Override
    public void startActivityForResult(@NonNull Class<?> clazz, int key) {
         Intent intent = new Intent(context, clazz);
         attachToActivity(intent);
         ((Activity)context).startActivityForResult(intent, key);
     }

    private void attachToActivity(Intent intent) {
        if (extraParcelable != null)
            intent.putExtra(INTENT_PARCELABLE, extraParcelable);
    }

    @Override
    public void navigateToFragment(Fragment fragment, boolean addToBackStack) {
        attachToFrag(fragment);

        FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame,fragment,fragment.getClass().getSimpleName());
        if (addToBackStack)
            ft.addToBackStack(fragment.getClass().getSimpleName());
        ft.commit();
    }

    private void attachToFrag(Fragment fragment) {
        if (extraParcelable != null) {
            Bundle bundle=new Bundle();
            bundle.putParcelable(INTENT_PARCELABLE, extraParcelable);
            fragment.setArguments(bundle);
        }
    }

    @Override
    public void navigateToFragment(Fragment fragment, int frameRes, boolean addToBackStack) {
        attachToFrag(fragment);

        FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
        ft.replace(frameRes,fragment,fragment.getClass().getSimpleName());
        if (addToBackStack)
            ft.addToBackStack(fragment.getClass().getSimpleName());
        ft.commit();
    }

    @Override
    public void attachExtraParcelable(Parcelable parcelable) {
        this.extraParcelable = parcelable;
    }

    @Override
    public void removeFragmentFromFrame(Fragment fragment) {
        ((FragmentActivity)context).getSupportFragmentManager()
                .beginTransaction()
                .remove(fragment)
                .commit();
    }
}
