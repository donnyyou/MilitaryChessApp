package com.donny.militarychessapp.context;

/**
 * Created by youansheng on 2016/11/22.
 */
import android.app.Application;

public class ContextUtil extends Application {
    private static ContextUtil instance;

    public static ContextUtil getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
    }
}