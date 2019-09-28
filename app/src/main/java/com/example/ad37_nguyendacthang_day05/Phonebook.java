package com.example.ad37_nguyendacthang_day05;

import java.io.Serializable;

public class Phonebook implements Serializable {
    private String phoneNumber;
    private String location;
    private String date;
    private String icon;


    public String isIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Phonebook(String icon, String phoneNumber, String location, String date) {
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.date = date;
        this.icon = icon;
    }

    public Phonebook(String date, String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
