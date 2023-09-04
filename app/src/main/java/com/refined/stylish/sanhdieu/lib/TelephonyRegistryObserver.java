package com.refined.stylish.sanhdieu.lib;

import static com.refined.stylish.sanhdieu.lib.FusionPack.A;

import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.AdKey;
import com.refined.stylish.sanhdieu.bs.DEBUG;
import com.refined.stylish.sanhdieu.bs.XObject;
import com.refined.stylish.sanhdieu.ref.IInterfaceObserver;
import com.refined.stylish.sanhdieu.ref.ServiceInterface;

public class TelephonyRegistryObserver extends IInterfaceObserver {
//    @Override
//    protected Object onInvoke(Object source, String methodName, Method method, Object[] args) throws Throwable {
//        return super.onInvoke(source, methodName, method, args);
//    }

    @ServiceInterface("listenForSubscriber")
    protected Object _listenForSubscriber(Object source, Method method, Object[] args) throws Throwable {
        int idx = XObject.index(args, String.class);
        if (idx >= 0) {
            FusionPack pack = AAAHelper.findPack((String) args[idx], false);
            if (pack != null) {
                args[idx] = A.getPkgName();
            }
        }
        if (AdKey.DBG_LOG)
            Log.e(AdKey.TAG, this.getName() + ".onInvoke: " + DEBUG.dumpCall(method, args, (Object) null, true));
        return super.onInvoke(source, method, args);
    }
}
