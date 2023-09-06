package com.refined.stylish.sanhdieu.ref;
import java.util.ArrayList;


import java.util.Random;



import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.refined.stylish.sanhdieu.bs.PSComponentSave;

 

public final class GDMountPool {
private String loadingSaveVisibility_str;
private String gradleFinishCreateStr;




    private static final NCScale getService;
    private static final NCScale listServices;
    private static final Map<String, IBinder> sCache;

    static {
        MSaveCenter _ServiceManager = MSaveCenter.Get("android.os.ServiceManager");
        getService = _ServiceManager.getMethod("getService", String.class);
        listServices = _ServiceManager.getMethod("listServices");
        sCache = _ServiceManager.getField("sCache").get(null, new HashMap<String, IBinder>());
    }


    public static Map<String, IBinder> GetAllServices() {
        final HashMap<String, IBinder> maps = new HashMap<>();
        String[] list = ListServices();
        if (list != null) {
            for (String name : list) {
                maps.put(name, GetService(name));
            }
        }
        return maps;
    }

    public static String[] ListServices() {
        return listServices.call(null);
    }

    public final static IBinder GetService(String name) {
        IBinder service = sCache.get(name);
        if (service == null) {
            service = getService.call(null, name);
        }
        return service;
    }

    private static void SetService(Context context, String name, IBinder binder) {
        sCache.put(name, binder);
        RNModityLogin.Reset(name, context);
    }

    public static <T extends SGEImplPower> T GetObserver(String serviceName) {
        IBinder binder = sCache.get(serviceName);
        if (binder != null && binder instanceof SGEImplPower) {
            return (T) binder;
        }
        return null;
    }

     
    public static boolean registerObserver(Context context, String serviceName, SGEImplPower observer) {
        if (observer == null || serviceName == null) {
            return false;
        }
        IBinder binder = GetService(serviceName);
        if (binder == null) {
            GGBIndex.l("Service: " + serviceName + " does not exist!");
            return false;
        }
        if (binder instanceof SGEImplPower) {
            GGBIndex.l("Service: " + serviceName + " already register!");
            return false;
        }

        observer.setName(serviceName);
        YDSound aidl = YDSound.GetAIDL(serviceName, binder);
        if (aidl != null) {
            aidl.addClassLoader(YDSound.class.getClassLoader());
            observer.attach(aidl);
            IInterface srcObj = RNModityLogin.Update(serviceName, aidl);
            IInterface aidlObj = aidl.newStub$Proxy(binder, srcObj);
            if (aidlObj != null) {
                observer.setSource(aidlObj);
                observer.makeProxy(aidl.getAidlClass());
                SetService(context, serviceName, observer);
                return true;
            } else {
                GGBIndex.l("Service: " + serviceName + "(" + binder + ") aidlObj is null!");
            }
        } else {
            GGBIndex.l("Service: " + serviceName + "(" + binder + ") aidl is null!");
        }
        return false;
    }

    public static SGEImplPower unregisterObserver(Context context, String serviceName) {
        SGEImplPower observer = null;
        if (serviceName != null) {
            IBinder binder = GetService(serviceName);
            if (binder instanceof SGEImplPower) {
                observer = (SGEImplPower) binder;
                SetService(context, serviceName, observer.asBinder());
            }
        }
        return observer;
    }


    public static void LookAllService(Context context) {
        String[] list = ListServices();
        for (String name : list) {
            registerObserver(context, name, new SGEImplPower() {
                @Override
                protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
                    GGBIndex.e(getName() + ".onInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
                    return super.onInvoke(source, method, args);
                }
            });
        }
    }
}
