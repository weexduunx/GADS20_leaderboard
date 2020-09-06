package com.idyndiouck.gads_leaderbord2020;

import android.content.Intent;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                }, 2000);
    }

    @Override
    public void onBackPressed() { // Disable back navigation
    }
}