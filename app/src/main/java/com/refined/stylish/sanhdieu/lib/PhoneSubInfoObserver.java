package com.refined.stylish.sanhdieu.lib;

import static com.refined.stylish.sanhdieu.lib.FusionPack.A;

import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.AdKey;
import com.refined.stylish.sanhdieu.bs.DEBUG;
import com.refined.stylish.sanhdieu.bs.XObject;
import com.refined.stylish.sanhdieu.ref.IInterfaceObserver;

public class PhoneSubInfoObserver extends IInterfaceObserver {
    //IPhoneSubInfo

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        int idx = XObject.lastIndex(args, String.class);
        if (idx >= 0 && null != AAAHelper.findPack((String) args[idx], false)) {
            args[idx] = A.getPkgName();
        }
        if (AdKey.DBG_LOG)
            Log.e(AdKey.TAG, "PhoneSubInfo.callInvoke: " + DEBUG.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }
}
