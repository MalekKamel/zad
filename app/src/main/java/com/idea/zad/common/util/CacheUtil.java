package com.idea.zad.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by sha on 22/10/16.
 */

public final class CacheUtil {
    private static String IMG_EXTENSION_JPEG = ".jpeg";
    private static String JSON_EXTENSION = ".json";

    public static void addTextToDiskCache(String fileName, String text) {
        try {
            File imgFile = new File(getCacheDir(), fileName);
            imgFile.getParentFile().mkdirs();
            FileOutputStream out = new FileOutputStream(imgFile);
            out.write(text.getBytes());
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addImageToDiskCache(String fileName, Bitmap imageStream) {
        try {
            File imgFile = new File(getCacheDir(), fileName + IMG_EXTENSION_JPEG);
            imgFile.getParentFile().mkdirs();
            FileOutputStream out = new FileOutputStream(imgFile);
            imageStream.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap getImageFromDiskCache(String fileName) {
        try {
            File cacheDir = getCacheDir();
            if (cacheDir == null) return null;

            File imageFile = new File(cacheDir, fileName + IMG_EXTENSION_JPEG);
            if (!imageFile.exists()) return null;

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static boolean deleteFromDiskCache(String fileName) {
       return new File(getCacheDir(), fileName + IMG_EXTENSION_JPEG).delete();
    }

    private static File getCacheDir() {
        if (!isExternalStorageWritable()) return null;
        File dir = new File(Environment.getExternalStorageDirectory() + "/Differences");
        if (!dir.exists()) dir.mkdir();
        return dir;
    }

    private static boolean isExternalStorageWritable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ||
                Environment.MEDIA_SHARED.equals(Environment.getExternalStorageState());
    }
}
