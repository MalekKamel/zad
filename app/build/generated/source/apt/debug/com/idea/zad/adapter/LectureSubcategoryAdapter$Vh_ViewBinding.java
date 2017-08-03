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

public class LectureSubcategoryAdapter$Vh_ViewBinding implements Unbinder {
  private LectureSubcategoryAdapter.Vh target;

  private View view2131624083;

  private View view2131624081;

  @UiThread
  public LectureSubcategoryAdapter$Vh_ViewBinding(final LectureSubcategoryAdapter.Vh target,
      View source) {
    this.target = target;

    View view;
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_lectureDetails, "field 'tv_lectureDetails' and method 'onClick'");
    target.tv_lectureDetails = Utils.castView(view, R.id.tv_lectureDetails, "field 'tv_lectureDetails'", TextView.class);
    view2131624083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
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
    LectureSubcategoryAdapter.Vh target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_title = null;
    target.tv_lectureDetails = null;
    target.btn_options = null;
    target.iv_favorite = null;

    view2131624083.setOnClickListener(null);
    view2131624083 = null;
    view2131624081.setOnClickListener(null);
    view2131624081 = null;
  }
}
