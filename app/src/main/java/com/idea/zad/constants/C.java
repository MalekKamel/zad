package com.idea.zad.constants;

public interface C {
    String DATABASE_NAME = "ZadDB.db";
    int DATABASE_VERSION = 1;
    String KEY_DETAILS = "details";
    String KEY_TITLE = "title";
    String KEY_ID = "_id";
    String KEY_CATEGORY = "category";
    String TABLE_ZAD = "zad";
    String KEY_IS_FAVORITE = "is_favorite";
    String VERSION_QUERY = "SELECT version_id FROM dbVersion";

    enum EventBusTag {
        USER_SELECTED_CATEGORY,
        TOOLBAR_TITLE_CHANGE
    }
    String INTENT_PARCELABLE = "intentParcelable";

    interface RequestCode{
        int SETTINGS_ACTIVITY = 0;
        int CONTENT_ACTIVITY = 1;
        int EDIT_ACTIVITY = 3;
    }
}
