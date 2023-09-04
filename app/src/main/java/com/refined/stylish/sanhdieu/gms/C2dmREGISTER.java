package com.refined.stylish.sanhdieu.gms;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.AdKey;
import com.refined.stylish.sanhdieu.lib.FusionPack;
import com.refined.stylish.sanhdieu.bs.DEBUG;
import com.refined.stylish.sanhdieu.ref.AIDL;
import com.refined.stylish.sanhdieu.ref.IInterfaceObserver;

public class C2dmREGISTER extends IInterfaceObserver.IConnection {
    public static final String ACTION = "com.google.android.c2dm.intent.REGISTER";

    //android.os.IMessenger

    @Override
    public void onConnectedBind(AIDL aidl, ComponentName name, IBinder service) {
        super.onConnectedBind(aidl, name, service);
    }

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if(AdKey.DBG_LOG)Log.e(AdKey.TAG, getClass().getSimpleName() + ": " + DEBUG.dumpCall(method, args, null, true));
        final String name = method.getName();
        if("send".equals(name)){
            Message msg = (Message) args[0];
            Bundle bundle = msg.peekData();
            if(bundle != null){
                bundle.putString("pkg", FusionPack.A.getPkgName());
            }
        }
        return super.onInvoke(source, method, args);
    }

}
