package com.refined.stylish.sanhdieu.di.modules;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.refined.stylish.sanhdieu.domain.usecases.NYMatchEntry;
import com.refined.stylish.sanhdieu.presentation.JSService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

 

@Module
public class ICompatImpl {
ArrayList<Boolean> stateUpgradeDirectionArray;
private float logoJobMargin = 0.0f;




    private Application mApp;

    public ICompatImpl(Application application) {
        mApp = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApp;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    NYMatchEntry provideUseCaseExecutor() {
        return new JSService();
    }

}
