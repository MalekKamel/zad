package com.idea.zad.model;

import org.parceler.Parcel;

/**
 * Created by Sha on 7/23/17.
 */

@Parcel
public class LectureCategory {
    String title;
    int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
