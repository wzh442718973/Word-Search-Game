package com.paperplanes.wordsearch.presentation.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.paperplanes.wordsearch.WordSearchApp;
import com.paperplanes.wordsearch.config.Preferences;

import javax.inject.Inject;

/**
 * Created by abdularis on 21/04/17.
 *
 * Extend this class to make a fullscreen activity
 */

@SuppressLint("Registered")
public class FullscreenActivity extends AppCompatActivity {

    @Inject
    Preferences mPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((WordSearchApp) getApplication()).getAppComponent().inject(this);
//        mPreferences = new Preferences(this, getPreferences(0));

        if (mPreferences.enableFullscreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
}
