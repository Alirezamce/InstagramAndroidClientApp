package com.alireza.instagramandroidclient.Models.UserPostsModels;

import com.alireza.instagramandroidclient.Models.MetaModel;

import java.util.List;

/**
 * Created by alireza on 4/9/18.
 */

public class UserPostsResponseModel {

    public PaginationModel pagination;
    public List<DatumModel> data = null;
    public MetaModel meta;

    public PaginationModel getPagination() {
        return pagination;
    }

    public void setPagination(PaginationModel pagination) {
        this.pagination = pagination;
    }

    public List<DatumModel> getData() {
        return data;
    }

    public void setData(List<DatumModel> data) {
        this.data = data;
    }

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }
}
