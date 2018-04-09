package com.alireza.instagramandroidclient.Interfaces;

import com.alireza.instagramandroidclient.Models.UserInfoResponseModel;
import com.alireza.instagramandroidclient.Models.UserPostsModels.UserPostsResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alireza on 4/9/18.
 */

public interface UserApiInterface {


    @GET("v1/users/self")
    Call<UserInfoResponseModel> userInfoResponseModelCall(@Query("access_token") String authToken);

    @GET("v1/users/self/media/recent")
    Call<UserPostsResponseModel> userPostsCall (@Query("access_token") String authToken);
}
