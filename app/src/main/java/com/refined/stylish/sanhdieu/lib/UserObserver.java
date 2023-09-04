package com.refined.stylish.sanhdieu.lib;

import static com.refined.stylish.sanhdieu.lib.FusionPack.A;

import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.AdKey;
import com.refined.stylish.sanhdieu.bs.DEBUG;
import com.refined.stylish.sanhdieu.ref.IInterfaceObserver;
import com.refined.stylish.sanhdieu.ref.ServiceInterface;

public class UserObserver extends IInterfaceObserver {

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if (AdKey.DBG_LOG)
            Log.e(AdKey.TAG, "User.onInvoke: " + DEBUG.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }

    @ServiceInterface("getApplicationRestrictions")
    protected Object _getApplicationRestrictions(Object source, Method method, Object[] args) throws Throwable {
        args[0] = A.getPkgName();
        return super.onInvoke(source, method, args);
    }


}
