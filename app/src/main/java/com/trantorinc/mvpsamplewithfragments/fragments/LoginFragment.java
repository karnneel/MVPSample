package com.trantorinc.mvpsamplewithfragments.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trantorinc.mvpsamplewithfragments.R;
import com.trantorinc.mvpsamplewithfragments.activity.LoginActivity;
import com.trantorinc.mvpsamplewithfragments.activity.MainActivity;
import com.trantorinc.mvpsamplewithfragments.model.requestbean.LoginRequest;
import com.trantorinc.mvpsamplewithfragments.model.resposebean.LoginResponse;
import com.trantorinc.mvpsamplewithfragments.presenter.LoginPresenterImplementation;
import com.trantorinc.mvpsamplewithfragments.views.LoginView;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import static com.trantorinc.mvpsamplewithfragments.utilities.Constants.DEVICE_TYPE;

/**
 * Created by Neelmani.Karn on 3/8/2017.
 */

public class LoginFragment extends BaseFragment implements LoginView, View.OnClickListener {

    private LoginPresenterImplementation presenter;
    private EditText email, password;
    private Button loginBtn;

    /**
     * Called to do initial creation of a fragment.  This is called after
     * {@link #onAttach(Activity)} and before
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * <p>
     * <p>Note that this can be called while the fragment's activity is
     * still in the process of being created.  As such, you can not rely
     * on things like the activity's content view hierarchy being initialized
     * at this point.  If you want to do work once the activity itself is
     * created, see {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>Any restored child fragments will be created before the base
     * <code>Fragment.onCreate</code> method returns.</p>
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginPresenterImplementation(getActivity(), this, service);
    }

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p>
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login, container, false);

        email = (EditText) rootView.findViewById(R.id.et_email);
        password = (EditText) rootView.findViewById(R.id.et_password);
        loginBtn = (Button) rootView.findViewById(R.id.btn_login);

        loginBtn.setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (networkConnectivity.isInternetConnectionAvaliable())
                    presenter.login(new LoginRequest(email.getText().toString().trim(), password.getText().toString().trim(), "", "", DEVICE_TYPE));
                else
                    ((LoginActivity) getActivity()).ShowSnackbar(getString(R.string.noInternet));
                break;
        }
    }

    /**
     * Show the progress dialog when network operation is running in background.
     */
    @Override
    public void showProgress() {
        pd.show();
    }

    /**
     * Dismiss progress dialog when network operation executed.
     */
    @Override
    public void hideProgress() {
        pd.dismiss();
    }

    /**
     * After successfull login pass the login result to UI.
     *
     * @param loginResponse LoginResponse model object is parameter which provided by network operations.
     */
    @Override
    public void showLoginResult(LoginResponse loginResponse) {
        hideProgress();
        Toast.makeText(getActivity(), loginResponse.getMessage(), Toast.LENGTH_SHORT).show();

        navigateToHomeScreen();
    }

    /**
     * Show the login error when credentials are wrong.
     *
     * @param statusCode like 404 when credentials are wrong.
     * @param message    it is a string message which come in response.
     */
    @Override
    public void showLoginErrorResult(int statusCode, String message) {
        hideProgress();
        ((LoginActivity) getActivity()).ShowSnackbar(message);
    }

    /**
     * Throw the error like {@link UnknownHostException}, {@link SocketTimeoutException}
     *
     * @param throwable object of {@link Throwable}
     */
    @Override
    public void showLoginServerError(Throwable throwable) {
        hideProgress();
        if (throwable instanceof UnknownHostException || throwable instanceof SocketTimeoutException) {
            ((LoginActivity) getActivity()).ShowSnackbar(getString(R.string.serverError));
        }
    }

    /**
     * Show the error message in {@link Snackbar}
     *
     * @param message error message provided by response.
     */
    @Override
    public void showSnackBar(String message) {
        hideProgress();
        ((LoginActivity) getActivity()).ShowSnackbar(message);
    }

    /**
     * Show error message when email id is empty.
     *
     * @param message String message.
     */
    @Override
    public void setUsernameError(String message) {
        ((LoginActivity) getActivity()).hideKeyboard();
        ((LoginActivity) getActivity()).ShowSnackbar(message);
        email.requestFocus();
    }

    /**
     * Show error message when password field is empty.
     *
     * @param message error message
     */
    @Override
    public void setPasswordError(String message) {
        ((LoginActivity) getActivity()).hideKeyboard();
        ((LoginActivity) getActivity()).ShowSnackbar(message);
        password.requestFocus();
    }

    /**
     * Show error message when email id is invalid.
     *
     * @param message error message regarding invalid email id.
     */
    @Override
    public void setInvalidEmailError(String message) {
        ((LoginActivity) getActivity()).hideKeyboard();
        ((LoginActivity) getActivity()).ShowSnackbar(message);
        email.requestFocus();
    }

    /**
     * Navigate to {@link MainActivity} after successful login.
     */
    @Override
    public void navigateToHomeScreen() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }
}