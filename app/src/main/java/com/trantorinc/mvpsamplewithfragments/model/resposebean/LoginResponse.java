package com.trantorinc.mvpsamplewithfragments.model.resposebean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse extends CommonResponse {

    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("phoneno")
    @Expose
    private String phoneno;
    @SerializedName("user_image")
    @Expose
    private String userImage;
    @SerializedName("isPublicProfile")
    @Expose
    private boolean isPublicProfile;
    @SerializedName("quickblox_password")
    @Expose
    private String quickbloxPassword;


    /**
     * @return The userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId The user_id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth The date_of_birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return The phoneno
     */
    public String getPhoneno() {
        return phoneno;
    }

    /**
     * @param phoneno The phoneno
     */
    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    /**
     * @return The userImage
     */
    public String getUserImage() {
        return userImage;
    }

    /**
     * @param userImage The user_image
     */
    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    /**
     * @return The isPublicProfile
     */
    public boolean isIsPublicProfile() {
        return isPublicProfile;
    }

    /**
     * @param isPublicProfile The isPublicProfile
     */
    public void setIsPublicProfile(boolean isPublicProfile) {
        this.isPublicProfile = isPublicProfile;
    }

    /**
     * @return The quickbloxPassword
     */
    public String getQuickbloxPassword() {
        return quickbloxPassword;
    }

    /**
     * @param quickbloxPassword The quickblox_password
     */
    public void setQuickbloxPassword(String quickbloxPassword) {
        this.quickbloxPassword = quickbloxPassword;
    }
}