package com.alireza.instagramandroidclient.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alireza.instagramandroidclient.AuthenticationDialog;
import com.alireza.instagramandroidclient.Constants;
import com.alireza.instagramandroidclient.Interfaces.AuthenticationListener;
import com.alireza.instagramandroidclient.R;

/**
 * Created by alireza on 4/8/18.
 */

public class StartingActivity extends AppCompatActivity implements AuthenticationListener {

    private Button btn_get_access_token;
    private AuthenticationDialog auth_dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_starting);



        btn_get_access_token = (Button) findViewById(R.id.btn_get_access_token);

        btn_get_access_token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth_dialog = new AuthenticationDialog(StartingActivity.this, StartingActivity.this);
                auth_dialog.setCancelable(true);
                auth_dialog.show();
            }
        });


    }


    @Override
    public void onCodeReceived(String access_token) {
        if (access_token == null) {
            auth_dialog.dismiss();
        }

        Intent i = new Intent(StartingActivity.this, MainActivity.class);
        i.putExtra("access_token", access_token);

        SharedPreferences.Editor editor =
                getSharedPreferences(Constants.APP_DOMAIN,MODE_PRIVATE).edit();
        editor.putString(Constants.TOKEN,access_token);
        editor.apply();

        startActivity(i);

    }



}
