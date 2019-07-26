package com.example.myreview;

import android.net.Uri;

import com.example.myreview.Rating.UserGeneralInformation;
import com.example.myreview.Rating.UserMoreInformation;

import java.util.Map;

public class User {


    private String userName;
    private String password;
    private Uri avatar;
    private String email;
    private String address;
    private String school;
    private String interests;
    private Map<String, Integer> achievementMap;
    private String dateSignedUp;
    private Map<String, String> idFriendMap;

    private UserGeneralInformation generalInformation;
    private UserMoreInformation moreInformation;


    //TODO add more user feature
    public User(UserGeneralInformation generalInformation, UserMoreInformation moreInformation, String userName, String password, Uri avatar, String email, String address, String school, String interests, String dateSignedUp, Map<String, Integer> achievementMap) {

        this.userName = userName;
        this.password = password;
        this.avatar = avatar;
        this.email = email;
        this.address = address;
        this.school = school;
        this.interests = interests;
        this.achievementMap = achievementMap;
        this.dateSignedUp = dateSignedUp;

        this.generalInformation = generalInformation;

    }


    public UserGeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public UserMoreInformation getMoreInformation() {
        return moreInformation;
    }

    public Uri getAvatar() {
        return avatar;
    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }

    public String getDateSignedUp() {
        return dateSignedUp;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getSchool() {
        return school;
    }

    public String getInterests() {
        return interests;
    }

    public Map<String, Integer> getAchievementMap() {
        return achievementMap;
    }

    public void setAvatar(Uri avatar) {
        this.avatar = avatar;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateSignedUp(String dateSignedUp) {
        this.dateSignedUp = dateSignedUp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setAchievementMap(Map<String, Integer> achievementMap) {
        this.achievementMap = achievementMap;
    }

}