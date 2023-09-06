package com.refined.stylish.sanhdieu.presentation.ui.activity;
import android.widget.TextView;


import android.widget.ImageView;


import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.refined.stylish.sanhdieu.JWifiContent;
import com.refined.stylish.sanhdieu.config.ESensor;

import javax.inject.Inject;

 

@SuppressLint("Registered")
public class MAFLayoutStatActivity extends AppCompatActivity {
private double securityUpdate_pfFullscreenMargin = 0.0;
private String contentZoomMapperStr;




    @Inject
    ESensor mPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((JWifiContent) getApplication()).getAppComponent().inject(this);

        if (mPreferences.enableFullscreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(CNField.LayoutParams.FLAG_FULLSCREEN,
                    CNField.LayoutParams.FLAG_FULLSCREEN);
        }
    }
}
