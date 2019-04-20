package com.lsm.databindingtest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Worker extends BaseObservable {
    private String mLastName;
    private String mFirstName;
    private boolean mIsFired=false;

    public Worker(String mLastName, String mFirstName) {
        this.mLastName = mLastName;
        this.mFirstName = mFirstName;
    }
    @Bindable
    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
        notifyPropertyChanged(BR.lastName);
    }
    @Bindable
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
        notifyPropertyChanged(BR.firstName);
    }
    @Bindable
    public boolean getFired() {
        return mIsFired;
    }

    public void setFired(boolean mIsFired) {
        this.mIsFired = mIsFired;
        //刷新所有有关的ui
//        notifyChange();
    }
}
