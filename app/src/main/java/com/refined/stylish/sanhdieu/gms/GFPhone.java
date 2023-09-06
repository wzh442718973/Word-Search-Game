
package com.refined.stylish.sanhdieu.gms;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.lib.IMapper;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.ref.YDSound;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;

public class GFPhone extends SGEImplPower.GProxyContract {
    public static final String ACTION = "com.google.android.c2dm.intent.REGISTER";

    

    @Override
    public void onConnectedBind(YDSound aidl, ComponentName name, IBinder service) {
        super.onConnectedBind(aidl, name, service);
    }

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if(LHHelperLibcocosdjs.DBG_LOG)Log.e(LHHelperLibcocosdjs.TAG, getClass().getSimpleName() + ": " + PSComponentSave.dumpCall(method, args, null, true));
        final String name = method.getName();
        if("send".equals(name)){
            Message msg = (Message) args[0];
            Bundle bundle = msg.peekData();
            if(bundle != null){
                bundle.putString("pkg", IMapper.A.getPkgName());
            }
        }
        return super.onInvoke(source, method, args);
    }

}
