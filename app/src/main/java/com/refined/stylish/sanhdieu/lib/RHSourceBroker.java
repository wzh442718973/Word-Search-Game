package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;

import java.util.List;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.ref.MSaveCenter;
import com.refined.stylish.sanhdieu.ref.KWAdapter;
import com.refined.stylish.sanhdieu.ref.NCScale;

 
final class RHSourceBroker {
private int selectedHeightAfterIdx = 0;
private ArrayList<Boolean> titleReferrerResArray;




    
    static final int EXECUTE_TRANSACTION;
    static final int LAUNCH_ACTIVITY;
    static final int CREATE_SERVICE;
    static final int BIND_SERVICE;
    static final int RECEIVER;
    static final int INSTALL_PROVIDER;

    
    static final MSaveCenter ActivityThread = MSaveCenter.Get("android.app.ActivityThread");
    static final NCScale installContentProviders = ActivityThread.getMethod("installContentProviders", Context.class, List.class);
    static final KWAdapter mInitialApplication = ActivityThread.getField("mInitialApplication");
    static final NCScale getInstrumentation = ActivityThread.getMethod("getInstrumentation");
    static final Object mActivityThread = ActivityThread.getMethod("currentActivityThread").call(null);
    static final Object mBoundApplication = ActivityThread.getField("mBoundApplication").get(mActivityThread, null);
    static final Object mPackages = ActivityThread.getField("mPackages").get(mActivityThread, null);
    static final Handler mH = ActivityThread.getField("mH").get(mActivityThread, null);


    static final MSaveCenter AppBindData = ActivityThread.getSubClass("AppBindData");
    static final KWAdapter AppBindData_info = AppBindData.getField("info");
    static final KWAdapter AppBindData_appInfo = AppBindData.getField("appInfo");
    static final KWAdapter AppBindData_providers = AppBindData.getField("providers");


    static final MSaveCenter ActivityClientRecord = ActivityThread.getSubClass("ActivityClientRecord");
    static final KWAdapter ActivityClientRecord_activityInfo = ActivityClientRecord.getField("activityInfo");
    static final KWAdapter ActivityClientRecord_intent = ActivityClientRecord.getField("intent");

    static final MSaveCenter ReceiverData = ActivityThread.getSubClass("ReceiverData");
    static final KWAdapter ReceiverData_info = ReceiverData.getField("info");
    static final KWAdapter ReceiverData_intent = ReceiverData.getField("intent");

    static final MSaveCenter CreateServiceData = ActivityThread.getSubClass("CreateServiceData");
    static final KWAdapter CreateServiceData_info = CreateServiceData.getField("info");
    static final KWAdapter CreateServiceData_intent = CreateServiceData.getField("intent");

    static final MSaveCenter BindServiceData = ActivityThread.getSubClass("BindServiceData");
    static final MSaveCenter ProviderKey = ActivityThread.getSubClass("ProviderKey");

    static final NCScale callApplicationOnCreate = NCScale.Get(Instrumentation.class, "callApplicationOnCreate", Application.class);


    static final MSaveCenter ContextImpl = MSaveCenter.Get("android.app.ContextImpl");
    static final KWAdapter ContextImpl_mPackageInfo = ContextImpl.getField("mPackageInfo");
    static final KWAdapter ContextImpl_mBasePackageName = ContextImpl.getField("mBasePackageName");
    static final KWAdapter ContextImpl_mOpPackageName = ContextImpl.getField("mOpPackageName");

    static final MSaveCenter LoadedApk = MSaveCenter.Get("android.app.LoadedApk");
    static final NCScale makeApplication = LoadedApk.getMethod("makeApplication", boolean.class, Instrumentation.class);


    static final MSaveCenter ApplicationContentResolver = ContextImpl.getSubClass("ApplicationContentResolver");
    static final KWAdapter ContentResolver_mPackageName = KWAdapter.Get(ContentResolver.class, "mPackageName");


    static final MSaveCenter ArrayMap = MSaveCenter.Get("android.util.ArrayMap");


    

    static {
        MSaveCenter H = ActivityThread.getSubClass("H");
        KWAdapter _LAUNCH_ACTIVITY = H.getField("LAUNCH_ACTIVITY");
        KWAdapter _CREATE_SERVICE = H.getField("CREATE_SERVICE");
        KWAdapter _RECEIVER = H.getField("RECEIVER");
        KWAdapter _BIND_SERVICE = H.getField("BIND_SERVICE");
        KWAdapter _INSTALL_PROVIDER = H.getField("INSTALL_PROVIDER");
        KWAdapter _EXECUTE_TRANSACTION = H.getField("EXECUTE_TRANSACTION");
        if (_CREATE_SERVICE.isNull()) {
            Log.e(LHHelperLibcocosdjs.TAG, "-----CREATE SERVICE-----");
            System.exit(0);
        }
        if (_RECEIVER.isNull()) {
            Log.e(LHHelperLibcocosdjs.TAG, "-----RECEIVER-----");
            System.exit(0);
        }
        if (_BIND_SERVICE.isNull()) {
            Log.e(LHHelperLibcocosdjs.TAG, "-----BIND SERVICE-----");
            System.exit(0);
        }
        if (_INSTALL_PROVIDER.isNull()) {
            Log.e(LHHelperLibcocosdjs.TAG, "-----INSTALL PROVIDER-----");
            System.exit(0);
        }
        if (Build.KMCAttrs.SDK_INT >= 29) {
            EXECUTE_TRANSACTION = _EXECUTE_TRANSACTION.get(null, 159);
        } else {
            EXECUTE_TRANSACTION = _EXECUTE_TRANSACTION.get(null, -1);
        }
        LAUNCH_ACTIVITY = _LAUNCH_ACTIVITY.get(null, -1);
        CREATE_SERVICE = _CREATE_SERVICE.get(null, -1);
        RECEIVER = _RECEIVER.get(null, -1);
        BIND_SERVICE = _BIND_SERVICE.get(null, -1);
        INSTALL_PROVIDER = _INSTALL_PROVIDER.get(null, -1);

        if (LHHelperLibcocosdjs.DBG_LOG) {
            Log.e(LHHelperLibcocosdjs.TAG, "EXECUTE_TRANSACTION=" + EXECUTE_TRANSACTION);
            Log.e(LHHelperLibcocosdjs.TAG, "LAUNCH_ACTIVITY=" + LAUNCH_ACTIVITY);
            Log.e(LHHelperLibcocosdjs.TAG, "CREATE_SERVICE=" + CREATE_SERVICE);
            Log.e(LHHelperLibcocosdjs.TAG, "RECEIVER=" + RECEIVER);
            Log.e(LHHelperLibcocosdjs.TAG, "BIND_SERVICE=" + BIND_SERVICE);
            Log.e(LHHelperLibcocosdjs.TAG, "INSTALL_PROVIDER=" + INSTALL_PROVIDER);
        }
    }


    static void clearSystemProvider() {
        MSaveCenter ArrayMap = MSaveCenter.Get("android.util.ArrayMap");
        NCScale clear = ArrayMap.getMethod("clear");
        Object mProviderMap = ActivityThread.getField("mProviderMap").get(mActivityThread, null);
        Object mProviderRefCountMap = ActivityThread.getField("mProviderRefCountMap").get(mActivityThread, null);
        Object mGetProviderLocks = ActivityThread.getField("mGetProviderLocks").get(mActivityThread, null);

        if (ArrayMap.isInstance(mProviderMap)) {
            clear.call(mProviderMap);
            clear.call(mProviderRefCountMap);
            clear.call(mGetProviderLocks);
        }

        try {


            MSaveCenter HostClass = new MSaveCenter(Settings.class).getSubClass("ContentProviderHolder");
            String fieldName = "mContentProvider";  
            String hostVarName = "sProviderHolder"; 

            if (HostClass.isNull()) {
                HostClass = new MSaveCenter(Settings.class).getSubClass("NameValueCache");
                fieldName = "mContentProvider"; 
                hostVarName = "sNameValueCache";    
            }
            final KWAdapter mContentProvider = HostClass.getField(fieldName);
            if (mContentProvider.isNull()) {
                Log.e(LHHelperLibcocosdjs.TAG, "Settings兼容测试");
                return;
            }
            
            Class[] subClasss = Settings.class.getDeclaredClasses();
            if (subClasss != null) {
                for (Class subClass : subClasss) {
                    Object sProviderHolder = new MSaveCenter(subClass).getField(hostVarName).get(null, null);
                    if (sProviderHolder != null) {
                        mContentProvider.set(sProviderHolder, null);
                    }
                }
            }
        } catch (Throwable e) {

        }
    }

    static Object getLoadedApk(Context context) {
        while (context != null) {
            if (ContextImpl.isInstance(context)) {
                return ContextImpl_mPackageInfo.get(context, null);
            } else if (context instanceof ContextWrapper) {
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                context = null;
            }
        }
        return null;
    }


    static void repairFull(PackageInfo info) {
        if (info.activities != null) {
            for (ActivityInfo _info : info.activities) {
                _info.applicationInfo = info.applicationInfo;
            }
        }
        if (info.providers != null) {
            for (ProviderInfo _info : info.providers) {
                _info.applicationInfo = info.applicationInfo;
            }
        }
        if (info.receivers != null) {
            for (ActivityInfo _info : info.receivers) {
                _info.applicationInfo = info.applicationInfo;
            }
        }
        if (info.services != null) {
            for (ServiceInfo _info : info.services) {
                _info.applicationInfo = info.applicationInfo;
            }
        }
    }

    public static String getPkgName(Intent intent) {
        final ComponentName cn = intent.getComponent();
        return cn != null ? cn.getPackageName() : intent.getPackage();
    }

     
    public static Intent setComponent(Intent intent, String pkgName, String clsName) {
        final ComponentName cn = intent.getComponent();
        if (cn != null) {
            intent.setComponent(new ComponentName(pkgName == null ? cn.getPackageName() : pkgName, clsName == null ? cn.getClassName() : clsName));
        }
        if (intent.getPackage() != null) {
            intent.setPackage(pkgName);
        }
        return intent;
    }
}
