package com.refined.stylish.sanhdieu.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.refined.stylish.sanhdieu.domain.usecases.UseCaseExecutor;
import com.refined.stylish.sanhdieu.presentation.AndroidUseCaseExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abdularis on 18/07/17.
 */

@Module
public class AppModule {

    private Application mApp;

    public AppModule(Application application) {
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
    UseCaseExecutor provideUseCaseExecutor() {
        return new AndroidUseCaseExecutor();
    }

}
