package com.idea.zad.common.eventbus;


import com.idea.zad.constants.C;

/**
 * Created by sha on 23/04/17.
 */

public class EventBustAction {
    private final C.EventBusTag eventTag;

    public EventBustAction(C.EventBusTag eventTag) {
        this.eventTag = eventTag;
    }

    public C.EventBusTag getActionTag() {
        return eventTag;
    }
}
