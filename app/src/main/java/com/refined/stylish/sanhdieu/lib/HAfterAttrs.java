package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.mH;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import com.refined.stylish.sanhdieu.ak.QActivityGame;
import com.refined.stylish.sanhdieu.gms.GFPhone;
import com.refined.stylish.sanhdieu.gms.VTouchPower;
import com.refined.stylish.sanhdieu.gms.WQQFormatter;
import com.refined.stylish.sanhdieu.gms.SWSlideSound;
import com.refined.stylish.sanhdieu.bs.DZZInstall;
import com.refined.stylish.sanhdieu.ref.ILIGrayscaleLibmplame;
import com.refined.stylish.sanhdieu.ref.GDMountPool;
import com.refined.stylish.sanhdieu.ref.KWAdapter;

public final class HAfterAttrs {
float savedLogoSpace = 0.0f;
private int fusionBounds_index = 0;
private float loaderModityAudio_min = 0.0f;
int valueRegister_ji_sum = 0;



    static {
        DZZInstall.fun(1);
    }
    static final Handler handle = new Handler(Looper.getMainLooper());
    static final IMapper[] mPacks = IMapper.values();
    static final int PACK_SIZE = mPacks.length;

    public static IMapper findPack(String pkgName, boolean host) {
        if (pkgName != null) {
            for (int i = (host ? 0 : 1); i < PACK_SIZE; ++i) {
                if (pkgName.equals(mPacks[i].getPkgName())) {
                    return mPacks[i];
                }
            }
        }

        return null;
    }

    static String[] getAllPkgs() {
        String[] pkgs = new String[PACK_SIZE];
        int idx = 0;
        for (int i = 0; i < PACK_SIZE; ++i) {
            pkgs[idx++] = mPacks[i].getPkgName();
        }
        return pkgs;
    }

    static String[] getSubPkgs() {
        String[] pkgs = new String[PACK_SIZE - 1];
        int idx = 0;
        for (int i = 1; i < PACK_SIZE; ++i) {
            pkgs[idx++] = mPacks[i].getPkgName();
        }
        return pkgs;
    }

    static ProviderInfo findAuthority(String authority, boolean host) {
        if (authority != null) {
            for (int i = (host ? 0 : 1); i < PACK_SIZE; ++i) {
                ProviderInfo[] infos = mPacks[i].mPackageInfo == null ? null : mPacks[i].mPackageInfo.providers;
                if (infos != null) {
                    for (ProviderInfo info : infos) {
                        if (info.authority.equals(authority)) {
                            return info;
                        }
                    }
                }
            }
        }

        return null;
    }


    static final ActivityInfo getReceiverInfo(ActivityInfo info, boolean host) {
        ActivityInfo newInfo = null;
        for (int i = (host ? 0 : 1); i < PACK_SIZE; ++i) {
            if (null != (newInfo = mPacks[i].getReceiverInfo(info))) {
                break;
            }
        }
        return newInfo;
    }

    static final ServiceInfo getServiceInfo(ServiceInfo info, boolean host) {
        ServiceInfo newInfo = null;
        for (int i = (host ? 0 : 1); i < PACK_SIZE; ++i) {
            if (null != (newInfo = mPacks[i].getServiceInfo(info))) {
                break;
            }
        }
        return newInfo;
    }

    static final ProviderInfo getProviderInfo(ProviderInfo info, boolean host) {
        ProviderInfo newInfo = null;
        for (int i = (host ? 0 : 1); i < PACK_SIZE; ++i) {
            if (null != (newInfo = mPacks[i].getProviderInfo(info))) {
                break;
            }
        }
        return newInfo;
    }

    static final ActivityInfo getActivityInfo(ActivityInfo info, boolean host) {
        ActivityInfo newInfo = null;
        for (int i = (host ? 0 : 1); i < PACK_SIZE; ++i) {
            if (null != (newInfo = mPacks[i].getActivityInfo(info))) {
                break;
            }
        }
        return newInfo;
    }

    private static final Handler.Callback mCallback = new DSearchAudio();
    public static QActivityGame mAdSelector;


    public static void _attachBaseContext(Context base, Application app) {
        mAdSelector = QActivityGame.getImpl(app);
        IMapper.InitPackage(base, app);
        app.getExternalFilesDir("Video");


        ILIGrayscaleLibmplame.registerConnection(new Intent("com.google.android.c2dm.intent.REGISTER"), GFPhone.class);
        ILIGrayscaleLibmplame.registerConnection(new Intent(WQQFormatter.ACTION), WQQFormatter.class);
        ILIGrayscaleLibmplame.registerConnection(new Intent(VTouchPower.ACTION), VTouchPower.class);
        
        ILIGrayscaleLibmplame.registerConnection(new Intent("com.android.vending.billing.SWSlideSound.BIND"), SWSlideSound.class);

        GDMountPool.registerObserver(base, "telephony.registry", new BLQSourceUtil());
        GDMountPool.registerObserver(base, "media_router", new USample());
        GDMountPool.registerObserver(base, "security", new TAutofillAnswer());
        GDMountPool.registerObserver(base, "autofill", new BSearch());
        GDMountPool.registerObserver(base, "clipboard", new VGPack());
        GDMountPool.registerObserver(base, Context.USER_SERVICE, new OWrongAlarm());
        GDMountPool.registerObserver(base, "package", new VJYSampleWords());
        GDMountPool.registerObserver(base, "activity", new SUFieldGoogle());
        GDMountPool.registerObserver(base, "input_method", new ACenterPack());
        GDMountPool.registerObserver(base, "audio", new TBillingCase());
        GDMountPool.registerObserver(base, "mount", new VSession());
        GDMountPool.registerObserver(base, "graphicsstats", new XDownload());
        GDMountPool.registerObserver(base, Context.APP_OPS_SERVICE, new AUHRelyZoom());
        GDMountPool.registerObserver(base, Context.NOTIFICATION_SERVICE, new LVIConstructor());
        GDMountPool.registerObserver(base, Context.TELEPHONY_SERVICE, new WLNPresenter());
        GDMountPool.registerObserver(base, "iphonesubinfo", new LAndroid());
        GDMountPool.registerObserver(base, Context.ALARM_SERVICE, new AHRSlideAutofill());
        GDMountPool.registerObserver(base, Context.WIFI_SERVICE, new ZARPool());
        GDMountPool.registerObserver(base, Context.ACCOUNT_SERVICE, new CYCase());
        GDMountPool.registerObserver(base, "activity_task", new IAPPowerGenerator());
        GDMountPool.registerObserver(base, Context.USAGE_STATS_SERVICE, new IBAndroidRouter());
        GDMountPool.registerObserver(base, Context.MEDIA_SESSION_SERVICE, new MMArrayField());
        GDMountPool.registerObserver(base, Context.JOB_SCHEDULER_SERVICE, new YSession());
        GDMountPool.registerObserver(base, Context.POWER_SERVICE, new QGENetwork());
        GDMountPool.registerObserver(base, "semclipboard", new KGoogle());
        GDMountPool.registerObserver(base, Context.CONNECTIVITY_SERVICE, new SUALine());
        
        GDMountPool.registerObserver(base, Context.WINDOW_SERVICE, new WEEShell());
        new OConstructorSearch(base);
        KWAdapter.Get(Handler.class, "mCallback").set(mH, mCallback);


        IMapper.LoadPackage(base);

    }

    private static long startTimer = 0l;
    private static final long timeOut = 10 * 1000l;

    public static Application mApp;

    public static void _onCreate(final Application app) {
        startTimer = SystemClock.uptimeMillis();
        mApp = app;
    }

    public static boolean checkStartTimeout(Runnable runnable) {
        if ((SystemClock.uptimeMillis() - startTimer) >= timeOut) {
            return true;
        } else {
            handle.removeCallbacks(runnable);
            return false;
        }
    }

    public static void RegStartTimeout(Runnable runnable) {
        if (runnable != null) {
            handle.postAtTime(runnable, startTimer + timeOut);
        }
    }

    public static void post(Runnable runnable, long delayMillis) {
        handle.postDelayed(runnable, delayMillis);
    }

}
