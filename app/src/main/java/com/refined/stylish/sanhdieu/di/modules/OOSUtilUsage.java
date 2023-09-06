package com.refined.stylish.sanhdieu.di.modules;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.content.Context;

import com.refined.stylish.sanhdieu.data.sqlite.ZXProxy;
import com.refined.stylish.sanhdieu.data.sqlite.VGSService;
import com.refined.stylish.sanhdieu.data.sqlite.HTDRectangle;
import com.refined.stylish.sanhdieu.data.xml.WWDurationBoard;
import com.refined.stylish.sanhdieu.domain.data.source.VFusion;
import com.refined.stylish.sanhdieu.domain.data.source.RFLibcocosdjsUsage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

 

@Module
public class OOSUtilUsage {
private boolean can_DirectionViewBuild = false;
double rotationInitializedSize = 0.0;
String referrerInfosInputString;
private double matchVersionMargin = 0.0;




    @Provides
    @Singleton
    ZXProxy provideDbHelper(Context context) {
        return new ZXProxy(context);
    }

    @Provides
    @Singleton
    VFusion provideGameRoundDataSource(ZXProxy dbHelper) {
        return new VGSService(dbHelper);
    }


    @Provides
    @Singleton
    RFLibcocosdjsUsage provideWordDataSource(Context context) {
        return new WWDurationBoard(context);
    }

}
