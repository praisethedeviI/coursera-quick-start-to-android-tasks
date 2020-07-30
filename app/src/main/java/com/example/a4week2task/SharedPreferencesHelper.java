package com.example.a4week2task;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class SharedPreferencesHelper {
    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String USER_CHOICE_KEY = "USER_CHOICE_KEY";

    private SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context ctx) {
        mSharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public String getSearchEngine() {
        String name = mSharedPreferences.getString(USER_CHOICE_KEY, "");
        return name == null ? "Google" : name;
    }

    public void changeChoice(String newName) {
        String name = getSearchEngine();
        if (!name.equals(newName)) {
            mSharedPreferences.edit().putString(USER_CHOICE_KEY, newName).apply();
        }
    }
}
