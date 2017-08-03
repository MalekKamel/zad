package com.idea.zad.model;

import org.parceler.Parcel;

/**
 * Created by Sha on 7/23/17.
 */

@Parcel
public class Lecture {
    int id;
    String title;
    String details;
    boolean isFavorite;
    int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        this.isFavorite = favorite;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
}
