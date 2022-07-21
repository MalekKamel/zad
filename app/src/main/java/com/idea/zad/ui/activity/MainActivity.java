package com.idea.zad.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.idea.zad.R;
import com.idea.zad.common.activity.BaseActivity;
import com.idea.zad.common.eventbus.EventBusObject;
import com.idea.zad.common.eventbus.EventBusUtil;
import com.idea.zad.common.navigation.Navigator;
import com.idea.zad.common.presenter.BasePresenter;
import com.idea.zad.component.FontUtils;
import com.idea.zad.eventbus.ToolbarTitleChangeEvent;
import com.idea.zad.ui.fragment.LectureCategoryFrag;
import com.idea.zad.ui.fragment.LectureSubcategoryFrag;

import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseActivity {

    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;

    DrawerLayout mDrawerLayout;

    NavigationView navigationView;

    TextView tv_toolbarTitle;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int setResourceLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        tv_toolbarTitle = findViewById(R.id.tv_toolbarTitle);

        // IMPORTANT: register here to consume toolbar title change event
        EventBusUtil.register(this);

        initDrawerLayout();

        FontUtils.customizeNavigationViewItemsFont(navigationView);

        navigateToCategoryFrag();
    }

    private void navigateToCategoryFrag() {
        new Navigator(this).navigateToFragment(new LectureCategoryFrag(), false);
    }


    /**
     * Important to show Drawer icon in Toolbar.
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private void initDrawerLayout() {

        if (navigationView != null) {
            navigationView.setItemIconTintList(null);
            navigationView.setNavigationItemSelectedListener(
                    item -> {
                        Class clazz = null;

                        switch (item.getItemId()){
                            case R.id.drawer_search:
                                clazz = SearchActivity.class;
                                break;

                            case R.id.drawer_favorites:
                                clazz = FavoriteActivity.class;
                                break;

                            case R.id.drawer_settings:
                                startActivityForResult(
                                        new Intent(MainActivity.this, SettingsActivity.class),
                                        RequestCode.SETTINGS_ACTIVITY);
                                break;

                            case R.id.drawer_references:
                                clazz = ReferencesActivity.class;
                                break;
                            case R.id.drawer_about:
                                clazz = AboutActivity.class;
                                break;
                        }

                        if (clazz !=  null)
                            new Navigator(MainActivity.this).navigateToActivity(clazz);

                        mDrawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    });
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                toolbar,
                R.string.app_name,
                R.string.app_name);
        mDrawerLayout.addDrawerListener(toggle);
    }


    @Override
    protected void onResume() {
        super.onResume();
        EventBusUtil.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBusUtil.unregister(this);
    }

    @Subscribe
    public void onChangeToolbarTitle(EventBusObject<ToolbarTitleChangeEvent> event){
        switch (event.getActionTag()){
            case TOOLBAR_TITLE_CHANGE:
                tv_toolbarTitle.setText(event.getObj().getTitle());
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RequestCode.SETTINGS_ACTIVITY:
                navigateToCategoryFrag();
                break;

            case RequestCode.CONTENT_ACTIVITY:
            case RequestCode.EDIT_ACTIVITY:
                Fragment currentFragment =
                        getSupportFragmentManager()
                                .findFragmentByTag(LectureSubcategoryFrag.class.getSimpleName());
                if (currentFragment != null)
                    currentFragment.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }

}
