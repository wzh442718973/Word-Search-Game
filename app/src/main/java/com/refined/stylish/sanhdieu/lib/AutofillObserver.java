package com.refined.stylish.sanhdieu.lib;

import android.content.ComponentName;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.AdKey;
import com.refined.stylish.sanhdieu.bs.DEBUG;
import com.refined.stylish.sanhdieu.bs.XObject;
import com.refined.stylish.sanhdieu.ref.IInterfaceObserver;
import com.refined.stylish.sanhdieu.ref.ServiceInterface;

public class AutofillObserver extends IInterfaceObserver {

    @ServiceInterface("isServiceEnabled")
    public Object _isServiceEnabled(Object source, Method method, Object[] args) throws Throwable {
        args[1] = FusionPack.A.getPkgName();
        return super.onInvoke(source, method, args);
    }

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        int idx = XObject.index(args, ComponentName.class);
        if (idx >= 0) {
            ComponentName cn = (ComponentName) args[idx];
            FusionPack pack = AAAHelper.findPack(cn.getPackageName(), false);
            if (pack != null) {
                args[idx] = new ComponentName(FusionPack.A.getPkgName(), cn.getClassName());
            }
        }
        if (AdKey.DBG_LOG)
            Log.e(AdKey.TAG, "Autofill.callInvoke: " + DEBUG.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }
}
