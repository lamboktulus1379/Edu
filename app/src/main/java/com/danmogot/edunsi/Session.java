package com.danmogot.edunsi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    private SharedPreferences prefs;

    public Session(Context cntx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setId(String id) {
        prefs.edit().putString("id", id).commit();
    }

    public String getId() {
        String id = prefs.getString("id","");
        return id;
    }

    public void setUsername(String usename) {
        prefs.edit().putString("usename", usename).commit();
    }

    public String getUsername() {
        String usename = prefs.getString("usename","");
        return usename;
    }

    public void setEmail(String email) {
        prefs.edit().putString("email", email).commit();
    }

    public String getEmail() {
        String email = prefs.getString("email","");
        return email;
    }


    public void setScore(String score) {
        prefs.edit().putString("score", score).commit();
    }

    public String getScore() {
        String score = prefs.getString("score","");
        return score;
    }

    public void setLevel(String level) {
        prefs.edit().putString("level", level).commit();
    }

    public String getLevel() {
        String score = prefs.getString("level","");
        return score;
    }


}
