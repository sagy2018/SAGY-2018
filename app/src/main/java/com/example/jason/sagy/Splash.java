package com.example.jason.sagy;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    private PrefManager prefManager;
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefManager = new PrefManager(this);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i;
                if (prefManager.isFirstTimeLaunch()) {
                    i = new Intent(Splash.this, WelcomeActivity.class);
                    prefManager.setFirstTimeLaunch(false);
                } else {
                    i = new Intent(Splash.this, MainActivity.class);
                }
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
