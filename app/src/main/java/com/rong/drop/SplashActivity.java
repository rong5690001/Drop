package com.rong.drop;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rong.drop.businesss.activity.BudGetCreateActivity;
import com.rong.drop.utils.PreferencesUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (PreferencesUtils.INSTANCE.getBoolean(PreferencesUtils.INSTANCE.getKEY_HAS_BUDGET(), false)) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, BudGetCreateActivity.class));
                }
                finish();
            }
        }, 1500);
    }
}
