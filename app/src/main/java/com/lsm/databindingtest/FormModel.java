package com.lsm.databindingtest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

public class FormModel extends BaseObservable {
    private String userName;
    private String passWord;

    public FormModel() {
    }

    public FormModel(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }
    @Bindable
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
        notifyPropertyChanged(BR.passWord);
    }
}
