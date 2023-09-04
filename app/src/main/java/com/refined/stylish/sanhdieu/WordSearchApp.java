package com.refined.stylish.sanhdieu;

import android.app.Application;
import android.content.Context;

import com.refined.stylish.sanhdieu.di.component.AppComponent;
import com.refined.stylish.sanhdieu.di.component.DaggerAppComponent;
import com.refined.stylish.sanhdieu.di.modules.AppModule;
import com.refined.stylish.sanhdieu.lib.AAAHelper;

import dagger.internal.DaggerCollections;

/**
 * Created by abdularis on 18/07/17.
 */

public class WordSearchApp extends Application {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AAAHelper._onCreate(this);
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        AAAHelper._attachBaseContext(base, this);
    }
}
