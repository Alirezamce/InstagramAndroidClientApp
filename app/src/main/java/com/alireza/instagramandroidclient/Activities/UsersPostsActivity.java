package com.alireza.instagramandroidclient.Activities;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alireza.instagramandroidclient.Adapters.UserPostsListAdapter;
import com.alireza.instagramandroidclient.Constants;
import com.alireza.instagramandroidclient.Interfaces.UserApiInterface;
import com.alireza.instagramandroidclient.Models.UserPostsModels.DatumModel;
import com.alireza.instagramandroidclient.Models.UserPostsModels.UserPostsResponseModel;
import com.alireza.instagramandroidclient.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alireza on 4/9/18.
 */

public class UsersPostsActivity extends AppCompatActivity {

    private RecyclerView userPostsList;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_posts);
        userPostsList = findViewById(R.id.user_posts_list);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("please wait...");

        getPostsFromInstagram();
    }

    private void getPostsFromInstagram() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();

        UserApiInterface apiInterface =
                retrofit.create(UserApiInterface.class);

        SharedPreferences prefs =
                getSharedPreferences(Constants.APP_DOMAIN, MODE_PRIVATE);
        String mainToken = prefs.getString(Constants.TOKEN, "");
        Call<UserPostsResponseModel> call =
                apiInterface.userPostsCall(mainToken);

        progressDialog.show();

        call.enqueue(new Callback<UserPostsResponseModel>() {
            @Override
            public void onResponse(Call<UserPostsResponseModel> call, Response<UserPostsResponseModel> response) {
                Toast.makeText(UsersPostsActivity.this, "success", Toast.LENGTH_LONG).show();
                progressDialog.hide();
                int code = response.code();
                if (code == 200){
                    UserPostsResponseModel model =
                            response.body();
                    Toast.makeText(UsersPostsActivity.this, "success", Toast.LENGTH_LONG).show();
                    loadList(model.getData());

                }
            }

            @Override
            public void onFailure(Call<UserPostsResponseModel> call, Throwable t) {
                progressDialog.hide();
                Toast.makeText(UsersPostsActivity.this, "failed", Toast.LENGTH_LONG).show();


            }
        });

    }

    private void loadList(List<DatumModel> models) {
        UserPostsListAdapter adapter = new UserPostsListAdapter(models);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());



        userPostsList.setLayoutManager(mLayoutManager);
//        providersList.setItemAnimator(new DefaultItemAnimator());


        userPostsList.setAdapter(adapter);
    }
}
