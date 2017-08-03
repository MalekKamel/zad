package com.idea.zad.eventbus;

/**
 * Created by Sha on 7/27/17.
 */

public class ToolbarTitleChangeEvent {

    private String title;

    public ToolbarTitleChangeEvent(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
