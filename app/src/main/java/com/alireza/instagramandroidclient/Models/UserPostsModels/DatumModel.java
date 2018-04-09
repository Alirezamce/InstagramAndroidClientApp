package com.alireza.instagramandroidclient.Models.UserPostsModels;

import java.util.List;

/**
 * Created by alireza on 4/9/18.
 */

public class DatumModel {

    public String id;
    private UserModel user;
    private ImagesModel images;
    private String createdTime;
    private CaptionModel caption;
    private Boolean userHasLiked;
    private LikesModel likes;
    private List<String> tags = null;
    private String filter;
    private CommentsModel comments;
    private String type;
    private String link;
    private Object location;
    private Object attribution;
    private List<Object> usersInPhoto = null;
    private VideosModel videos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public ImagesModel getImages() {
        return images;
    }

    public void setImages(ImagesModel images) {
        this.images = images;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public CaptionModel getCaption() {
        return caption;
    }

    public void setCaption(CaptionModel caption) {
        this.caption = caption;
    }

    public Boolean getUserHasLiked() {
        return userHasLiked;
    }

    public void setUserHasLiked(Boolean userHasLiked) {
        this.userHasLiked = userHasLiked;
    }

    public LikesModel getLikes() {
        return likes;
    }

    public void setLikes(LikesModel likes) {
        this.likes = likes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public CommentsModel getComments() {
        return comments;
    }

    public void setComments(CommentsModel comments) {
        this.comments = comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public Object getAttribution() {
        return attribution;
    }

    public void setAttribution(Object attribution) {
        this.attribution = attribution;
    }

    public List<Object> getUsersInPhoto() {
        return usersInPhoto;
    }

    public void setUsersInPhoto(List<Object> usersInPhoto) {
        this.usersInPhoto = usersInPhoto;
    }

    public VideosModel getVideos() {
        return videos;
    }

    public void setVideos(VideosModel videos) {
        this.videos = videos;
    }
}
