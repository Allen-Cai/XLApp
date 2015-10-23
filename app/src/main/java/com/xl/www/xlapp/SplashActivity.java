package com.xl.www.xlapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


/**
 * Created by caishengyan on 2015/10/22.
 */
public class SplashActivity extends Activity {

    private Activity mActivity;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mActivity = this;

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {

                    startActivity(new Intent(mActivity, MainActivity.class));
                    mActivity.finish();
                }
            }
        };

        mHandler.sendEmptyMessageDelayed(0, 3000);

    }
}
