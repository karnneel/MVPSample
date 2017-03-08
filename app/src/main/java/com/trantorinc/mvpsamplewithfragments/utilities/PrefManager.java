/**
 *
 */
package com.trantorinc.mvpsamplewithfragments.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * @author neelmani.karn
 */
public final class PrefManager {

    private static SharedPreferences prefs;
    private Editor editor;

    private static PrefManager instance = new PrefManager();
    private static Context context;

    public static PrefManager getInstance(Context ctx) {
        context = ctx;
        prefs = ctx.getSharedPreferences(Constants.APP_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return instance;
    }


    public void storeString(String key, String value) {
        editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return prefs.getString(key, "");
    }

    public void storeInteger(String key, int value) {
        editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInteger(String key) {
        return prefs.getInt(key, 0);
    }

    public void storeBoolean(String key, boolean value) {
        editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key) {
        return prefs.getBoolean(key, false);
    }


    /**
     * @return Application's version code from the {@code PackageManager}.
     */
    public String getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    public void clearAllPreferences() {
        editor = prefs.edit();
        editor.clear();
        editor.apply();
    }


}