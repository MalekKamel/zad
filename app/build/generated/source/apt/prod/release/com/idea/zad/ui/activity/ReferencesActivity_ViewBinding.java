// Generated code from Butter Knife. Do not modify!
package com.idea.zad.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.idea.zad.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReferencesActivity_ViewBinding implements Unbinder {
  private ReferencesActivity target;

  private View view2131624088;

  @UiThread
  public ReferencesActivity_ViewBinding(ReferencesActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReferencesActivity_ViewBinding(final ReferencesActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.iv_islamDoorLogo, "method 'onClick'");
    view2131624088 = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131624088.setOnClickListener(null);
    view2131624088 = null;
  }
}
