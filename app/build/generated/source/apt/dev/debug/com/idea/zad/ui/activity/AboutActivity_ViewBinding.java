// Generated code from Butter Knife. Do not modify!
package com.idea.zad.ui.activity;

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

public class AboutActivity_ViewBinding implements Unbinder {
  private AboutActivity target;

  private View view2131624069;

  private View view2131624071;

  private View view2131624072;

  private View view2131624070;

  private View view2131624074;

  private View view2131624073;

  @UiThread
  public AboutActivity_ViewBinding(AboutActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AboutActivity_ViewBinding(final AboutActivity target, View source) {
    this.target = target;

    View view;
    target.btn_appVersion = Utils.findRequiredViewAsType(source, R.id.btn_appVersion, "field 'btn_appVersion'", TextView.class);
    view = Utils.findRequiredView(source, R.id.button_share, "method 'onClick'");
    view2131624069 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.button_feedback, "method 'onClick'");
    view2131624071 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.button_apps, "method 'onClick'");
    view2131624072 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.button_rate, "method 'onClick'");
    view2131624070 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnTwitter, "method 'onClick'");
    view2131624074 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnFacebook, "method 'onClick'");
    view2131624073 = view;
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
    AboutActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btn_appVersion = null;

    view2131624069.setOnClickListener(null);
    view2131624069 = null;
    view2131624071.setOnClickListener(null);
    view2131624071 = null;
    view2131624072.setOnClickListener(null);
    view2131624072 = null;
    view2131624070.setOnClickListener(null);
    view2131624070 = null;
    view2131624074.setOnClickListener(null);
    view2131624074 = null;
    view2131624073.setOnClickListener(null);
    view2131624073 = null;
  }
}
