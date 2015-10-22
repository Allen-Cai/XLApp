package com.xl.www.xlapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by caishengyan on 2015/10/22.
 */
public class SplashActivity extends Activity {

    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mActivity = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Intent intent = new Intent();
                    intent.setClass(mActivity, MainActivity.class);
                    startActivity(intent);
                    mActivity.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
