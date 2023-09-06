
package com.refined.stylish.sanhdieu.gms;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.content.ComponentName;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.ref.YDSound;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;

public class MSSave extends SGEImplPower.GProxyContract {

    public static final String ACTION = "com.google.android.gms.ads.identifier.service.START";


    @Override
    public void onConnectedBind(YDSound aidl, ComponentName name, IBinder service) {
        aidl.setAidlClass("com.google.android.gms.internal.ads_identifier.zzf");
        aidl.setStubClass("com.google.android.gms.internal.ads_identifier.zze");

        super.onConnectedBind(aidl, name, service);
    }

    @Override
    public boolean transact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.transact(code, data, reply, flags);
    }

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if(LHHelperLibcocosdjs.DBG_LOG)Log.e(LHHelperLibcocosdjs.TAG, getClass().getSimpleName() + ": " + PSComponentSave.dumpCall(method, args, null, true));
        Object result = super.onInvoke(source, method, args);
        return result;
    }
}
