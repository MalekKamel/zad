// Generated code from Butter Knife. Do not modify!
package com.idea.zad.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.idea.zad.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CategoryAdapter$Vh_ViewBinding implements Unbinder {
  private LectureCategoryAdapter.Vh target;

  private View view2131624193;

  @UiThread
  public CategoryAdapter$Vh_ViewBinding(final LectureCategoryAdapter.Vh target, View source) {
    this.target = target;

    View view;
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.v_root, "method 'onClick'");
    view2131624193 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LectureCategoryAdapter.Vh target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_title = null;

    view2131624193.setOnClickListener(null);
    view2131624193 = null;
  }
}
