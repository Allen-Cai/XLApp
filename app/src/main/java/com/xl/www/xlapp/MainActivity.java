package com.xl.www.xlapp;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends TitleBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showLeftBar(true);
        showAttachBar(true, "退出");


    }

    @Override
    protected void onTitleBarItemClicked(View v) {

    }
}
