package com.idea.zad.common.eventbus;


import com.idea.zad.constants.C;

import java.util.ArrayList;


public class EventBusList<T> {
    private ArrayList<T> list;
    private final C.EventBusTag eventTag;

    public EventBusList(ArrayList<T> list, C.EventBusTag eventTag) {
        this.eventTag = eventTag;
        this.list = list;
    }

    public C.EventBusTag getActionTag() {
        return eventTag;
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }
}
