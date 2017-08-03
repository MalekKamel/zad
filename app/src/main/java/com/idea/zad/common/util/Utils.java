package com.idea.zad.common.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.idea.zad.R;
import com.idea.zad.common.MyApp;
import com.idea.zad.common.eventbus.EventBustAction;
import com.idea.zad.constants.C;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by sha on 14/04/17.
 */

public class Utils implements C {
    
    /**
     * Check network availability
     */
    public static boolean isNetworkAvailable(Context context, boolean isNotifyNetworkOff) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) return true;
        if (isNotifyNetworkOff)
            toast(R.string.connect_to_network, context);
        return false;
    }
    
    /**
     * Display a Toast
     * for classes that aren't subclasses of BaseActivity
     * @param msgRes message resource
     */
    public static void toast(int msgRes, Context context) {
        Toast.makeText(
                context,
                context.getString(msgRes),
                Toast.LENGTH_SHORT
        ).show();
    }
    public static void toast(int msgRes) {
        Toast.makeText(
                MyApp.getContext(),
                MyApp.getContext().getString(msgRes),
                Toast.LENGTH_SHORT
        ).show();
    }
    /**
     * Display a Toast
     * for classes that aren't subclasses of BaseActivity
     */
    public static void toast(String msgString, Context context) {
        Toast.makeText(
                context,
                msgString,
                Toast.LENGTH_SHORT
        ).show();
    }

    /**
     * Used to replace any arabic numbers with english
     * numbers as the keyboards of latest Android versions
     * display arabic numbers instead of english in arabic
     * configuration and backend can't understand arabic digits
     * @param value string that may contain arabic digits
     * @return a string with english digits only
     */
    public static String toEn(String value){
        return
                (((((((((((value)
                        .replaceAll("١", "1"))
                        .replaceAll("٢", "2"))
                        .replaceAll("٣", "3"))
                        .replaceAll("٤", "4"))
                        .replaceAll("٥", "5"))
                        .replaceAll("٦", "6"))
                        .replaceAll("٧", "7"))
                        .replaceAll("٨", "8"))
                        .replaceAll("٩", "9"))
                        .replaceAll("٠", "0"));
    }

    /**
     * Utility method for SharedPreferences
     */
    public static void putIntInPrefs(String key, int i, Context context) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putInt(key, i)
                .apply();
    }
    /**
     * Utility method for SharedPreferences
     */
    public static void putBooleanInPrefs(String key, boolean b, Context context) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(key, b)
                .apply();
    }
    /**
     * Utility method for SharedPreferences
     */
    public static boolean getBooleanFromPrefs(String key, Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, false);
    }

    /**
     * Utility method for SharedPreferences
     */
    public static int getIntFromPrefs(String key, Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(key, -1);
    }
    
    /**
     * Utility method for SharedPreferences
     */
    public static void putStringInPrefs(String key, String s, Context context) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(key, s)
                .apply();
    }
    /**
     * Utility method for SharedPreferences
     */
    public static void deleteStringFromPrefs(String key, Context context) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .clear()
                .apply();
    }
    
    /**
     * Utility method for SharedPreferences
     */
    public static String getStringFromPrefs(String key, Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key, null);
    }

    public static String titledValue(int titleRes, String val, Context context){
        return new StringBuilder(context.getString(titleRes))
                .append(" : ")
                .append(val)
                .toString();
    }

    /**
     * Create a title and value separated with colon
     * then append a unit
     * @param titleRes title resource
     * @param val value
     * @return a string in format : (title : value)
     * @param unitRes unit resource
     */
    public static String titledUnitedValue(int titleRes, String val, int unitRes, Context context){
        return new StringBuilder(context.getString(titleRes))
                .append(" : ")
                .append(val)
                .append(" ")
                .append(context.getString(unitRes))
                .toString();
    }

    /**
     * Create a title and value separated with colon
     * then append a unit
     * @param title string
     * @param val value
     * @return a string in format : (title : value)
     * @param unitRes unit resource
     */
    public static String titledUnitedValue(String title, String val, int unitRes, Context context){
        return new StringBuilder(title)
                .append(" : ")
                .append(val)
                .append(" ")
                .append(context.getString(unitRes))
                .toString();
    }

    /**
     * Create a value and unit separated with colon
     * then append a unit
     * @param val value
     * @return a string in format : (title : value)
     * @param unitRes unit resource
     */
    public static String unitedValue(String val, int unitRes, Context context){
        return new StringBuilder(val)
                .append(" ")
                .append(context.getString(unitRes))
                .toString();
    }

    /**
     * Check if the EditText is empty.
     * If empty set error indicating
     * that field is required
     * @param input edit text
     * @return true if empty
     */
    public static boolean isEditTxtEmpty(EditText input, Context context) {

        String txt = input.getText().toString();
        if (TextUtils.isEmpty(txt)) {
            input.setError(context.getString(R.string.required));
            return true;
        } else {
            resetInput(input);
            return false;
        }
    }

    /**
     * Restore default state of EditText.
     * Typically remove any error if found
     * @param input Edit text
     */
    public static void resetInput(EditText input) {
        input.setError(null);
    }

    /**
     * Check if the mail the user entered is valid or not.
     * If not set error indicating the mail is wrong
     * @param inputEmail the field
     * @return true if valid
     */
    public static boolean isValidMail(EditText inputEmail, Context context) {
        String email = inputEmail.getText().toString();

        if (isEditTxtEmpty(inputEmail, context)) return false;
        int indexOfAt = email.indexOf("@");
        if (
                !email.contains("@") ||
                        indexOfAt < 2 ||
                        !email.contains(".") ||
                        email.indexOf(".") ==  ++indexOfAt ||
                        email.length() < 10){
            inputEmail.setError(context.getString(R.string.email_invalid));
            return false;
        }
        else resetInput(inputEmail);
        return true;
    }

    /**
     * Check if the mail the user entered is valid or not.
     * If not set error indicating the phone number is wrong
     * @param inputPhone the field
     * @return true if valid
     */
    public static boolean isValidPhone(EditText inputPhone, Context context) {
        if (isEditTxtEmpty(inputPhone, context)) return false;

        if (inputPhone.getText().toString().length() != 11){
            inputPhone.setError(context.getString(R.string.phone_incorrect));
            return false;
        }
        return true;
    }
   
    /**
     * Check if the mail the user entered is valid or not.
     * If not set error indicating the password is wrong
     * @param inputPassword the field
     * @return true if valid
     */
    public static boolean isValidPassword(EditText inputPassword, EditText inputPasswordConfirm, Context context) {
        boolean isValid = true;
        if (isEditTxtEmpty(inputPassword, context)) isValid = false;
        if (isEditTxtEmpty(inputPasswordConfirm, context)) isValid = false;

        if (!isValid) return false;

        String pass = inputPassword.getText().toString();
        String passConfirm = inputPasswordConfirm.getText().toString();

        if (!pass.equals(passConfirm)) {
            String error = context.getString(R.string.passwords_not_identical);
            inputPassword.setError(error);
            inputPasswordConfirm.setError(error);
            isValid = false;
        } else {
            resetInput(inputPassword);
            resetInput(inputPasswordConfirm);
        }
        return isValid;
    }

    /**
     * Get Edit Text String with english digits only
     * @param input the field
     * @return String with english digits only
     */
    public static String getTxtOfEditTxt(EditText input){
        return toEn(input.getText().toString().trim());
    }

    public static Animation getAnim(int res, Context context) {
        return AnimationUtils.loadAnimation(context, res);
    }

    public static boolean isValidCreditNum(EditText inputCreditNum, Context context) {
        if (isEditTxtEmpty(inputCreditNum, context)) return false;
        int length = getTxtOfEditTxt(inputCreditNum).length();
        if (length != 16){
            inputCreditNum.setError(context.getString(R.string.credit_num_length_incorrect));
            return false;
        }
        resetInput(inputCreditNum);
        return true;
    }

    public static boolean isValidCvv(EditText inputCvv, Context context) {
        if (isEditTxtEmpty(inputCvv, context)) return false;
        int length = getTxtOfEditTxt(inputCvv).length();
        if (length != 3){
            inputCvv.setError(context.getString(R.string.credit_cvv_length_incorrect));
            return false;
        }
        resetInput(inputCvv);
        return true;
    }

    public static boolean isValidExpiryDate(EditText inputExpiryMonth, EditText inputExpiryYear, Context context) {
        boolean isValid = true;

        if (isEditTxtEmpty(inputExpiryMonth, context)) isValid = false;
        if (isEditTxtEmpty(inputExpiryYear, context)) isValid = false;
        if (!isValid) return false;

        String error = context.getString(R.string.error_two_digits);

        String month = getTxtOfEditTxt(inputExpiryMonth);
        if (month.length() != 2){
            isValid = false;
            inputExpiryMonth.setError(error);
        }
        String year = getTxtOfEditTxt(inputExpiryYear);
        if (year.length() != 2){
            isValid = false;
            inputExpiryYear.setError(error);
        }

        return isValid;
    }

    public static ContentValues contentValueObj(String key, String val) {
        ContentValues obj = new ContentValues();
        obj.put(key, val);
        return obj;
    }


    public static void toggleKeyBoard(Context context, boolean isShow, View view) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (isShow)
            imm.showSoftInput(view, 0);
        else
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    public static void hideKeyboard(Context context, Window window) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(window.getDecorView().getWindowToken(), 0);
    }


    public static boolean isValidForm(Context context, EditText... ets) {
        boolean isValid = true;
        for(EditText et : ets){
            if (isEditTxtEmpty(et, context)) isValid = false;
        }
        return isValid;
    }

    public static void postEventBusMsg(Object event) {
        EventBus.getDefault().post(event);
    }

    public static void postEventBusMsg(EventBusTag messageType) {
        EventBus.getDefault().post(new EventBustAction(messageType));
    }

    public static String roundTwoNum(double d) {
        return String.format(Locale.US, "%.2f", d);
    }

    public static String getDateTimeFormat(){
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }

    public static String formatTime(long time) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);

        int seconds = c.get(Calendar.SECOND);
        int minutes = c.get(Calendar.MINUTE);

        String formattedMinutes, formattedSeconds;

        if (minutes < 10)
            formattedMinutes = "0" + minutes;
        else
            formattedMinutes = String.valueOf(minutes);

        if (seconds < 10)
            formattedSeconds = "0" + seconds;
        else
            formattedSeconds = String.valueOf(seconds);

        return new StringBuilder(formattedMinutes)
                .append(":")
                .append(formattedSeconds)
                .toString();
    }

    public static String loadJsonFromAsset(String fileName) {
        String jsonString;
        try {
            InputStream is = MyApp.getContext().getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return jsonString;
    }

    public static String getCategoryDrawableName(int num){
        return new StringBuilder()
                .append("bg_category_item_")
                .append(num)
                .toString();
    }

    public static int getDrawableIndentifier(String name){
      return   MyApp.getContext()
                .getResources()
                .getIdentifier(
                        name,
                        "drawable",
                        MyApp.getContext().getPackageName()
                );
    }


    private int getCurrentAppVersion() {
        int currVersion = 0;
        try {
            return MyApp.getContext().getPackageManager().getPackageInfo(MyApp.getContext().getPackageName(), 0).versionCode;
        }
        catch (Exception e) {
            e.printStackTrace();
            return currVersion;
        }
    }

    public static void openAppInMarketApp(String query, Activity activity) {
        Intent intent = new Intent(
                "android.intent.action.VIEW",
                Uri.parse("market://details?id=" + query));
        activity.startActivity(intent);
    }

    public static void searchInMarketApp(String query, Activity activity) {
        Intent intent = new Intent(
                "android.intent.action.VIEW",
                Uri.parse("market://doSearch?q=" + query));

        activity.startActivity(intent);
    }

    public static void searchInMarketSite(String query, Activity activity) {
        try{
            Intent intent = new Intent(
                    "android.intent.action.VIEW",
                    Uri.parse("https://play.google.com/store/doSearch?q=" + query));
            activity.startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void openAppInMarketSite(String query, Activity activity) {
        try{
            Intent intent = new Intent(
                    "android.intent.action.VIEW",
                    Uri.parse("https://play.google.com/store/apps/details?id=" + query));
            activity.startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static float dpToPx(float n) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                n,
                MyApp.getContext().getResources().getDisplayMetrics());
    }

    public static float pxToDp(float n) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_PX,
                n,
                MyApp.getContext().getResources().getDisplayMetrics());
    }

    public static String getAppVersionName(){
        try
        {
            return MyApp.getContext()
                    .getPackageManager()
                    .getPackageInfo(MyApp.getContext().getPackageName(), 0)
                    .versionName;
        }
        catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void createIntentChooser(String uriString, String title, Activity activity){
        Intent intent = new Intent(
                "android.intent.action.VIEW",
                Uri.parse(uriString)
        );
        activity.startActivity(Intent.createChooser(intent, title));
    }

    public static Bitmap decodeResource(int res){
        return  BitmapFactory.decodeResource(
                MyApp.getContext().getResources(),
                res,
                null);
    }

    public static String formatColor(int color){
        return String.format("%08x", color);
    }
}
