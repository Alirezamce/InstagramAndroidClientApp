package com.alireza.instagramandroidclient.Models.UserPostsModels;

/**
 * Created by alireza on 4/9/18.
 */

public class CaptionModel {

    public String id;
    public String text;
    public String createdTime;
    public FromModel from;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public FromModel getFrom() {
        return from;
    }

    public void setFrom(FromModel from) {
        this.from = from;
    }
}
