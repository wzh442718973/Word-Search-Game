package com.refined.stylish.sanhdieu.gms;

import android.content.ComponentName;
import android.os.IBinder;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.lib.AAAHelper;
import com.refined.stylish.sanhdieu.lib.FusionPack;
import com.refined.stylish.sanhdieu.bs.XObject;
import com.refined.stylish.sanhdieu.ref.AIDL;
import com.refined.stylish.sanhdieu.ref.IInterfaceObserver;

public class InAppBillingService extends IInterfaceObserver.IConnection {
    @Override
    public void onConnectedBind(AIDL aidl, ComponentName name, IBinder service) {
//        Log.e(AdKey.TAG, getClass().getSimpleName() + ":onConnectedBind " + aidl.mDescriptor);

        aidl.setAidlClass("com.google.android.gms.internal.play_billing.zze");
        aidl.setStubClass("com.google.android.gms.internal.play_billing.zzd");

        super.onConnectedBind(aidl, name, service);

    }

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        //method == zzr
        int idx = XObject.index(args, String.class);
        if(idx >= 0){
            if(AAAHelper.findPack((String)args[idx], false) != null){
                args[idx] = FusionPack.A.getPkgName();
            }
        }
//        Log.e(AdKey.TAG, getClass().getSimpleName() + ":onInvoke " + DEBUG.dumpCall(method, args));
        Object result = super.onInvoke(source, method, args);
//        if(result != null && result instanceof Bundle){
//            Bundle bundle = (Bundle) result;
//            bundle.setClassLoader(getAidl().getClassLoader()[0]);
//            bundle.getBundle("");
//            Log.e(AdKey.TAG, getClass().getSimpleName() + ":result " + bundle);
//        }

        return result;
    }
}
