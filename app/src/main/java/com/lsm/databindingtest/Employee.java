package com.lsm.databindingtest;

import android.databinding.ObservableField;

public class Employee {
    private String firstName;
    private ObservableField<String> lastName;
    private String avatar;
    private boolean showHeader;

    public Employee(String firstName, String lastName) {
        this.lastName=new ObservableField<>();
        this.firstName = firstName;
        this.lastName.set(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isShowHeader() {
        return showHeader;
    }

    public void setShowHeader(boolean showHeader) {
        this.showHeader = showHeader;
    }
}
