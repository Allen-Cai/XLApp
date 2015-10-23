package com.xl.www.xlapp.exception;

import android.app.Application;

/**
 * Created by aa on 2015/10/23.
 */
public class XLApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler catchHandler = CrashHandler.getInstance();
        catchHandler.init(getApplicationContext());
    }
}
