// Generated code from Butter Knife. Do not modify!
package com.idea.zad.ui.fragment.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.idea.zad.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LectureOptionsDialog_ViewBinding implements Unbinder {
  private OptionsDialog target;

  private View view2131624110;

  private View view2131624111;

  private View view2131624112;

  private View view2131624114;

  @UiThread
  public LectureOptionsDialog_ViewBinding(final OptionsDialog target, View source) {
    this.target = target;

    View view;
    target.tv_favorite = Utils.findRequiredViewAsType(source, R.id.tv_favorite, "field 'tv_favorite'", Button.class);
    target.iv_favorite = Utils.findRequiredViewAsType(source, R.id.iv_favorite, "field 'iv_favorite'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_share, "method 'onClick'");
    view2131624110 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_copy, "method 'onClick'");
    view2131624111 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_favorite, "method 'onClick'");
    view2131624112 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_edit, "method 'onClick'");
    view2131624114 = view;
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
    OptionsDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_favorite = null;
    target.iv_favorite = null;

    view2131624110.setOnClickListener(null);
    view2131624110 = null;
    view2131624111.setOnClickListener(null);
    view2131624111 = null;
    view2131624112.setOnClickListener(null);
    view2131624112 = null;
    view2131624114.setOnClickListener(null);
    view2131624114 = null;
  }
}
