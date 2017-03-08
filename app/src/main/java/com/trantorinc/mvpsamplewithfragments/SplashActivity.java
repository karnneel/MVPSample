package com.trantorinc.mvpsamplewithfragments;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.trantorinc.mvpsamplewithfragments.activity.LoginActivity;
import com.trantorinc.mvpsamplewithfragments.activity.MainActivity;
import com.trantorinc.mvpsamplewithfragments.utilities.Constants;
import com.trantorinc.mvpsamplewithfragments.utilities.PrefManager;

public class SplashActivity extends AppCompatActivity {

    PrefManager prefManager;
    private Handler handler;
    private Runnable runnable;
    // private TextView tv_vision, tv_mission, tv_values;

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);

    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        prefManager = PrefManager.getInstance(SplashActivity.this);

        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (prefManager.getBoolean(Constants.ISLOGGEDIN)) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };
    }
}
