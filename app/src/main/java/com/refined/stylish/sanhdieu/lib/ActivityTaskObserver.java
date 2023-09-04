package com.refined.stylish.sanhdieu.lib;

import static com.refined.stylish.sanhdieu.lib.FusionPack.A;

import android.content.Intent;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.AdKey;
import com.refined.stylish.sanhdieu.bs.DEBUG;
import com.refined.stylish.sanhdieu.bs.XObject;
import com.refined.stylish.sanhdieu.ref.IInterfaceObserver;
import com.refined.stylish.sanhdieu.ref.ServiceInterface;

/**
 * android10兼容
 */
public class ActivityTaskObserver extends IInterfaceObserver {

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if (AdKey.DBG_LOG)
            Log.e(AdKey.TAG, "ActivityTask.onInvoke: " + DEBUG.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }

    @ServiceInterface("startActivityAsUser")
    protected Object _startActivityAsUser(Object source, Method method, Object[] args) throws Throwable {
        return _startActivity(source, method, args);
    }

    @ServiceInterface("startActivity")
    protected Object _startActivity(Object source, Method method, Object[] args) throws Throwable {
        int idx = XObject.index(args, Intent.class);
        if (idx > 0) {
            final Intent intent = (Intent) args[idx];
            FusionPack dvd = AAAHelper.findPack(Android.getPkgName(intent), false);
            if (dvd != null) {
                Android.setComponent(intent, FusionPack.A.getPkgName(), null);
            }
        }
        args[1] = A.getPkgName();
        return super.onInvoke(source, method, args);
    }

    @ServiceInterface("getTaskForActivity")
    protected Object _getTaskForActivity(Object source, Method method, Object[] args) throws Throwable {
//        Log.e("andy", "_getTaskForActivity");
        return 1;
//        return super.onInvoke(source, method, args);
    }

    @ServiceInterface("registerReceiverWithFeature")
    protected Object _registerReceiverWithFeature(Object source, Method method, Object[] args) throws Throwable {
        int idx = XObject.index(args, String.class);
        if (idx > 0) {
            FusionPack dvd = AAAHelper.findPack((String) args[idx], false);
            if (dvd != null) {
				args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }
}