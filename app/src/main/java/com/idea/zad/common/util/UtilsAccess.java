package com.idea.zad.common.util;

import android.content.ContentValues;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;

import com.idea.zad.constants.C;

/**
 * Created by sha on 14/04/17.
 */

interface UtilsAccess {

    void toast(int msgRes);

    void toast(String msgString);

    void putIntInPrefs(String key, int i);

    void putBooleanInPrefs(String key, boolean b);

    boolean getBooleanFromPrefs(String key);

    int getIntFromPrefs(String key);

    void putStringInPrefs(String key, String s);

    void deleteStringFromPrefs(String key);

    String getStringFromPrefs(String s);

    String titledValue(int titleRes, String val);

    String titledUnitedValue(int titleRes, String val, int unitRes);

    String titledUnitedValue(String title, String val, int unitRes);

    String unitedValue(String val, int unitRes);

    boolean isEditTxtEmpty(EditText input);

    void resetInput(EditText input);

    boolean isValidMail(EditText inputEmail);

    boolean isValidPhone(EditText inputPhone);

    boolean isValidPassword(EditText inputPassword, EditText inputPasswordConfirm);

    String getTxtOfEditTxt(EditText input);

    Animation getAnim(int res);

    boolean isValidCreditNum(EditText inputCreditNum);

    boolean isValidCvv(EditText inputCvv);

    boolean isValidExpiryDate(EditText inputExpiryMonth, EditText inputExpiryYear);

    ContentValues contentValueObj(String key, String val);

    void toggleKeyBoard(boolean isShow, View view);

    boolean isValidForm(EditText... ets);

    void postEventBusMsg(Object event);

    void postEventBusMsg(C.EventBusTag messageType);
}
