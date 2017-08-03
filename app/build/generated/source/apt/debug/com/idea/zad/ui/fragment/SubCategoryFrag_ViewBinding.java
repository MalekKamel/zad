// Generated code from Butter Knife. Do not modify!
package com.idea.zad.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.idea.zad.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SubCategoryFrag_ViewBinding implements Unbinder {
  private LectureSubcategoryFrag target;

  @UiThread
  public SubCategoryFrag_ViewBinding(LectureSubcategoryFrag target, View source) {
    this.target = target;

    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LectureSubcategoryFrag target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv = null;
  }
}
