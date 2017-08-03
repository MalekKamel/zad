// Generated code from Butter Knife. Do not modify!
package com.idea.zad.ui.fragment.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.idea.zad.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LectureOptionsDialog_ViewBinding implements Unbinder {
  private LectureOptionsDialog target;

  private View view2131624109;

  private View view2131624110;

  private View view2131624113;

  private View view2131624111;

  @UiThread
  public LectureOptionsDialog_ViewBinding(final LectureOptionsDialog target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_share, "field 'btn_share' and method 'onClick'");
    target.btn_share = Utils.castView(view, R.id.btn_share, "field 'btn_share'", Button.class);
    view2131624109 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_copy, "field 'btn_copy' and method 'onClick'");
    target.btn_copy = Utils.castView(view, R.id.btn_copy, "field 'btn_copy'", Button.class);
    view2131624110 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tv_favorite = Utils.findRequiredViewAsType(source, R.id.tv_favorite, "field 'tv_favorite'", TextView.class);
    target.iv_favorite = Utils.findRequiredViewAsType(source, R.id.iv_favorite, "field 'iv_favorite'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_edit, "field 'btn_edit' and method 'onClick'");
    target.btn_edit = Utils.castView(view, R.id.btn_edit, "field 'btn_edit'", Button.class);
    view2131624113 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_favorite, "method 'onClick'");
    view2131624111 = view;
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
    LectureOptionsDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btn_share = null;
    target.btn_copy = null;
    target.tv_favorite = null;
    target.iv_favorite = null;
    target.btn_edit = null;

    view2131624109.setOnClickListener(null);
    view2131624109 = null;
    view2131624110.setOnClickListener(null);
    view2131624110 = null;
    view2131624113.setOnClickListener(null);
    view2131624113 = null;
    view2131624111.setOnClickListener(null);
    view2131624111 = null;
  }
}
