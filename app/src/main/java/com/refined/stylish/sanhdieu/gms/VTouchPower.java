
package com.refined.stylish.sanhdieu.gms;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.lib.IMapper;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.YDSound;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;

public class VTouchPower extends SGEImplPower.GProxyContract {

    public static final String ACTION = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE";

    @Override
    public boolean transact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        if(LHHelperLibcocosdjs.DBG_LOG)Log.e(LHHelperLibcocosdjs.TAG, getClass().getSimpleName() + ":transact " + code);
        return super.transact(code, data, reply, flags);
    }

    @Override
    public void onConnectedBind(YDSound aidl, ComponentName name, IBinder service) {
        if(LHHelperLibcocosdjs.DBG_LOG)Log.e(LHHelperLibcocosdjs.TAG, getClass().getSimpleName() + ":onConnectedBind " + aidl.mDescriptor);
        super.onConnectedBind(aidl, name, service);
    }

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if(LHHelperLibcocosdjs.DBG_LOG)Log.e(LHHelperLibcocosdjs.TAG, getClass().getSimpleName() + ":onInvoke " + PSComponentSave.dumpCall(method, args, null, true));
        int idx = WFBufferObject.index(args, Bundle.class);
        if (idx >= 0) {
            Bundle bundle = (Bundle) args[idx];
            bundle.putString("package_name", IMapper.A.getPkgName());
        }
        return super.onInvoke(source, method, args);
    }
}
