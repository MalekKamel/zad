// Generated code from Butter Knife. Do not modify!
package com.idea.zad.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.idea.zad.R;
import java.lang.CharSequence;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity_ViewBinding implements Unbinder {
  private SearchActivity target;

  private View view2131624089;

  private TextWatcher view2131624089TextWatcher;

  @UiThread
  public SearchActivity_ViewBinding(SearchActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchActivity_ViewBinding(final SearchActivity target, View source) {
    this.target = target;

    View view;
    target.rv = Utils.findRequiredViewAsType(source, R.id.rv, "field 'rv'", RecyclerView.class);
    target.iv_empty = Utils.findRequiredViewAsType(source, R.id.iv_empty, "field 'iv_empty'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.et_search, "method 'onTextChanged'");
    view2131624089 = view;
    view2131624089TextWatcher = new TextWatcher() {
      @Override
      public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
        target.onTextChanged(p0, p1, p2, p3);
      }

      @Override
      public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
      }

      @Override
      public void afterTextChanged(Editable p0) {
      }
    };
    ((TextView) view).addTextChangedListener(view2131624089TextWatcher);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv = null;
    target.iv_empty = null;

    ((TextView) view2131624089).removeTextChangedListener(view2131624089TextWatcher);
    view2131624089TextWatcher = null;
    view2131624089 = null;
  }
}
