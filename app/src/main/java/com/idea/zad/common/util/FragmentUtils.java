package com.idea.zad.common.util;

import android.content.ContentValues;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;

import com.idea.zad.constants.C;


/**
 * Created by sha on 14/04/17.
 */

public class FragmentUtils extends Fragment implements UtilsAccess, C {

    @Override
    public void toast(int msgRes) {
        Utils.toast(msgRes, getContext());
    }

    @Override
    public void toast(String msgString) {
        Utils.toast(msgString, getContext());
    }

    @Override
    public void putIntInPrefs(String key, int i) {
        Utils.putIntInPrefs(key, i, getContext());
    }

    @Override
    public void putBooleanInPrefs(String key, boolean b) {
        Utils.putBooleanInPrefs(key, b, getContext());
    }

    @Override
    public boolean getBooleanFromPrefs(String key) {
        return Utils.getBooleanFromPrefs(key, getContext());
    }

    @Override
    public int getIntFromPrefs(String key) {
        return Utils.getIntFromPrefs(key, getContext());
    }

    @Override
    public void putStringInPrefs(String key, String s) {
        Utils.putStringInPrefs(key, s, getContext());
    }

    @Override
    public void deleteStringFromPrefs(String key) {
        Utils.deleteStringFromPrefs(key, getContext());
    }

    @Override
    public String getStringFromPrefs(String s) {
        return Utils.getStringFromPrefs(s, getContext());
    }

    @Override
    public String titledValue(int titleRes, String val){
        return Utils.titledValue(titleRes, val, getContext());
    }

    @Override
    public String titledUnitedValue(int titleRes, String val, int unitRes){
        return Utils.titledUnitedValue(titleRes, val, unitRes, getContext());
    }

    @Override
    public String titledUnitedValue(String title, String val, int unitRes){
        return Utils.titledUnitedValue(title, val, unitRes, getContext());
    }

    @Override
    public String unitedValue(String val, int unitRes){
        return Utils.unitedValue(val, unitRes, getContext());
    }

    @Override
    public boolean isEditTxtEmpty(EditText input) {
        return Utils.isEditTxtEmpty(input, getContext());
    }

    @Override
    public void resetInput(EditText input) {
        Utils.resetInput(input);
    }

    @Override
    public boolean isValidMail(EditText inputEmail) {
        return Utils.isValidMail(inputEmail, getContext());
    }

    @Override
    public boolean isValidPhone(EditText inputPhone) {
        return Utils.isValidPhone(inputPhone, getContext());
    }

    @Override
    public boolean isValidPassword(EditText inputPassword, EditText inputPasswordConfirm) {
        return Utils.isValidPassword(inputPassword, inputPasswordConfirm, getContext());
    }

    @Override
    public String getTxtOfEditTxt(EditText input){
        return Utils.toEn(input.getText().toString().trim());
    }

    @Override
    public Animation getAnim(int res) {
        return Utils.getAnim(res, getContext());
    }

    @Override
    public boolean isValidCreditNum(EditText inputCreditNum) {
        return Utils.isValidCreditNum(inputCreditNum, getContext());
    }

    @Override
    public boolean isValidCvv(EditText inputCvv) {
        return Utils.isValidCvv(inputCvv, getContext());
    }

    @Override
    public boolean isValidExpiryDate(EditText inputExpiryMonth, EditText inputExpiryYear) {
        return Utils.isValidExpiryDate(inputExpiryMonth, inputExpiryYear, getContext());
    }

    @Override
    public ContentValues contentValueObj(String key, String val) {
        return Utils.contentValueObj(key, val);
    }

    @Override
    public void toggleKeyBoard(boolean isShow, View view) {
        Utils.toggleKeyBoard(getContext(), isShow, view);
    }

    @Override
    public boolean isValidForm(EditText... ets) {
        return Utils.isValidForm(getContext(), ets);
    }

    @Override
    public void postEventBusMsg(Object event) {
        Utils.postEventBusMsg(event);
    }

    @Override
    public void postEventBusMsg(EventBusTag messageType) {
        Utils.postEventBusMsg(messageType);
    }
}
