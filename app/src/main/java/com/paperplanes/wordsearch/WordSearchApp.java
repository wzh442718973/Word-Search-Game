package com.paperplanes.wordsearch;

import android.app.Application;
import android.content.Context;

import com.paperplanes.wordsearch.di.component.AppComponent;
import com.paperplanes.wordsearch.di.component.DaggerAppComponent;
import com.paperplanes.wordsearch.di.modules.AppModule;

import dagger.internal.DaggerCollections;

/**
 * Created by abdularis on 18/07/17.
 */

public class WordSearchApp extends Application {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
