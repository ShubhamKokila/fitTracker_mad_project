package com.anoop.healthchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("FIT TRACKER");

//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();
//        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(MainActivity.this, Home.class);
                startActivity(i);
                finish();
            }
        }, 3000);


    }
}