package com.idea.zad.common.util;

/**
 * Created by Mickey on 4/27/17.
 */

public interface ToolbarActionInit extends ToolbarInit {

    void onFirstIconClicked();
    String setActionName();
}
