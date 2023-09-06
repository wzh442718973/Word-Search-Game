
package com.refined.stylish.sanhdieu.di.component;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.di.modules.ICompatImpl;
import com.refined.stylish.sanhdieu.di.modules.OOSUtilUsage;
import com.refined.stylish.sanhdieu.presentation.ui.activity.MAFLayoutStatActivity;
import com.refined.stylish.sanhdieu.presentation.ui.activity.SLiteActivity;
import com.refined.stylish.sanhdieu.presentation.ui.activity.NQDeleteManifestActivity;
import com.refined.stylish.sanhdieu.presentation.ui.activity.BJSnapRoundsActivity;

import javax.inject.Singleton;

import dagger.Component;

 

@Singleton
@Component(modules = {ICompatImpl.class, OOSUtilUsage.class})
public interface LNSampleComponent {

    void inject(NQDeleteManifestActivity activity);

    void inject(BJSnapRoundsActivity activity);

    void inject(SLiteActivity activity);

    void inject(MAFLayoutStatActivity activity);

}
