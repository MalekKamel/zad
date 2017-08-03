// Generated code from Butter Knife. Do not modify!
package com.idea.zad.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.idea.zad.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LectureCategoryAdapter$Vh_ViewBinding implements Unbinder {
  private LectureCategoryAdapter.Vh target;

  private View view2131624169;

  @UiThread
  public LectureCategoryAdapter$Vh_ViewBinding(final LectureCategoryAdapter.Vh target,
      View source) {
    this.target = target;

    View view;
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.v_root, "field 'v_root' and method 'onClick'");
    target.v_root = view;
    view2131624169 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.iv_ic = Utils.findRequiredViewAsType(source, R.id.iv_ic, "field 'iv_ic'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LectureCategoryAdapter.Vh target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_title = null;
    target.v_root = null;
    target.iv_ic = null;

    view2131624169.setOnClickListener(null);
    view2131624169 = null;
  }
}
