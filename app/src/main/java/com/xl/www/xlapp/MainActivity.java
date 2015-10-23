package com.xl.www.xlapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends TitleBarActivity {

    String s;
    private Button tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        showLeftBar(true);
//        showAttachBar(true, "退出");
        tv = (Button) findViewById(R.id.textview);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.equals("");
            }
        });
    }

    @Override
    protected void onTitleBarItemClicked(View v) {

    }
}
