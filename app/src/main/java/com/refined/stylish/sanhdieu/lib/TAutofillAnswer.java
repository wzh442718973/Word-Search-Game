package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.content.Intent;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;

public class TAutofillAnswer extends SGEImplPower {
HashMap<String,Long> hashStartedDictionary;
String heightChar_h5Str;



    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, Intent.class);
        if (idx >= 0) {
            final Intent intent = (Intent) args[idx];
            IMapper dvd = HAfterAttrs.findPack(RHSourceBroker.getPkgName(intent), false);
            if (dvd != null) {
                RHSourceBroker.setComponent(intent, IMapper.A.getPkgName(), null);
            }
        }
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, this.getName() + ".onInvoke: " + PSComponentSave.dumpCall(method, args, (Object) null, true));
        return super.onInvoke(source, method, args);
    }
}
