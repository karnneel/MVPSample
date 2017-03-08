package com.trantorinc.mvpsamplewithfragments.views;

import com.trantorinc.mvpsamplewithfragments.model.resposebean.LoginResponse;

/**
 * Created by Neelmani.Karn on 3/8/2017.
 */

public interface LoginView {
    /**
     * Show the progress dialog when network operation is running in background.
     */
    void showProgress();

    /**
     * Dismiss progress dialog when network operation executed.
     */
    void hideProgress();

    /**
     * After successfull login pass the login result to UI.
     *
     * @param loginResponse LoginResponse model object is parameter which provided by network operations.
     */
    void showLoginResult(LoginResponse loginResponse);

    /**
     * Show the login error when credentials are wrong.
     *
     * @param statusCode like 404 when credentials are wrong.
     * @param message    it is a string message which come in response.
     */
    void showLoginErrorResult(int statusCode, String message);

    /**
     * Throw the error like {@link java.net.UnknownHostException}, {@link java.net.SocketTimeoutException}
     *
     * @param throwable object of {@link Throwable}
     */
    void showLoginServerError(Throwable throwable);

    /**
     * Show the error message in {@link android.support.design.widget.Snackbar}
     *
     * @param message error message provided by response.
     */
    void showSnackBar(String message);

    /**
     * Show error message when email id is empty.
     *
     * @param message String message.
     */
    void setUsernameError(String message);

    /**
     * Show error message when password field is empty.
     *
     * @param message error message
     */
    void setPasswordError(String message);

    /**
     * Show error message when email id is invalid.
     *
     * @param message error message regarding invalid email id.
     */
    void setInvalidEmailError(String message);

    /**
     * Navigate to {@link com.trantorinc.mvpsamplewithfragments.activity.MainActivity} after successful login.
     */
    void navigateToHomeScreen();
}