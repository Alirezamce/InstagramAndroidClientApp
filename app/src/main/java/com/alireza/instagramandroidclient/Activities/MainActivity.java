package com.alireza.instagramandroidclient.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alireza.instagramandroidclient.R;

/**
 * Created by alireza on 4/8/18.
 */

public class MainActivity extends AppCompatActivity {

    private Button userInfoButton;
    private Button usersPostsButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        userInfoButton = findViewById(R.id.user_info_button);
        usersPostsButton = findViewById(R.id.user_posts_button);

        final Intent intent = getIntent();

        String accessToken = intent.getStringExtra("access_token");

        userInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(MainActivity.this,UserInfoActivity.class);
                startActivity(intent1);



            }
        });

        usersPostsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,UsersPostsActivity.class);
                startActivity(intent1);

            }
        });


    }
}
