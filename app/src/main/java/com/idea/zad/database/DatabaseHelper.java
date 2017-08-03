package com.idea.zad.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.idea.zad.common.MyApp;
import com.idea.zad.constants.C;
import com.idea.zad.model.Lecture;

import java.util.ArrayList;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public class DatabaseHelper extends SQLiteOpenHelper {
	private String pathToSaveDBFile;

	private DatabaseHelper() {
		super(MyApp.getContext(), C.DATABASE_NAME, null, C.DATABASE_VERSION);

		pathToSaveDBFile = new StringBuilder()
				.append(MyApp.getContext().getFilesDir().getAbsolutePath())
				.append("/")
				.append(C.DATABASE_NAME)
				.toString();
	}

	private static DatabaseHelper sInstance;
	public synchronized static DatabaseHelper getInstance(){
		if (sInstance == null)
			sInstance = new DatabaseHelper();
		return sInstance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onCreate(db);
	}

	private enum OpenDb{
		READONLY,
		READ_WRITE
	}
	
	private SQLiteDatabase getDataBase(OpenDb open){
		SQLiteDatabase db = null;
		switch (open){
			case READONLY:
				
				db = SQLiteDatabase.openDatabase(
						pathToSaveDBFile,
						null,
						SQLiteDatabase.OPEN_READONLY
				);
				break;

			case READ_WRITE:
				db = SQLiteDatabase.openDatabase(
						pathToSaveDBFile,
						null,
						SQLiteDatabase.OPEN_READWRITE);
		}

		return db;
	}

	public int getVersionId() {
		SQLiteDatabase db = getDataBase(OpenDb.READONLY);
		Cursor cursor = db.rawQuery(C.VERSION_QUERY, null);
		cursor.moveToFirst();
		int v =  cursor.getInt(0);
		cursor.close();
		db.close();
		return v;
	}

	public int toggleFavorite(int id, boolean isFavorite) {
        int fav = isFavorite ? 0 : 1;

        ContentValues values = new ContentValues();
		values.put(C.KEY_IS_FAVORITE, fav);

        return getDataBase(OpenDb.READ_WRITE).update(C.TABLE_ZAD,
                        values,
                        C.KEY_ID + " = ?",
                        new String[]{String.valueOf(id)}
                );
	}

	public ObservableSource<ArrayList<Lecture>> search(final String key){
		return new ObservableSource<ArrayList<Lecture>>() {
			@Override
			public void subscribe(Observer observer) {
				observer.onNext(doSearch(key));
			}
		};
	}

	private ArrayList<Lecture> doSearch(String searchKeyWord){
		ArrayList<Lecture> lectures = new ArrayList<>();

		// If empty, don't search
		if (searchKeyWord.isEmpty())
			return lectures;

		Cursor c = getDataBase(OpenDb.READONLY).query(
				C.TABLE_ZAD,
				null,
				C.KEY_TITLE + " LIKE '%" + searchKeyWord + "%'",
				null, null, null, null, null);

		lectures = getLectures(c);
		return lectures;
	}

	public int updateLecture(Lecture lecture){
        ContentValues values = new ContentValues();
        values.put(C.KEY_DETAILS, lecture.getDetails());

       return getDataBase(OpenDb.READ_WRITE).update(
                C.TABLE_ZAD,
                values,
                C.KEY_ID + " =?",
                new String[]{String.valueOf(lecture.getId())}
        );
    }
	
	public ArrayList<Lecture> getLecturesByCategory(int categoryIndex){
		Cursor c = getDataBase(OpenDb.READONLY).query(
				C.TABLE_ZAD,
				null,
				C.KEY_CATEGORY + " =?",
				new String[]{String.valueOf(categoryIndex)},
				null, null, null, null);
		
		return getLectures(c);
	}

	public ArrayList<Lecture> getFavoriteLectures(){
		Cursor c = getDataBase(OpenDb.READONLY).query(
				C.TABLE_ZAD,
				null,
				C.KEY_IS_FAVORITE + " =?",
				new String[]{"1"},
				null, null, null, null);

		return getLectures(c);
	}

	public Lecture getLectureForPreview(){
        Cursor c = getDataBase(OpenDb.READONLY).query(
                C.TABLE_ZAD,
                null,
                C.KEY_CATEGORY + " =?",
                new String[]{"1"},
                null, null, null, null);
        return getLectures(c).get(0);
    }

	private ArrayList<Lecture> getLectures(Cursor c) {
		ArrayList<Lecture> lectures = new ArrayList<>();
		Lecture lecture;
		if (c.moveToFirst()) {
			// The Cursor is now set to the right position
			do {
				lecture = new Lecture();
				lecture.setId(c.getInt(0));
				lecture.setTitle(c.getString(1));
				lecture.setDetails(c.getString(2));
				lecture.setFavorite(c.getInt(3) == 1);
				lecture.setCategoryId(c.getInt(4));

				lectures.add(lecture);
			} while (c.moveToNext());
		}
		c.close();
		getDataBase(OpenDb.READONLY).close();
		return lectures;
	}

	public String getPathToSaveDBFile() {
		return pathToSaveDBFile;
	}
}
