// Generated code from Butter Knife. Do not modify!
package com.idea.zad.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.idea.zad.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FavoriteActivity_ViewBinding implements Unbinder {
  private FavoriteActivity target;

  @UiThread
  public FavoriteActivity_ViewBinding(FavoriteActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FavoriteActivity_ViewBinding(FavoriteActivity target, View source) {
    this.target = target;

    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
    target.iv_empty = Utils.findRequiredViewAsType(source, R.id.iv_empty, "field 'iv_empty'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FavoriteActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv = null;
    target.iv_empty = null;
  }
}
