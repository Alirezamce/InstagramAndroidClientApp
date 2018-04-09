package com.alireza.instagramandroidclient.Activities;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alireza.instagramandroidclient.Constants;
import com.alireza.instagramandroidclient.Interfaces.UserApiInterface;
import com.alireza.instagramandroidclient.Models.UserInfoResponseModel;
import com.alireza.instagramandroidclient.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alireza on 4/8/18.
 */

public class UserInfoActivity extends AppCompatActivity {

    private ImageView userImageview;
    private UserInfoResponseModel model;
    private TextView fullNameTextview;
    private TextView userNameTextview;
    private TextView websiteTextview;
    private TextView bioTextview;
    private ProgressDialog progressDialog;
    private TextView followersTextview;
    private TextView followsTextview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("please wait...");

        userImageview = findViewById(R.id.user_pic_imageview);
        fullNameTextview = findViewById(R.id.full_name_textview);
        userNameTextview = findViewById(R.id.user_name_textview);
        websiteTextview = findViewById(R.id.website_textview);
        bioTextview = findViewById(R.id.bio_textview);
        followersTextview = findViewById(R.id.followers_textview);
        followsTextview = findViewById(R.id.follows_textview);

        getUserInfoFromInstagram();


    }


    private void getUserInfoFromInstagram() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();

        UserApiInterface apiInterface =
                retrofit.create(UserApiInterface.class);

        SharedPreferences prefs =
                getSharedPreferences(Constants.APP_DOMAIN, MODE_PRIVATE);
        String mainToken = prefs.getString(Constants.TOKEN, "");
        Call<UserInfoResponseModel> call =
                apiInterface.userInfoResponseModelCall(mainToken);

        progressDialog.show();

        call.enqueue(new Callback<UserInfoResponseModel>() {
            @Override
            public void onResponse(Call<UserInfoResponseModel> call, Response<UserInfoResponseModel> response) {

                int code = response.code();
                progressDialog.hide();
                if (code == 200) {

                    model = response.body();
                    Toast.makeText(UserInfoActivity.this, "success", Toast.LENGTH_LONG).show();

                    loadUserInfoIntoUI();
                }

            }

            @Override
            public void onFailure(Call<UserInfoResponseModel> call, Throwable t) {
                Toast.makeText(UserInfoActivity.this, "failed", Toast.LENGTH_LONG).show();
                progressDialog.hide();


            }
        });

    }

    private void loadUserInfoIntoUI() {

        followersTextview.setText("followres: " + model.getData().getCounts().getFollowed_by());
        followsTextview.setText("follows: " + model.getData().getCounts().getFollows());

        fullNameTextview.setText(model.getData().getFullName());
        userNameTextview.setText(model.getData().getUsername());
        if (model.getData().getWebsite() != null) {
            websiteTextview.setText(model.getData().getWebsite());
        }

        if (model.getData().getBio() != null) {
            bioTextview.setText(model.getData().getBio());
        }

        if (model.getData().getProfilePicture() != null) {
//            userImageview.setImageURI();
            Picasso.get().load(model.getData().getProfilePicture()).into(userImageview);
        }


//    bioTextview

    }

}
