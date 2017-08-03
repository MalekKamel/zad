// Generated code from Butter Knife. Do not modify!
package com.idea.zad.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.idea.zad.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.mDrawerLayout = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'mDrawerLayout'", DrawerLayout.class);
    target.navigationView = Utils.findRequiredViewAsType(source, R.id.nav_view, "field 'navigationView'", NavigationView.class);
    target.tv_toolbarTitle = Utils.findRequiredViewAsType(source, R.id.tv_toolbarTitle, "field 'tv_toolbarTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mDrawerLayout = null;
    target.navigationView = null;
    target.tv_toolbarTitle = null;
  }
}
