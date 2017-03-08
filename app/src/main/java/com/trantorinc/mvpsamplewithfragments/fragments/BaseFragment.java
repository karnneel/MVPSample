package com.trantorinc.mvpsamplewithfragments.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.trantorinc.mvpsamplewithfragments.R;
import com.trantorinc.mvpsamplewithfragments.application.RxApplication;
import com.trantorinc.mvpsamplewithfragments.networkservice.NetworkService;
import com.trantorinc.mvpsamplewithfragments.utilities.NetworkConnectivity;

/**
 * Created by Neelmani.Karn on 3/8/2017.
 */

public class BaseFragment extends Fragment {

    NetworkService service;
    NetworkConnectivity networkConnectivity;
    ProgressDialog pd;

    /**
     * Called when a fragment is first attached to its context.
     * {@link #onCreate(Bundle)} will be called after this.
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        service = RxApplication.getNetworkService();
        networkConnectivity = NetworkConnectivity.getInstance(context);

        pd = new ProgressDialog(context);
        pd.setMessage(getString(R.string.logging));
        pd.setIndeterminate(true);
        pd.setCancelable(false);
    }
}