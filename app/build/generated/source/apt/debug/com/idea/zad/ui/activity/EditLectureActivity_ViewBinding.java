// Generated code from Butter Knife. Do not modify!
package com.idea.zad.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.idea.zad.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditLectureActivity_ViewBinding implements Unbinder {
  private EditLectureActivity target;

  private View view2131624076;

  @UiThread
  public EditLectureActivity_ViewBinding(EditLectureActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EditLectureActivity_ViewBinding(final EditLectureActivity target, View source) {
    this.target = target;

    View view;
    target.et_editLecture = Utils.findRequiredViewAsType(source, R.id.et_editLecture, "field 'et_editLecture'", EditText.class);
    target.tv_lectureTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_lectureTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_save, "method 'onClick'");
    view2131624076 = view;
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
    EditLectureActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.et_editLecture = null;
    target.tv_lectureTitle = null;

    view2131624076.setOnClickListener(null);
    view2131624076 = null;
  }
}
