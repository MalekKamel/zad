// Generated code from Butter Knife. Do not modify!
package com.idea.zad.ui.activity;

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

public class LectureActivity_ViewBinding implements Unbinder {
  private LectureActivity target;

  private View view2131624081;

  @UiThread
  public LectureActivity_ViewBinding(LectureActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LectureActivity_ViewBinding(final LectureActivity target, View source) {
    this.target = target;

    View view;
    target.tv_lectureDetails = Utils.findRequiredViewAsType(source, R.id.tv_lectureDetails, "field 'tv_lectureDetails'", TextView.class);
    target.tv_lectureTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_lectureTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_options, "field 'btn_options' and method 'onClick'");
    target.btn_options = Utils.castView(view, R.id.btn_options, "field 'btn_options'", ImageView.class);
    view2131624081 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.iv_favorite = Utils.findRequiredViewAsType(source, R.id.iv_favorite, "field 'iv_favorite'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LectureActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_lectureDetails = null;
    target.tv_lectureTitle = null;
    target.btn_options = null;
    target.iv_favorite = null;

    view2131624081.setOnClickListener(null);
    view2131624081 = null;
  }
}
