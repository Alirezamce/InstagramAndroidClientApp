package com.alireza.instagramandroidclient.Models.UserPostsModels;

/**
 * Created by alireza on 4/9/18.
 */

public class ImagesModel {

    public ThumbnailModel thumbnail;
    public LowResolutionModel lowResolution;
    public StandardResolutionModel standardResolution;

    public ThumbnailModel getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailModel thumbnail) {
        this.thumbnail = thumbnail;
    }

    public LowResolutionModel getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(LowResolutionModel lowResolution) {
        this.lowResolution = lowResolution;
    }

    public StandardResolutionModel getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(StandardResolutionModel standardResolution) {
        this.standardResolution = standardResolution;
    }
}
