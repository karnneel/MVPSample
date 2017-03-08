package com.trantorinc.mvpsamplewithfragments.model.resposebean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Neelmani.Karn on 1/31/2017.
 */

public class CommonResponse {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;

    /**
     *
     * @return
     *     The code
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code
     *     The code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return
     *     The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     *     The message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
