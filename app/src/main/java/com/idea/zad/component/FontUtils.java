package com.idea.zad.component;

import android.graphics.Typeface;
import com.google.android.material.navigation.NavigationView;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.idea.zad.util.SharedPref;

/**
 * Created by Sha on 8/2/17.
 */

public class FontUtils {

    public static void customizeNavigationViewItemsFont(NavigationView navigationView) {
        Menu m = navigationView.getMenu();
        for (int i = 0 ; i < m.size() ; i++) {
            MenuItem mi = m.getItem(i);

            //for applying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0 ) {
                for (int j = 0; j <subMenu.size() ; j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }

    }

    private static void applyFontToMenuItem(MenuItem mi) {
        Typeface tf = FontCache.getTypeface(SharedPref.getInstance().getAppFontType());

        SpannableString newTitle = new SpannableString(mi.getTitle());
        newTitle.setSpan(
                new CustomTypefaceSpan(tf),
                0 ,
                newTitle.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
        );
        mi.setTitle(newTitle);
    }
}
