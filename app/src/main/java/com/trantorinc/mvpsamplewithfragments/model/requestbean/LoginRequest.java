package com.trantorinc.mvpsamplewithfragments.model.requestbean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("device_token")
    @Expose
    private String deviceToken;
    @SerializedName("device_type")
    @Expose
    private String deviceType;

    /**
     * @param accessToken
     * @param email
     * @param deviceType
     * @param deviceToken
     * @param password
     */
    public LoginRequest(String email, String password, String accessToken, String deviceToken, String deviceType) {
        super();
        this.email = email;
        this.password = password;
        this.accessToken = accessToken;
        this.deviceToken = deviceToken;
        this.deviceType = deviceType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

}