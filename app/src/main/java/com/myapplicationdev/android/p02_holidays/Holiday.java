package com.myapplicationdev.android.p02_holidays;

public class Holiday {

    private String hol;
    private String date;

    public Holiday(String hol, String date) {
        this.hol = hol;
        this.date = date;
    }
    public String getHol() {
        return hol;
    }
    public String getDate() {
        return date;
    }
}
