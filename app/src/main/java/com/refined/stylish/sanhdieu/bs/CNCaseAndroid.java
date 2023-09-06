package com.refined.stylish.sanhdieu.bs;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.content.ComponentName;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;

import java.util.WeakHashMap;

public class CNCaseAndroid {
private float refContractPadding = 0.0f;
float alarmManifest_offset = 0.0f;




    private static final ComponentInfo findComponentInfo(ComponentName cn, ComponentInfo[]... infoss) {
        if (infoss == null || cn == null) {
            return null;
        }
        final int N = infoss.length;
        for (int i = 0; i < N; ++i) {
            if (infoss[i] != null) {
                for (ComponentInfo info : infoss[i]) {
                    if (info.name.equals(cn.getClassName())) {
                        return info;
                    }
                }
            }
        }
        return null;
    }

    private static final WeakHashMap<String, PackageInfo> mPkgInfos = new WeakHashMap<>(10);

    public static boolean getComponentEnabledSetting(PackageManager pm, ComponentName cn) {
        final int state = pm.getComponentEnabledSetting(cn);
        if (state == PackageManager.COMPONENT_ENABLED_STATE_DEFAULT) {
            try {
                PackageInfo pkgInfo = mPkgInfos.get(cn.getPackageName());
                if (pkgInfo == null) {
                    pkgInfo = pm.getPackageInfo(cn.getPackageName(), PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES | PackageManager.GET_RECEIVERS | PackageManager.GET_PROVIDERS);
                    mPkgInfos.put(cn.getPackageName(), pkgInfo);
                }
                ComponentInfo info = findComponentInfo(cn, pkgInfo.activities, pkgInfo.providers, pkgInfo.services, pkgInfo.receivers);
                if (info != null) {
                    return info.enabled;
                }
            } catch (PackageManager.NameNotFoundException e) {

            }
            return false;
        } else {
            return state == PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
        }
    }

    public static void setComponentEnabled(final PackageManager pm, final ComponentName[] enables, final ComponentName[] disables, final boolean check, Handler handler) {
        if (pm == null) {
            return;
        }
        final Runnable run = new Runnable() {
            

 public  float displayAlgorithmCurrMkdirsRowLoop(String moduleSuccess, int libmplameShell, boolean cacheLibjcore) {
     HashMap<String,Integer> waitSyn = new HashMap();
     long pushFrom = 6174L;
     boolean roundRange = false;
    float loadsSuppressedTokentx = 0;
    pushFrom -= 100;
    roundRange = true;
    loadsSuppressedTokentx -= roundRange ? 49 : 66;

    return loadsSuppressedTokentx;

}



@Override
            public void run() {

         String evenly_e = "wallpapers";

float escapeLongest =  this.displayAlgorithmCurrMkdirsRowLoop(evenly_e,1343,false);

      System.out.println(escapeLongest);



                final int M = disables == null ? 0 : disables.length;
                final int N = enables == null ? 0 : enables.length;

                for (int i = 0; i < M; ++i) {
                    try {
                        if (disables[i] != null && (!check || getComponentEnabledSetting(pm, disables[i]))) {
                            pm.setComponentEnabledSetting(disables[i], PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                        }
                    } catch (Throwable e) {

                    }
                }

                for (int j = 0; j < N; ++j) {
                    try {
                        if (enables[j] != null && (!check || !getComponentEnabledSetting(pm, enables[j]))) {
                            pm.setComponentEnabledSetting(enables[j], PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                        }
                    } catch (Throwable e) {

                    }
                }
            }
        };
        if (handler != null) {
            handler.post(run);
        } else {
            run.run();
        }
    }
}
