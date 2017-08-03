package com.idea.zad.database;

import android.util.Log;

import com.idea.zad.common.MyApp;
import com.idea.zad.constants.C;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public final class CopyDataBase {
    private static String TAG = "CopyDataBase";

    public static void prepareDatabase(){
        try {
            boolean isExisted = isDbExisted();
            if(isExisted) {
                int currentDBVersion = DatabaseHelper.getInstance().getVersionId();
                if (C.DATABASE_VERSION > currentDBVersion) {
                    deleteDb();
                    copyDataBase();
                }
            }
            else
                copyDataBase();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static boolean isDbExisted() throws Exception {
        File file = new File(DatabaseHelper.getInstance().getPathToSaveDBFile());
        return file.exists();
    }


    private static void copyDataBase() throws IOException {
        OutputStream os = new FileOutputStream(DatabaseHelper.getInstance().getPathToSaveDBFile());
        InputStream is = MyApp.getContext().getAssets().open("sqlite/"+ C.DATABASE_NAME);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
        is.close();
        os.flush();
        os.close();
    }

    private static void deleteDb() {
        File file = new File(DatabaseHelper.getInstance().getPathToSaveDBFile());
        if(file.exists()) {
            file.delete();
            Log.e(TAG, "Database deleted.");
        }
    }


}
