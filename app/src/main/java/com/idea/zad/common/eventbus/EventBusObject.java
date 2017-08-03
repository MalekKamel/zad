package com.idea.zad.common.eventbus;


import com.idea.zad.constants.C;

public class EventBusObject<T> {
    private T obj;
    private final C.EventBusTag eventTag;

    public EventBusObject(T obj, C.EventBusTag eventTag) {
        this.eventTag = eventTag;
        this.obj = obj;
    }

    public C.EventBusTag getActionTag() {
        return eventTag;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T list) {
        this.obj = list;
    }
}
