package com.trantorinc.mvpsamplewithfragments.presenter;


import android.content.Context;

import com.trantorinc.mvpsamplewithfragments.R;
import com.trantorinc.mvpsamplewithfragments.model.requestbean.LoginRequest;
import com.trantorinc.mvpsamplewithfragments.model.resposebean.LoginResponse;
import com.trantorinc.mvpsamplewithfragments.networkservice.NetworkService;
import com.trantorinc.mvpsamplewithfragments.presenterInterface.LoginPresenterInteractor;
import com.trantorinc.mvpsamplewithfragments.views.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Neelmani.Karn on 2/28/2017.
 */

public class LoginPresenterImplementation implements LoginPresenterInteractor {

    private LoginView view;
    private Context context;
    private NetworkService service;

    public LoginPresenterImplementation(Context context, LoginView view, NetworkService service) {
        this.view = view;
        this.service = service;
        this.context = context;
    }

    @Override
    public void login(LoginRequest loginRequest) {
        if (loginRequest.getEmail().isEmpty()) {
            view.setUsernameError(context.getString(R.string.emptyEmail));
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(loginRequest.getEmail()).matches()) {
            view.setInvalidEmailError(context.getString(R.string.invalidEmail));
            return;
        }
        if (loginRequest.getPassword().isEmpty()) {
            view.setPasswordError(context.getString(R.string.emptyPassword));
            return;
        }

        view.showProgress();

        Call<LoginResponse> loginResponseCall = service.getAPI().login(loginRequest);

        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode() == 200) {
                        view.showLoginResult(response.body());
                    } else {
                        view.showLoginErrorResult(response.body().getCode(), response.body().getMessage());
                    }
                } else {
                    view.showSnackBar(context.getString(R.string.serverError));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                view.showLoginServerError(t);
            }
        });
    }
}