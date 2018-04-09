package com.alireza.instagramandroidclient.Models;

/**
 * Created by alireza on 4/8/18.
 */

public class UserInfoResponseModel {


    public DataModel data;
    public MetaModel meta;

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }

    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }
}
