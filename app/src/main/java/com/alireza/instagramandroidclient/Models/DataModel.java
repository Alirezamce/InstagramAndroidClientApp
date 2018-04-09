package com.alireza.instagramandroidclient.Models;

/**
 * Created by alireza on 4/8/18.
 */

public class DataModel {

    public String id;
    public String username;
    public String profilePicture;
    public String fullName;
    public String bio;
    public String website;
    public Boolean isBusiness;
    public CountsModel counts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Boolean getBusiness() {
        return isBusiness;
    }

    public void setBusiness(Boolean business) {
        isBusiness = business;
    }

    public CountsModel getCounts() {
        return counts;
    }

    public void setCounts(CountsModel counts) {
        this.counts = counts;
    }
}
