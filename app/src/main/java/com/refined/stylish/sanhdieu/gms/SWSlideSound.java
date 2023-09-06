
package com.refined.stylish.sanhdieu.gms;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.content.ComponentName;
import android.os.IBinder;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.lib.HAfterAttrs;
import com.refined.stylish.sanhdieu.lib.IMapper;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.YDSound;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;

public class SWSlideSound extends SGEImplPower.GProxyContract {
    @Override
    public void onConnectedBind(YDSound aidl, ComponentName name, IBinder service) {

        aidl.setAidlClass("com.google.android.gms.internal.play_billing.zze");
        aidl.setStubClass("com.google.android.gms.internal.play_billing.zzd");

        super.onConnectedBind(aidl, name, service);

    }

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        
        int idx = WFBufferObject.index(args, String.class);
        if(idx >= 0){
            if(HAfterAttrs.findPack((String)args[idx], false) != null){
                args[idx] = IMapper.A.getPkgName();
            }
        }
        Object result = super.onInvoke(source, method, args);

        return result;
    }
}
