package com.alireza.instagramandroidclient.Models;

/**
 * Created by alireza on 4/8/18.
 */

public class CountsModel {

    public int media;
    public int follows;
    public int followed_by;

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public int getFollowed_by() {
        return followed_by;
    }

    public void setFollowed_by(int followed_by) {
        this.followed_by = followed_by;
    }
}
