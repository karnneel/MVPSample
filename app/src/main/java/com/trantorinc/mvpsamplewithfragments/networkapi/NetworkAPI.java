package com.trantorinc.mvpsamplewithfragments.networkapi;


import com.trantorinc.mvpsamplewithfragments.model.requestbean.LoginRequest;
import com.trantorinc.mvpsamplewithfragments.model.resposebean.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import static com.trantorinc.mvpsamplewithfragments.utilities.Constants.LOGIN;

public interface NetworkAPI {


    @POST(LOGIN)
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

}