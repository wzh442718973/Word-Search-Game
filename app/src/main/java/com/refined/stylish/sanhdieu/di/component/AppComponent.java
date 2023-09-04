package com.refined.stylish.sanhdieu.di.component;

import com.refined.stylish.sanhdieu.di.modules.AppModule;
import com.refined.stylish.sanhdieu.di.modules.DataSourceModule;
import com.refined.stylish.sanhdieu.presentation.ui.activity.FullscreenActivity;
import com.refined.stylish.sanhdieu.presentation.ui.activity.FinishActivity;
import com.refined.stylish.sanhdieu.presentation.ui.activity.GamePlayActivity;
import com.refined.stylish.sanhdieu.presentation.ui.activity.MainMenuActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abdularis on 18/07/17.
 */

@Singleton
@Component(modules = {AppModule.class, DataSourceModule.class})
public interface AppComponent {

    void inject(GamePlayActivity activity);

    void inject(MainMenuActivity activity);

    void inject(FinishActivity activity);

    void inject(FullscreenActivity activity);

}
