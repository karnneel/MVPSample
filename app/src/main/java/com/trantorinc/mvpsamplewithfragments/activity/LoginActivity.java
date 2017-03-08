package com.trantorinc.mvpsamplewithfragments.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.trantorinc.mvpsamplewithfragments.R;
import com.trantorinc.mvpsamplewithfragments.fragments.LoginFragment;

/**
 * Created by Neelmani.Karn on 3/8/2017.
 */

public class LoginActivity extends AppCompatActivity {

    ConstraintLayout loginLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginLayout = (ConstraintLayout) findViewById(R.id.loginLayout);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new LoginFragment()).commit();
        }
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = getCurrentFocus();
        if (view == null) {
            view = new View(this);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void ShowSnackbar(String title) {
        Snackbar snackbar = Snackbar.make(loginLayout, title, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
